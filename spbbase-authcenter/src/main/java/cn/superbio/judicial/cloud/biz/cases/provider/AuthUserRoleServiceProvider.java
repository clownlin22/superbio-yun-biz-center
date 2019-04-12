package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.AuthUserRole;
import cn.superbio.judicial.cloud.biz.cases.UserRoleServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.UserRole;
import cn.superbio.judicial.cloud.biz.cases.service.AuthUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthUserRoleServiceProvider implements UserRoleServiceApi {


    @Autowired
    private AuthUserRoleService userRoleService;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public UserRole getUserRoleById(@RequestParam("id") Long id) {
        AuthUserRole userRole = userRoleService.getById(id);
        return dozerMapper.map(userRole, UserRole.class);
    }

    @Override
    public boolean insertUserRole(@RequestParam("userId") Long userId,@RequestParam("roleId") Long roleId) {
        QueryWrapper<AuthUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(userId != null, "user_id", userId)
                .eq(roleId != null, "role_id", roleId);
        List<AuthUserRole> list = userRoleService.list(queryWrapper);
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        if(list.size()==0){
            System.out.println("index=0执行添加！！");
            AuthUserRole authUserRole = dozerMapper.map(userRole, AuthUserRole.class);
            userRoleService.save(authUserRole);
        }
        return true;
    }

    @Override
    public boolean deleteUserRole(@RequestParam("id") Long id) {
        return userRoleService.removeById(id);
    }

    @Override
    public List<UserRole> aurList(@RequestBody UserRole userRole) {
        QueryWrapper<AuthUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(userRole.getId() != null, "id", userRole.getId())
                .like(userRole.getUserId() != null, "user_id", userRole.getUserId())
                .like(userRole.getRoleId() != null, "role_id", userRole.getRoleId());
        List<AuthUserRole> list = userRoleService.list(queryWrapper);
        Comparator<AuthUserRole> comparator = (o1, o2) -> {
            if (Long.valueOf(o1.getId()) != Long.valueOf(o2.getId())) {
                int i = Long.valueOf(o2.getId()).compareTo(Long.valueOf(o1.getId()));
                return i;
            } else {
                return 0;
            }
        };
        Collections.sort(list, comparator);
        return dozerMapper.map(list, List.class);
    }

    @Override
    public boolean updateUserRole(@RequestBody UserRole userRole) {
        AuthUserRole userRole1 = dozerMapper.map(userRole, AuthUserRole.class);
        return userRoleService.updateById(userRole1);
    }



    @Override
    public int countUserRole(@RequestBody UserRole userRole) {
        QueryWrapper<AuthUserRole> queryWrapper = new QueryWrapper<>();
        return userRoleService.count(queryWrapper);
    }
}
