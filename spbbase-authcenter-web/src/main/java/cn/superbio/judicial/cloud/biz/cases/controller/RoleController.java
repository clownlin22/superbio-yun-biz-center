package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.RoleServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.Role;
import cn.superbio.judicial.cloud.biz.cases.entity.RoleQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理服务接口")
@RequestMapping("/api/role")
@RestController
public class RoleController {
    @Autowired
    private RoleServiceConsumer roleServiceConsumer;

    @ApiOperation(value = "查询角色管理列表", notes = "查询角色管理列表")
    @RequestMapping(value = "listRole", method = {RequestMethod.GET})
    public List<Role> listRole(RoleQuery query) {
        return roleServiceConsumer.roleList(query);
    }

    @ApiOperation(value = "获取单个角色管理信息", notes = "获取单个角色管理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "long"),
    })
    @RequestMapping(value = "/getRoleId", method = {RequestMethod.GET})
    public Role getRoleId(@PathVariable Long id) {
        return roleServiceConsumer.getRoleById(id);
    }

    @ApiOperation(value = "调整某个角色排序号", notes = "调整某个角色排序号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色编号", required = true, dataType = "long"),
            @ApiImplicitParam(name = "newSort", value = "新的排序号", dataType = "int", required = true, example = "1000")
    })
    @RequestMapping(value = "/{id}/sort", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void sort(@PathVariable Long id, @RequestBody int newSort) {

    }

    @ApiOperation(value = "保存角色管理信息", notes = "保存角色管理信息")
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean save(@RequestBody @Validated Role role) {
        return roleServiceConsumer.insertRole(role);
    }

    @ApiOperation(value = "更新角色管理信息", notes = "更新角色管理信息")
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean update(@RequestBody @Validated Role role) {
        return roleServiceConsumer.updateRole(role);
    }

    @ApiOperation(value = "是否禁用", notes = "是否禁用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true),
            @ApiImplicitParam(name = "enabled", value = "启用/禁用", dataType = "int", required = true)
    })
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void enable(@PathVariable List<String> ids, @PathVariable int enabled) {
        System.out.println(ids);
        System.out.println(enabled);
    }

    @ApiOperation(value = "批量删除指定角色", notes = "批量删除指定角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定角色编号", dataType = "string", allowMultiple = true, required = true, example = "320100")
    })
    @RequestMapping(value = "removeBatch", method = {RequestMethod.GET})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean removeBatch(@RequestParam("ids") List<String> ids) {
       return roleServiceConsumer.removeRole(ids);
    }

    @ApiOperation(value = "角色启用/禁用状态", notes = "角色启用/禁用状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "角色编号", allowMultiple = true, dataType = "string", required = true),
            @ApiImplicitParam(name = "enabled", value = "新的状态", dataType = "int", required = true)
    })
    @RequestMapping(value = "/status", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean status(@RequestParam("ids") List<String> ids, @RequestParam("enabled") int enabled) {
        return roleServiceConsumer.updateRoleStatus(ids, enabled);
    }

}
