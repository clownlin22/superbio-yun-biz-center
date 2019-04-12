package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.AuthDeptUser;
import cn.superbio.judicial.cloud.biz.cases.DO.AuthPermission;
import cn.superbio.judicial.cloud.biz.cases.DO.AuthRolePermission;
import cn.superbio.judicial.cloud.biz.cases.PermissionServiceApi;
import cn.superbio.judicial.cloud.biz.cases.RolePermissionServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.Permission;
import cn.superbio.judicial.cloud.biz.cases.entity.PermissionQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.RolePermission;
import cn.superbio.judicial.cloud.biz.cases.service.AuthPermissionService;
import cn.superbio.judicial.cloud.biz.cases.service.AuthRolePermissionService;
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
public class AuthRolePermissionServiceProvider implements RolePermissionServiceApi {

    @Autowired
    private AuthRolePermissionService rolePermissionService;

    @Autowired
    private Mapper dozerMapper;


    @Override
    public boolean insertRolePer(RolePermission permission) {
        AuthRolePermission rolePermission = dozerMapper.map(permission,AuthRolePermission.class);
        return rolePermissionService.save(rolePermission);
    }

    @Override
    public boolean removeRolePer(List<String> ids) {
        return rolePermissionService.removeByIds(ids);
    }

    @Override
    public List<RolePermission> rolePerList(RolePermission permission) {
        QueryWrapper<AuthRolePermission> queryWrapper = new QueryWrapper<>();
        return dozerMapper.map(rolePermissionService.list(queryWrapper), List.class);
    }

    @Override
    public boolean updateRolePer(RolePermission permission) {
        AuthRolePermission rolePermission = dozerMapper.map(permission,AuthRolePermission.class);
        return rolePermissionService.updateById(rolePermission);
    }

    @Override
    public int countRolePer(RolePermission permission) {
        return 0;
    }
}
