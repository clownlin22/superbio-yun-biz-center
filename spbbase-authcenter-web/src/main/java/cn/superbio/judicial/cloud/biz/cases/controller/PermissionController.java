package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.PermissionServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.Permission;
import cn.superbio.judicial.cloud.biz.cases.entity.PermissionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "权限管理服务接口")
@RequestMapping("/api/permission")
@RestController
public class PermissionController {
    @Autowired
    private PermissionServiceConsumer permissionServiceConsumer;

    @ApiOperation(value = "查询权限管理列表", notes = "查询权限管理列表")
    @RequestMapping(value = "listPermission", method = {RequestMethod.GET})
    public List<Permission> list(PermissionQuery query) {
        return permissionServiceConsumer.permissionList(query);
    }

    @ApiOperation(value = "获取单个权限管理信息", notes = "获取单个权限管理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "权限ID", required = true, dataType = "long"),
    })
    @RequestMapping(value = "/getId", method = {RequestMethod.GET})
    public Permission getId(@PathVariable Long id) {
        return permissionServiceConsumer.getPermissionById(id);
    }

    @ApiOperation(value = "保存权限管理信息", notes = "保存权限管理信息")
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean save(@RequestBody @Validated Permission permission) {
        return permissionServiceConsumer.insertPermission(permission);
    }

    @ApiOperation(value = "更新权限管理信息", notes = "更新权限管理信息")
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean update(@RequestBody @Validated Permission permission) {
        return permissionServiceConsumer.updatePermission(permission);
    }

    @ApiOperation(value = "批量删除", notes = "批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定权限编号", dataType = "string", allowMultiple = true, required = true)
    })
    @RequestMapping(value = "removeBatch", method = {RequestMethod.GET})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean removeBatch(@RequestParam("ids") List<String> ids) {
        return permissionServiceConsumer.removePermission(ids);
    }
}
