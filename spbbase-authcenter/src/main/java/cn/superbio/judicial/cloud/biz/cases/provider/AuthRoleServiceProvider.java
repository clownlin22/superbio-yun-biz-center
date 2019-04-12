package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.*;
import cn.superbio.judicial.cloud.biz.cases.RoleServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.Role;
import cn.superbio.judicial.cloud.biz.cases.entity.RoleQuery;
import cn.superbio.judicial.cloud.biz.cases.service.AuthRolePermissionService;
import cn.superbio.judicial.cloud.biz.cases.service.AuthRoleService;
import cn.superbio.judicial.cloud.biz.cases.service.AuthUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.PersistenceService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthRoleServiceProvider implements RoleServiceApi {

    @Autowired
    private AuthRoleService roleService;
    @Autowired
    private Mapper dozerMapper;
    @Autowired
    private AuthUserRoleService userRoleService;
    @Autowired
    private AuthRolePermissionService permissionService;

    @Override
    public Role getRoleById(@RequestParam("id") Long id) {
        AuthRole roleById = roleService.getById(id);
        return dozerMapper.map(roleById, Role.class);
    }

    @Override
    public boolean insertRole(@RequestBody Role role) {
        AuthRole authRole = dozerMapper.map(role, AuthRole.class);
        return roleService.save(authRole);
    }

    @Override
    public boolean deleteRole(@RequestParam("id") Long id) {
        QueryWrapper<AuthUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id!=null,"role_id",id);
        // 根据角色ID查询list，循环删除
        List<AuthUserRole> list = userRoleService.list(queryWrapper);
        if(list.size()>0){
            List<Long> roleUserIdList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.size() > 0) {
                    roleUserIdList.add(list.get(i).getId());
                }
            }
            userRoleService.removeByIds(roleUserIdList);
        }
        return roleService.removeById(id);
    }

    @Override
    public List<Role> roleList(@RequestBody RoleQuery role) {
        QueryWrapper<AuthRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(role.getName() != null, "name", role.getName())
                .like(role.getCode() != null, "code", role.getCode())
                .eq(role.getEnabled() != null, "enabled", role.getEnabled())
                .eq(role.getSystemic() != null, "systemic", role.getSystemic());
        return dozerMapper.map(roleService.list(queryWrapper), List.class);
    }

    @Override
    public boolean updateRole(@RequestBody Role role) {
        AuthRole authRole = dozerMapper.map(role, AuthRole.class);
        if(role.getUserId()!=null){
            // 清空用户角色信息
            QueryWrapper<AuthUserRole> userRoleQueryWrapper = new QueryWrapper<>();
            userRoleQueryWrapper.eq(role.getId() != null, "role_id", role.getId());
            userRoleService.remove(userRoleQueryWrapper);
            List<AuthUserRole> authUserRoles = new ArrayList<>();
            for (int i = 0; i < role.getUserId().size(); i++) {
                AuthUserRole authUserRole = new AuthUserRole();
                authUserRole.setRoleId(role.getId());
                authUserRole.setUserId(role.getUserId().get(i));
                authUserRoles.add(authUserRole);
            }
            userRoleService.saveBatch(authUserRoles);
        }
        if(role.getPermissionId()!=null){
            // 清空用户角色信息
            QueryWrapper<AuthRolePermission> permissionQueryWrapper = new QueryWrapper<>();
            permissionQueryWrapper.eq(role.getId() != null, "role_id", role.getId());
            permissionService.remove(permissionQueryWrapper);
            List<AuthRolePermission> permissionList = new ArrayList<>();
            for (int i = 0; i < role.getPermissionId().size(); i++) {
                AuthRolePermission authUserRole = new AuthRolePermission();
                authUserRole.setRoleId(role.getId());
                authUserRole.setPermissionId(role.getPermissionId().get(i));
                permissionList.add(authUserRole);
            }
            permissionService.saveBatch(permissionList);
        }
        return roleService.updateById(authRole);
    }

    @Override
    public int countRole(@RequestBody Role role) {
        QueryWrapper<AuthRole> queryWrapper = new QueryWrapper<>();
        return roleService.count(queryWrapper);
    }

    @Override
    public boolean removeRole(@RequestParam("ids") List<String> ids) {
        return  roleService.removeByIds(ids);
    }

    // 根据案例ID修改状态
    @Override
    public boolean updateRoleStatus(@RequestParam("ids") List<String> ids, @RequestParam("enabled") int enabled) {
        Collection<AuthRole> authRoles = roleService.listByIds(ids);
        for (AuthRole authRole : authRoles) {
            authRole.setEnabled(enabled);
        }
        return roleService.updateBatchById(authRoles);
    }

}
