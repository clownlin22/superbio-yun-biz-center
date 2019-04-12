package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.Permission;
import cn.superbio.judicial.cloud.biz.cases.entity.PermissionQuery;
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
 * 权限管理服务接口
 */
@Api(tags = "权限管理服务接口")
@RequestMapping("/service/api/permission")
public interface PermissionServiceApi {
    /**
     * 查询单个
     */
    @ApiOperation(value = "获取权限信息接口", notes = "获取权限信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getPermissionById", method = RequestMethod.GET)
    Permission getPermissionById(@RequestParam("id") Long id);
    /**
     * 添加
     */
    @ApiOperation(value = "添加权限信息", notes = "添加权限信息")
    @RequestMapping(value = "/insertPermission", method = RequestMethod.POST)
    boolean insertPermission(@RequestBody Permission permission);
    /**
     * 删除
     */
    @ApiOperation(value = "获取权限信息接口", notes = "获取权限信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/deletePermission", method = RequestMethod.POST)
    boolean deletePermission(@RequestParam("id") Long id);
    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询权限", notes = "根据条件查询权限")
    @RequestMapping(value = "/permissionList", method = RequestMethod.POST)
    List<Permission> permissionList(@RequestBody PermissionQuery permissionQuery);
    /**
    * 修改
    */
    @ApiOperation(value = "修改权限信息", notes = "修改权限信息")
    @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
    boolean updatePermission(@RequestBody Permission permission);
    /**
     * 总条数
     */
    @ApiOperation(value = "查询权限信息列表总记录数", notes = "查询权限信息列表总记录数")
    @RequestMapping(value = "countPermission", method = RequestMethod.POST)
    int countPermission(@RequestBody Permission permission);
    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除指定权限", notes = "批量删除指定权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定权限编号", dataType = "String", allowMultiple = true, required = true)

    })
    @RequestMapping(value = "/removePermission", method = RequestMethod.GET)
    boolean removePermission(@RequestParam("ids") List<String> ids);
}
