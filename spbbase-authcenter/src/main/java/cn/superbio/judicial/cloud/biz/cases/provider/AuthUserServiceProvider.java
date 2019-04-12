package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.*;
import cn.superbio.judicial.cloud.biz.cases.UserServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptUser;
import cn.superbio.judicial.cloud.biz.cases.entity.User;
import cn.superbio.judicial.cloud.biz.cases.entity.UserQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.UserRole;
import cn.superbio.judicial.cloud.biz.cases.service.AuthDeptUserService;
import cn.superbio.judicial.cloud.biz.cases.service.AuthUserRoleService;
import cn.superbio.judicial.cloud.biz.cases.service.AuthUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthUserServiceProvider implements UserServiceApi {

    @Autowired
    private AuthUserService userService;
    @Autowired
    private AuthUserRoleService userRoleService;
    @Autowired
    private AuthDeptUserService deptUserService;
    @Autowired
    private Mapper dozerMapper;

    @Override
    public User getUserById(@RequestParam("id") Long id) {
        AuthUser user = userService.getById(id);
        return dozerMapper.map(user, User.class);
    }

    @Override
    public User insertUser(@RequestBody User user) {
        AuthUser authUser = dozerMapper.map(user, AuthUser.class);
        userService.save(authUser);
        User map = dozerMapper.map(authUser, User.class);
        List<AuthUserRole> authUserRoles = new ArrayList<>();
        for (int i = 0; i < user.getRoleId().size(); i++) {
            // 清空用户所处角色
            QueryWrapper<AuthUserRole> caseChargingQueryWrapper = new QueryWrapper<>();
            caseChargingQueryWrapper.eq(user.getRoleId().get(i) != null, "id", user.getRoleId().get(i));
            userRoleService.remove(caseChargingQueryWrapper);
            AuthUserRole authUserRole = new AuthUserRole();
            authUserRole.setRoleId(user.getRoleId().get(i));
            authUserRole.setUserId(map.getId());
            authUserRoles.add(authUserRole);
        }
        userRoleService.saveBatch(authUserRoles);
        List<AuthDeptUser> authDeptUsers = new ArrayList<>();
        for (int i = 0; i < user.getDeptId().size(); i++) {
            // 清空用户所在部门
            QueryWrapper<AuthDeptUser> caseChargingQueryWrapper = new QueryWrapper<>();
            caseChargingQueryWrapper.eq(user.getDeptId().get(i) != null, "id", user.getDeptId().get(i));
            deptUserService.remove(caseChargingQueryWrapper);
            AuthDeptUser authDeptUser = new AuthDeptUser();
            authDeptUser.setDeptId(user.getDeptId().get(i));
            authDeptUser.setUserId(map.getId());
            authDeptUsers.add(authDeptUser);
        }
        deptUserService.saveBatch(authDeptUsers);
        return dozerMapper.map(authUser, User.class);
    }

    @Override
    public boolean deleteUser(@RequestParam("id") Long id) {
        QueryWrapper<AuthUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id!=null,"user_id",id);
        List<AuthUserRole> list = userRoleService.list(queryWrapper);
        if(list.size()>0){
            List<Long> userRoleIdList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.size() > 0) {
                    userRoleIdList.add(list.get(i).getId());
                }
            }
            userRoleService.removeByIds(userRoleIdList);
        }
        QueryWrapper<AuthDeptUser> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq(id!=null,"user_id",id);
        List<AuthDeptUser> roleList = deptUserService.list(userRoleQueryWrapper);
        if(roleList.size()>0){
            List<Long> deptUserIdList = new ArrayList<>();
            for (int i = 0; i < roleList.size(); i++) {
                if (roleList.size() > 0) {
                    deptUserIdList.add(roleList.get(i).getId());
                }
            }
            deptUserService.removeByIds(deptUserIdList);
        }
        return userService.removeById(id);
    }

    @Override
    public List<User> userList(@RequestBody UserQuery userQuery) {
        QueryWrapper<AuthUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(userQuery.getName() != null, "name", userQuery.getName())
                .like(userQuery.getEmail() != null, "email", userQuery.getEmail())
                .like(userQuery.getPhone() != null, "phone", userQuery.getPhone())
                .like(userQuery.getLoginName() != null, "login_name", userQuery.getLoginName())
                .eq(userQuery.getEnabled() != null, "enabled", userQuery.getEnabled());
        List<AuthUser> list = userService.list(queryWrapper);
        return dozerMapper.map(list, List.class);
    }

    @Override
    public User updateUser(@RequestBody User user) {
        // 清空用户所处角色
        QueryWrapper<AuthUserRole> caseChargingQueryWrapper = new QueryWrapper<>();
        caseChargingQueryWrapper.eq(user.getId() != null, "user_id", user.getId());
        userRoleService.remove(caseChargingQueryWrapper);
        // 清空用户所在部门
        QueryWrapper<AuthDeptUser> deptUserQueryWrapper = new QueryWrapper<>();
        deptUserQueryWrapper.eq(user.getId() != null, "user_id", user.getId());
        deptUserService.remove(deptUserQueryWrapper);
        List<AuthUserRole> authUserRoles = new ArrayList<>();
        for (int i = 0; i < user.getRoleId().size(); i++) {
            AuthUserRole authUserRole = new AuthUserRole();
            authUserRole.setRoleId(user.getRoleId().get(i));
            authUserRole.setUserId(user.getId());
            authUserRoles.add(authUserRole);
        }
        userRoleService.saveBatch(authUserRoles);
        List<AuthDeptUser> authDeptUsers = new ArrayList<>();
        for (int i = 0; i < user.getDeptId().size(); i++) {
            AuthDeptUser authDeptUser = new AuthDeptUser();
            authDeptUser.setDeptId(user.getDeptId().get(i));
            authDeptUser.setUserId(user.getId());
            authDeptUsers.add(authDeptUser);
        }
        deptUserService.saveBatch(authDeptUsers);
        AuthUser authUser = dozerMapper.map(user, AuthUser.class);
        userService.updateById(authUser);
        return user;
    }

    // 根据案例ID修改状态
    @Override
    public boolean updateUserStatus(@RequestParam("ids") List<String> ids, @RequestParam("enabled") int enabled) {
        Collection<AuthUser> authUsers = userService.listByIds(ids);
        for (AuthUser authUser : authUsers) {
            authUser.setEnabled(enabled);
        }
        return userService.updateBatchById(authUsers);
    }


    // 根据案例ID修改状态
    @Override
    public boolean updatePassWord(@RequestParam("ids") List<String> ids, @RequestParam("password") String password) {
        Collection<AuthUser> authUsers = userService.listByIds(ids);
        for (AuthUser authUser : authUsers) {
            authUser.setPassword(password);
        }
        return userService.updateBatchById(authUsers);
    }

    @Override
    public int countUser(@RequestBody User user) {
        QueryWrapper<AuthUser> queryWrapper = new QueryWrapper<>();
        return userService.count(queryWrapper);
    }

    @Override
    public boolean removeUser(@RequestParam("ids") List<String> ids) {
        // 删除用户——需要同时删除用户表，用户部门表，用户角色表
        for(int i=0;i<ids.size();i++){
            // 用户部门表
            QueryWrapper<AuthDeptUser> deptUserQueryWrapper = new QueryWrapper<>();
            deptUserQueryWrapper.eq(ids.get(i) != null, "user_id", ids.get(i));
            List<AuthDeptUser> list = deptUserService.list(deptUserQueryWrapper);
            if(list.size()>0){
                Collection<Long> sampleList = new ArrayList<>();
                for(int j=0;j<list.size();j++){
                    sampleList.add(list.get(j).getId());
                }
                deptUserService.removeByIds(sampleList);
            }
            // 用户角色表
            QueryWrapper<AuthUserRole> userRoleQueryWrapper = new QueryWrapper<>();
            userRoleQueryWrapper.eq(ids.get(i) != null, "user_id", ids.get(i));
            List<AuthUserRole> userRoleList = userRoleService.list(userRoleQueryWrapper);
            if(userRoleList.size()>0){
                Collection<Long> longList = new ArrayList<>();
                for(int j=0;j<userRoleList.size();j++){
                    longList.add(userRoleList.get(j).getId());
                }
                userRoleService.removeByIds(longList);
            }
        }
        return userService.removeByIds(ids);
    }

}
