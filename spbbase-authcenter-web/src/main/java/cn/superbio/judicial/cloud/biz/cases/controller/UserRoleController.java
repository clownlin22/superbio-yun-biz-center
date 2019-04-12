package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.UserRoleServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.UserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户角色管理服务接口")
@RequestMapping("/api/userRole")
@RestController
public class UserRoleController {
    @Autowired
    private UserRoleServiceConsumer userRoleServiceConsumer;

    @ApiOperation(value = "查询用户角色中间表列表", notes = "查询用户角色中间表列表")
    @RequestMapping(value = "listUserRole", method = {RequestMethod.GET})
    public List<UserRole> listUserRole(UserRole userRole) {
        return userRoleServiceConsumer.aurList(userRole);
    }

}
