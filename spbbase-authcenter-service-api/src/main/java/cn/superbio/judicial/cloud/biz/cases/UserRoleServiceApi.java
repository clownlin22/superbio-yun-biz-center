package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.UserRole;
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
 * 用户角色管理服务接口
 */
@Api(tags = "用户角色管理服务接口")
@RequestMapping("/service/api/userRole")
public interface UserRoleServiceApi {
    /**
     * 查询单个
     */
    @ApiOperation(value = "获取部门信息接口", notes = "获取部门信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getUserRoleById", method = RequestMethod.GET)
    UserRole getUserRoleById(@RequestParam("id") Long id);
    /**
     * 添加
     */
    @ApiOperation(value = "添加用户的角色信息", notes = "添加用户的角色信息")
    @RequestMapping(value = "/insertUserRole", method = RequestMethod.POST)
    boolean insertUserRole(@RequestParam("userId") Long userId, @RequestParam("roleId") Long roleId);
    /**
     * 删除
     */
    @ApiOperation(value = "删除用户的角色信息", notes = "删除用户的角色信息")
    @RequestMapping(value = "/deleteUserRole", method = RequestMethod.POST)
    boolean deleteUserRole(@RequestParam("id") Long id);
    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询部门", notes = "根据条件查询部门")
    @RequestMapping(value = "/aurList", method = RequestMethod.POST)
    List<UserRole> aurList(@RequestBody UserRole userRole);
    /**
    * 修改
    */
    @ApiOperation(value = "修改用户的角色信息", notes = "修改用户的角色信息")
    @RequestMapping(value = "/updateUserRole", method = RequestMethod.POST)
    boolean updateUserRole(@RequestBody UserRole userRole);
    /**
     * 总条数
     */
    @ApiOperation(value = "查询部门信息列表总记录数", notes = "查询部门信息列表总记录数")
    @RequestMapping(value = "countUserRole", method = RequestMethod.POST)
    int countUserRole(@RequestBody UserRole userRole);
}
