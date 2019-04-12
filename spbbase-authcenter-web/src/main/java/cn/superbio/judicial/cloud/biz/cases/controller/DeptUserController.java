package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.DeptServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.consumer.DeptUserServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户所在部门管理服务接口")
@RequestMapping("/api/deptUser")
@RestController
public class DeptUserController {
    @Autowired
    private DeptUserServiceConsumer deptUserServiceConsumer;

    @ApiOperation(value = "查询用户所在部门中间表列表", notes = "查询用户所在部门中间表列表")
    @RequestMapping(value = "listDeptUser", method = {RequestMethod.GET})
    public List<DeptUser> listDeptUser(DeptUser deptUser) {
        return deptUserServiceConsumer.deptUserList(deptUser);
    }

    @ApiOperation(value = "获取单个用户所在部门中间表信息", notes = "获取单个用户所在部门中间表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", required = true),
    })
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public DeptUser get(@PathVariable Long id) {
        return deptUserServiceConsumer.getDeptUserById(id);
    }

    @ApiOperation(value = "保存用户所在部门中间表信息", notes = "保存用户所在部门中间表信息")
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean save(@RequestBody @Validated DeptUser deptUser) {
        return deptUserServiceConsumer.insertDeptUser(deptUser);
    }

    @ApiOperation(value = "更新用户所在部门中间表信息", notes = "更新用户所在部门中间表信息")
    @RequestMapping(value = "update", method = {RequestMethod.PUT})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean update(@RequestBody @Validated DeptUser deptUser) {
        return deptUserServiceConsumer.updateDeptUser(deptUser);
    }

    @ApiOperation(value = "批量删除指定用户所在部门的中间表", notes = "批量删除指定用户所在部门的中间表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定用户和部门中间表编号", dataType = "string", allowMultiple = true, required = true, example = "320100")
    })
    @RequestMapping(value = "removeBatch", method = {RequestMethod.DELETE})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String removeBatch(@RequestBody List<String> ids) {
        boolean res = deptUserServiceConsumer.removeDeptUser(ids);
        if (res) {
            return "true";
        }
        return null;
    }
}
