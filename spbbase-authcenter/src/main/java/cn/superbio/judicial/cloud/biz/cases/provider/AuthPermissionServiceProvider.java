package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.AuthPermission;
import cn.superbio.judicial.cloud.biz.cases.PermissionServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.Permission;
import cn.superbio.judicial.cloud.biz.cases.entity.PermissionQuery;
import cn.superbio.judicial.cloud.biz.cases.service.AuthPermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthPermissionServiceProvider implements PermissionServiceApi {

    @Autowired
    private AuthPermissionService permissionService;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public Permission getPermissionById(@RequestParam("id") Long id) {
        AuthPermission authPermission = permissionService.getById(id);
        return dozerMapper.map(authPermission, Permission.class);
    }

    @Override
    public boolean insertPermission(@RequestBody Permission permission) {
        AuthPermission authPermission = dozerMapper.map(permission, AuthPermission.class);
        return permissionService.save(authPermission);
    }

    @Override
    public boolean deletePermission(@RequestParam("id") Long id) {
        return permissionService.removeById(id);
    }

    @Override
    public List<Permission> permissionList(@RequestBody PermissionQuery permission) {
        QueryWrapper<AuthPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(permission.getName()!=null,"name",permission.getName())
                .like(permission.getCode()!=null,"code",permission.getCode())
                .eq(permission.getType()!=null,"type",permission.getType());
        List<AuthPermission> list = permissionService.list(queryWrapper);
        return dozerMapper.map(list, List.class);
    }

    @Override
    public boolean updatePermission(@RequestBody Permission permission) {
        AuthPermission authRole = dozerMapper.map(permission,AuthPermission.class);
        return permissionService.updateById(authRole);
    }

    @Override
    public int countPermission(@RequestBody Permission permission) {
        QueryWrapper<AuthPermission> queryWrapper = new QueryWrapper<>();
        return permissionService.count(queryWrapper);
    }

    @Override
    public boolean removePermission(@RequestParam("ids") List<String> ids) {
        return permissionService.removeByIds(ids);
    }
}
