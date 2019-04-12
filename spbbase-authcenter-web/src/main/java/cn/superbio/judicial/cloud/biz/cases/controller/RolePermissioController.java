package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.RolePermissionServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.RolePermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色的权限管理服务接口")
@RequestMapping("/api/rolePermission")
@RestController
public class RolePermissioController {
    @Autowired
    private RolePermissionServiceConsumer rolePermissionServiceConsumer;
    @ApiOperation(value = "查询角色的权限中间表列表", notes = "查询角色的权限中间表列表")
    @RequestMapping(value = "listRolePermission", method = {RequestMethod.GET})
    public List<RolePermission> listRolePermission(RolePermission rolePermission) {
        return rolePermissionServiceConsumer.rolePerList(rolePermission);
    }

    @ApiOperation(value = "获取单个角色的权限中间表信息", notes = "获取单个角色的权限中间表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long"),
    })
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public RolePermission get(@PathVariable Long id) {
        return null;
    }

    @ApiOperation(value = "保存角色的权限中间表信息", notes = "保存角色的权限中间表信息")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public RolePermission save(@RequestBody @Validated RolePermission userRole) {
        return null;
    }

    @ApiOperation(value = "更新角色的权限中间表信息", notes = "更新角色的权限中间表信息")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    @ResponseStatus(value = HttpStatus.CREATED)
    public RolePermission update(@RequestBody @Validated RolePermission userRole) {
        return null;
    }

    @ApiOperation(value = "删除指定角色的权限中间表", notes = "删除指定角色的权限中间表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色的权限中间表编号", required = true, dataType = "long")
    })
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
    }

    @ApiOperation(value = "批量删除指定角色的权限的中间表", notes = "批量删除指定角色的权限的中间表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定角色的权限中间表编号", dataType = "long", allowMultiple = true, required = true, example = "320100")
    })
    @RequestMapping(value = "", method = {RequestMethod.DELETE})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeBatch(@RequestBody List<Long> ids) {
    }
}
