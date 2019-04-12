package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.DeptServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntityQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "部门管理服务接口")
@RequestMapping("/api/dept")
@RestController
public class DeptController {
    @Autowired
    private DeptServiceConsumer deptConsumer;

    @ApiOperation(value = "初始部门管理列表", notes = "初始部门管理列表")
    @RequestMapping(value = "listDept", method = {RequestMethod.GET})
    public List<DeptEntity> list(DeptQuery query) {
        return deptConsumer.deptList(query);
    }
    @ApiOperation(value = "用户表查询部门管理列表", notes = "用户表查询部门管理列表")
    @RequestMapping(value = "queryDeptList", method = {RequestMethod.GET})
    public List<DeptEntityQuery> queryDeptList(DeptEntityQuery query) {
        return deptConsumer.querydeptList(query);
    }

    @ApiOperation(value = "获取单个部门管理信息", notes = "获取单个部门管理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "long", value = "部门ID", required = true),
    })
    @RequestMapping(value = "/getId", method = {RequestMethod.GET})
    public DeptEntity getId(@PathVariable Long id) {
        return deptConsumer.getDeptById(id);
    }

    @ApiOperation(value = "调整某个部门排序号", notes = "调整某个部门排序号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门编号",dataType = "long", required = true, example = "1001"),
            @ApiImplicitParam(name = "newSort", value = "新的排序号", dataType = "int", required = true, example = "1000")
    })
    @RequestMapping(value = "/{id}/sort", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void sort(@PathVariable Long id, @RequestBody int newSort) {
//        deptConsumer
    }

    @ApiOperation(value = "保存部门管理信息", notes = "保存部门管理信息")
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public DeptEntity save(@RequestBody @Validated DeptEntity dept) {
        return deptConsumer.insertDept(dept);
    }

    @ApiOperation(value = "更新部门管理信息", notes = "更新部门管理信息")
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean update(@RequestBody @Validated DeptEntity dept) {
        return deptConsumer.updateDept(dept);
    }

    @ApiOperation(value = "批量删除指定部门", notes = "批量删除指定部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定部门编号", dataType = "long", allowMultiple = true, required = true, example = "320100")
    })
    @RequestMapping(value = "removeBatch", method = {RequestMethod.GET})
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean removeBatch(@RequestParam("ids") List<String> ids) {
        return deptConsumer.removeDept(ids);
    }
}
