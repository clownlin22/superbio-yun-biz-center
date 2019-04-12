package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntityQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 部门管理服务接口
 */
@Api(tags = "部门管理服务接口")
@RequestMapping("/service/api/dept")
public interface DeptServiceApi {

    /**
     * 初始List
     */
    @ApiOperation(value = "根据条件查询部门", notes = "根据条件查询部门")
    @RequestMapping(value = "/deptList", method = RequestMethod.POST)
    List<DeptEntity> deptList(@RequestBody DeptQuery dept);
    /**
     * 用户查询List
     */
    @ApiOperation(value = "查询简单的部门信息", notes = "查询简单的部门信息")
    @RequestMapping(value = "/querydeptList", method = RequestMethod.POST)
    List<DeptEntityQuery> querydeptList(@RequestBody DeptEntityQuery dept);
    /**
     * 查询单个
     */
    @ApiOperation(value = "获取部门信息接口", notes = "获取部门信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getDeptById", method = RequestMethod.GET)
    DeptEntity getDeptById(@RequestParam("id") Long id);

    /**
     * 添加
     */
    @ApiOperation(value = "添加部门信息", notes = "添加部门信息")
    @RequestMapping(value = "/insertDept", method = RequestMethod.POST)
    DeptEntity insertDept(@RequestBody DeptEntity dept);

    /**
     * 删除
     */
    @ApiOperation(value = "删除部门信息接口", notes = "获取部门信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/deleteDept", method = RequestMethod.GET)
    boolean deleteDept(@RequestParam("id") Long id);
    /**
    * 修改
    */
    @ApiOperation(value = "修改部门信息", notes = "修改部门信息")
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    boolean updateDept(@RequestBody DeptEntity dept);

    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除部门接口", notes = "批量删除部门接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定部门编号", dataType = "String", allowMultiple = true, required = true)

    })
    @RequestMapping(value = "/removeDept", method = RequestMethod.GET)
    boolean removeDept(@RequestParam("ids") List<String> ids);


    /**
     * 总条数
     */
    @ApiOperation(value = "查询部门信息列表总记录数", notes = "查询部门信息列表总记录数")
    @RequestMapping(value = "countDept", method = RequestMethod.POST)
    int countDept(@RequestBody DeptEntity dept);
}
