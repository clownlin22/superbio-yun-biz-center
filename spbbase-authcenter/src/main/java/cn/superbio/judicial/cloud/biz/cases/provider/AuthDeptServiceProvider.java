package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DO.DistrictDo;
import cn.superbio.judicial.cloud.biz.cases.DeptServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptEntityQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.DeptQuery;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictEntity;
import cn.superbio.judicial.cloud.biz.cases.service.AuthDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.superbio.judicial.cloud.biz.cases.DO.AuthDept;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author XiangKang on 2018/6/26.
 */
@RestController
public class AuthDeptServiceProvider implements DeptServiceApi {

    @Autowired
    private AuthDeptService deptService;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public DeptEntity getDeptById(@RequestParam("id") Long id) {
        AuthDept authDept = deptService.getById(id);
        return dozerMapper.map(authDept, DeptEntity.class);
    }

    @Override
    public DeptEntity insertDept(@RequestBody DeptEntity deptEntity) {
        //查询添加地区的上级部门
        AuthDept parentDistrict = deptService.getOne(new QueryWrapper<AuthDept>().eq("id", deptEntity.getParentId()));
        //用于存放生成的完整的部门信息
        AuthDept authDept = new AuthDept();

        if (parentDistrict == null) {//说明添加的地区不是其他地区的下级地区
//            authDept.setId(deptEntity.getId());
            authDept.setName(deptEntity.getName());
            authDept.setType(deptEntity.getType());
            authDept.setParentId(0L);
            authDept.setParentIds("0");
            authDept.setTreeSort(deptEntity.getTreeSort());
            authDept.setTreeSorts(String.format("%0" + 10 + "d", deptEntity.getTreeSort()));
            authDept.setTreeLeaf(0);
            authDept.setTreeDepth(0);
            authDept.setTreeNames(deptEntity.getName());
            deptService.save(authDept);
            return dozerMapper.map(authDept, DeptEntity.class);
        } else {
//            authDept.setCode(deptEntity.getCode());
            authDept.setName(deptEntity.getName());
            authDept.setType(deptEntity.getType());
            authDept.setParentId(deptEntity.getParentId());
            authDept.setParentIds(parentDistrict.getParentIds() + "," + parentDistrict.getId());
            authDept.setTreeSort(deptEntity.getTreeSort());
            authDept.setTreeSorts(parentDistrict.getTreeSorts() + "," + String.format("%0" + 10 + "d", deptEntity.getTreeSort()));
            authDept.setTreeLeaf(0);
            authDept.setTreeDepth(parentDistrict.getTreeDepth() - 1);
            authDept.setTreeNames(parentDistrict.getTreeNames() + "/" + deptEntity.getName());
            deptService.save(authDept);
            if (parentDistrict.getTreeLeaf() == 0) {
                parentDistrict.setTreeLeaf(1);
                deptService.updateById(parentDistrict);
            }
            return dozerMapper.map(authDept, DeptEntity.class);
        }
    }

    @Override
    public boolean deleteDept(@RequestParam("id") Long id) {
        return deptService.removeById(id);

    }

    @Override
    public List<DeptEntity> deptList(@RequestBody DeptQuery dept) {
        QueryWrapper<AuthDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(dept.getId()!=null,"id",dept.getId())
                .like(dept.getName()!=null,"name",dept.getName())
                .eq(dept.getType()!=null,"type",dept.getType()).orderByAsc("tree_sort");
        return dozerMapper.map(deptService.list(queryWrapper), List.class);
    }

    @Override
    public List<DeptEntityQuery> querydeptList(@RequestBody DeptEntityQuery dept) {
        QueryWrapper<AuthDept> queryWrapper = new QueryWrapper<>();
        return dozerMapper.map(deptService.list(queryWrapper), List.class);
    }

    @Override
    public boolean updateDept(@RequestBody DeptEntity dept) {
        AuthDept authDept = dozerMapper.map(dept,AuthDept.class);
        return deptService.updateById(authDept);
    }

    @Override
    public boolean removeDept(@RequestParam("ids") List<String> ids) {
        List<Long> parentIdList = new ArrayList<>();

        //需要删除的部门
        Collection<AuthDept> authDepts = deptService.listByIds(ids);
        List<AuthDept> depts = (List) authDepts;
        for (int i = 0; i < depts.size(); i++) {
            parentIdList.add(depts.get(i).getParentId());
        }

        //查询删除数据的上级
        Collection<AuthDept> authDepts1 = deptService.listByIds(parentIdList);
        List<AuthDept> parentList = (List) authDepts1;

        //删除部门
        deptService.removeByIds(ids);
        //删除下级部门
        for (int i = 0; i < ids.size(); i++) {
            deptService.remove(new QueryWrapper<AuthDept>().like("parent_ids", ids.get(i)));
        }

        for (int i = 0; i < parentList.size(); i++) {
            List<AuthDept> temp = deptService.list(new QueryWrapper<AuthDept>().
                    eq("parent_id", parentList.get(i).getId()));
            if (temp.size() == 0) {//该部门无下级将其treeLeaf修改为0
                parentList.get(i).setTreeLeaf(0);
                deptService.updateById(parentList.get(i));
            }
        }
        return true;
    }

    @Override
    public int countDept(@RequestBody DeptEntity dept) {
        QueryWrapper<AuthDept> queryWrapper = new QueryWrapper<>();
        return deptService.count(queryWrapper);
    }
}
