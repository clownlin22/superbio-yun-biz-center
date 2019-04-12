package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.RolePermission;
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
@RequestMapping("/service/api/rolePermission")
public interface RolePermissionServiceApi {

    /**
     * 添加
     */
    @ApiOperation(value = "添加角色权限", notes = "添加角色权限")
    @RequestMapping(value = "/insertRolePer", method = RequestMethod.POST)
    boolean insertRolePer(@RequestBody RolePermission permission);
    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除角色权限", notes = "批量删除角色权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定角色权限", dataType = "String", allowMultiple = true, required = true)
    })
    @RequestMapping(value = "/removeRolePer", method = RequestMethod.GET)
    boolean removeRolePer(@RequestParam("ids") List<String> ids);

    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询角色权限", notes = "根据条件查询角色权限")
    @RequestMapping(value = "/rolePerList", method = RequestMethod.POST)
    List<RolePermission> rolePerList(@RequestBody RolePermission permission);
    /**
     * 修改
     */
    @ApiOperation(value = "修改角色权限信息", notes = "修改角色权限信息")
    @RequestMapping(value = "/updateRolePer", method = RequestMethod.POST)
    boolean updateRolePer(@RequestBody RolePermission permission);
    /**
     * 总条数
     */
    @ApiOperation(value = "查询角色权限信息列表总记录数", notes = "查询角色权限信息列表总记录数")
    @RequestMapping(value = "countRolePer", method = RequestMethod.POST)
    int countRolePer(@RequestBody RolePermission permission);
}
