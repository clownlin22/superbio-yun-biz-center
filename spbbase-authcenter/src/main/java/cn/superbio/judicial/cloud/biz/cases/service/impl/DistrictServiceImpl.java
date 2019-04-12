package cn.superbio.judicial.cloud.biz.cases.service.impl;

import cn.superbio.judicial.cloud.biz.cases.DO.DistrictDo;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictQueryEntity;
import cn.superbio.judicial.cloud.biz.cases.mapper.DistrictDoMapper;
import cn.superbio.judicial.cloud.biz.cases.service.DistrictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDoMapper districtDoMapper;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public List<DistrictEntity> list(DistrictQueryEntity query) {

        QueryWrapper<DistrictDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("code").eq("code",query.getCode()).or()
                    .isNotNull("name").eq("name",query.getName()).or()
                    .isNotNull("parent_code").eq("parent_code",query.getParentCode())
                    .orderByAsc("tree_sort");
        List<DistrictDo> districtDoList = districtDoMapper.selectList(queryWrapper);
       return dozerMapper.map(districtDoList,List.class);
    }

    @Override
    public DistrictEntity save(DistrictEntity districtEntity) {
        System.out.println(districtEntity);

        //根据code查询，判断该code是否已经存在
        DistrictDo districtDo = districtDoMapper.selectById(districtEntity.getCode());

        //查询添加地区的上级地区
        DistrictDo parentDistrict = districtDoMapper.selectOne(new QueryWrapper<DistrictDo>().eq("code",districtEntity.getParentCode()));

        //用于存放生成的完整的地区信息
        DistrictDo districtTemp = new DistrictDo();

        if(districtDo==null){//说明该code并未被占用，可以添加信息
            if(parentDistrict==null){//说明添加的地区不是其他地区的下级地区
                districtTemp.setCode(districtEntity.getCode());
                districtTemp.setName(districtEntity.getName());
                districtTemp.setType(districtEntity.getType());
                districtTemp.setParentCode("0");
                districtTemp.setParentCodes("0");
                districtTemp.setTreeSort(districtEntity.getTreeSort());
                districtTemp.setTreeSorts(String.format("%0" + 10 + "d", districtEntity.getTreeSort()));
                districtTemp.setTreeLeaf(0);
                districtTemp.setTreeDepth(0);
                districtTemp.setTreeNames(districtEntity.getName());
                districtTemp.setRemark(districtEntity.getRemark());
                districtDoMapper.insert(districtTemp);

                return dozerMapper.map(districtTemp,DistrictEntity.class);
            }
            else {
                districtTemp.setCode(districtEntity.getCode());
                districtTemp.setName(districtEntity.getName());
                districtTemp.setType(districtEntity.getType());
                districtTemp.setParentCode(districtEntity.getParentCode());
                districtTemp.setParentCodes(parentDistrict.getParentCodes()+","+parentDistrict.getCode());
                districtTemp.setTreeSort(districtEntity.getTreeSort());
                districtTemp.setTreeSorts(parentDistrict.getTreeSorts()+","+String.format("%0" + 10 + "d", districtEntity.getTreeSort()));
                districtTemp.setTreeLeaf(0);
                districtTemp.setTreeDepth(parentDistrict.getTreeDepth()-1);
                districtTemp.setTreeNames(parentDistrict.getTreeNames()+"/"+districtEntity.getName());
                districtTemp.setRemark(districtEntity.getRemark());
                districtDoMapper.insert(districtTemp);

                if (parentDistrict.getTreeLeaf()==0){
                    parentDistrict.setTreeLeaf(1);
                    districtDoMapper.updateById(parentDistrict);
                }

                return dozerMapper.map(districtTemp,DistrictEntity.class);
            }
        }
        else
            return null;
    }

    @Override
    public void removeBatch(List<String> codes) {
        List<String>parentCodeList = new ArrayList<>();

        //需要删除的地区
        List<DistrictDo> list = districtDoMapper.selectBatchIds(codes);

        for (int i = 0; i<list.size(); i++){
            parentCodeList.add(list.get(i).getParentCode());
        }

        //查询删除地区的上级地区
        List<DistrictDo> parentList = districtDoMapper.selectBatchIds(parentCodeList);

        districtDoMapper.deleteBatchIds(codes);

        //判断删除后该父级地区是否还有下级地区 若没有将 treeleaf修改为0
        for (int i= 0;i<parentList.size();i++){
           List<DistrictDo> temp = districtDoMapper.selectList(new QueryWrapper<DistrictDo>().
                                                                  eq("parent_code",parentList.get(i).getCode()));
           if(temp.size()==0){//该地区无下级将其treeLeaf修改为0
               parentList.get(i).setTreeLeaf(0);
               districtDoMapper.updateById(parentList.get(i));
           }
        }

    }

    @Override
    public void enforcementRemove(List<String> codes) {
        List<String>parentCodeList = new ArrayList<>();

        //需要删除的地区
        List<DistrictDo> list = districtDoMapper.selectBatchIds(codes);

        for (int i = 0; i<list.size(); i++){
            parentCodeList.add(list.get(i).getParentCode());
        }

        //查询删除地区的上级地区
        List<DistrictDo> parentList = districtDoMapper.selectBatchIds(parentCodeList);

        //删除所选地区
        districtDoMapper.deleteBatchIds(codes);
        //删除下级地区
        for (int i=0; i<codes.size();i++){
            districtDoMapper.delete(new QueryWrapper<DistrictDo>().like("parent_codes",codes.get(i)));
        }

        for (int i= 0;i<parentList.size();i++){
            List<DistrictDo> temp = districtDoMapper.selectList(new QueryWrapper<DistrictDo>().
                    eq("parent_code",parentList.get(i).getCode()));
            if(temp.size()==0){//该地区无下级将其treeLeaf修改为0
                parentList.get(i).setTreeLeaf(0);
                districtDoMapper.updateById(parentList.get(i));
            }
        }
    }


    @Override
    public DistrictEntity update(DistrictEntity districtEntity) {
        DistrictDo districtDo = new DistrictDo();
        DistrictDo parentDistrict = districtDoMapper.selectById(districtEntity.getParentCode());

        districtDo.setCode(districtEntity.getCode());
        districtDo.setName(districtEntity.getName());
        districtDo.setTreeNames(parentDistrict==null?districtEntity.getName():parentDistrict.getTreeNames()+"/"+districtEntity.getName());
        districtDo.setTreeSort(districtEntity.getTreeSort());
        districtDo.setTreeSorts(parentDistrict==null?String.format("%0" + 10 + "d", districtEntity.getTreeSort()):
                parentDistrict.getTreeSorts()+","+ String.format("%0" + 10 + "d", districtEntity.getTreeSort()));
        districtDo.setRemark(districtEntity.getRemark());
        districtDoMapper.updateById(districtDo);

        DistrictDo temp = districtDoMapper.selectOne(new QueryWrapper<DistrictDo>().eq("code",districtEntity.getCode()));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(dozerMapper.map(temp,DistrictEntity.class));

        return dozerMapper.map(temp,DistrictEntity.class);
    }
}
