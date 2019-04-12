package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.DeptUser;
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
 * 用户所在部门管理服务接口
 */
@Api(tags = "用户所在部门管理服务接口")
@RequestMapping("/service/api/deptUser")
public interface DeptUserServiceApi {
    /**
     * 查询单个
     */
    @ApiOperation(value = "获取用户所在部门信息接口", notes = "获取用户所在部门信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getDeptUserById", method = RequestMethod.GET)
    DeptUser getDeptUserById(@RequestParam("id") Long id);
    /**
     * 添加
     */
    @ApiOperation(value = "添加用户所在部门信息", notes = "添加用户所在部门信息")
    @RequestMapping(value = "/insertDeptUser", method = RequestMethod.POST)
    boolean insertDeptUser(@RequestBody DeptUser deptUser);
    /**
     * 删除
     */
    @ApiOperation(value = "删除用户所在部门信息接口", notes = "删除用户所在部门信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/deleteDeptUser", method = RequestMethod.POST)
    boolean deleteDeptUser(@RequestParam("id") Long id);
    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除用户所在部门接口", notes = "批量删除用户所在部门接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定部门编号", dataType = "String", allowMultiple = true, required = true)

    })
    @RequestMapping(value = "/removeDeptUser", method = RequestMethod.GET)
    boolean removeDeptUser(@RequestParam("ids") List<String> ids);



    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询用户所在部门", notes = "根据条件查询用户所在部门")
    @RequestMapping(value = "/deptUserList", method = RequestMethod.POST)
    List<DeptUser> deptUserList(@RequestBody DeptUser deptUser);
    /**
    * 修改
    */
    @ApiOperation(value = "修改用户所在部门信息", notes = "修改用户所在部门信息")
    @RequestMapping(value = "/updateDeptUser", method = RequestMethod.POST)
    boolean updateDeptUser(@RequestBody DeptUser deptUser);
    /**
     * 总条数
     */
    @ApiOperation(value = "查询用户所在部门信息列表总记录数", notes = "查询用户所在部门信息列表总记录数")
    @RequestMapping(value = "countDeptUser", method = RequestMethod.POST)
    int countDeptUser(@RequestBody DeptUser deptUser);
}
