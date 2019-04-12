package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.AuthDeptUser;
import cn.superbio.judicial.cloud.biz.cases.DeptUserServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptUser;
import cn.superbio.judicial.cloud.biz.cases.service.AuthDeptUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthDeptUserServiceProvider implements DeptUserServiceApi {

    @Autowired
    private AuthDeptUserService deptUserService;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public DeptUser getDeptUserById(@RequestParam("id") Long id) {
        AuthDeptUser deptUser = deptUserService.getById(id);
        return dozerMapper.map(deptUser, DeptUser.class);
    }

    @Override
    public boolean insertDeptUser(@RequestBody DeptUser deptUser) {
        AuthDeptUser authDept = dozerMapper.map(deptUser,AuthDeptUser.class);
        return deptUserService.save(authDept);
    }

    @Override
    public boolean deleteDeptUser(@RequestParam("id") Long id) {
        return deptUserService.removeById(id);

    }

    @Override
    public boolean removeDeptUser(List<String> ids) {
        return false;
    }

    @Override
    public List<DeptUser> deptUserList(@RequestBody DeptUser deptUser) {
        QueryWrapper<AuthDeptUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(deptUser.getId()!=null,"id",deptUser.getId())
                .like(deptUser.getDeptId()!=null,"dept_id",deptUser.getDeptId())
                .like(deptUser.getUserId()!=null,"user_id",deptUser.getUserId());
        return dozerMapper.map(deptUserService.list(queryWrapper), List.class);
    }

    @Override
    public boolean updateDeptUser(@RequestBody DeptUser deptUser) {
        AuthDeptUser authDept = dozerMapper.map(deptUser,AuthDeptUser.class);
        return deptUserService.updateById(authDept);
    }

    @Override
    public int countDeptUser(@RequestBody DeptUser deptUser) {
        QueryWrapper<AuthDeptUser> queryWrapper = new QueryWrapper<>();
        return deptUserService.count(queryWrapper);
    }
}
