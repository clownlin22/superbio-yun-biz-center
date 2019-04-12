package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.Role;
import cn.superbio.judicial.cloud.biz.cases.entity.RoleQuery;
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
 * 角色管理服务接口
 */
@Api(tags = "角色管理服务接口")
@RequestMapping("/service/api/role")
public interface RoleServiceApi {
    /**
     * 查询单个
     */
    @ApiOperation(value = "获取角色信息接口", notes = "获取角色信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "22")
    })
    @RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
    Role getRoleById(@RequestParam("id") Long id);

    /**
     * 添加
     */
    @ApiOperation(value = "添加角色信息接口", notes = "添加角色信息")
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST)
    boolean insertRole(@RequestBody Role role);

    /**
     * 删除
     */
    @ApiOperation(value = "删除角色信息接口", notes = "删除角色信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, example = "123")
    })
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    boolean deleteRole(@RequestParam("id") Long id);

    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询角色接口", notes = "根据条件查询角色")
    @RequestMapping(value = "/roleList", method = RequestMethod.POST)
    List<Role> roleList(@RequestBody RoleQuery roleQuery);

    /**
     * 修改
     */
    @ApiOperation(value = "修改角色信息", notes = "修改角色信息")
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    boolean updateRole(@RequestBody Role role);

    /**
     * 总条数
     */
    @ApiOperation(value = "查询角色信息列表总记录数", notes = "查询用户信息列表总记录数")
    @RequestMapping(value = "countRole", method = RequestMethod.POST)
    int countRole(@RequestBody Role role);

    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除角色", notes = "批量删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定角色编号", dataType = "String", allowMultiple = true, required = true)

    })
    @RequestMapping(value = "/removeRole", method = RequestMethod.GET)
    boolean removeRole(@RequestParam("ids") List<String> ids);

    /**
     * 修改状态
     */
    @ApiOperation(value = "修改用户启用/禁用状态", notes = "修改用户启用/禁用状态")
    @RequestMapping(value = "/updateRoleStatus", method = RequestMethod.POST)
    boolean updateRoleStatus(@RequestParam("ids") List<String> ids, @RequestParam("enabled") int enabled);

}
