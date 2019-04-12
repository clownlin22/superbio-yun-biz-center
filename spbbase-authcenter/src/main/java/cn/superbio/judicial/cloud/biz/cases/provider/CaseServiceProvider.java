package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.CaseServiceApi;
import cn.superbio.judicial.cloud.biz.cases.DO.*;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseQuery;
import cn.superbio.judicial.cloud.biz.cases.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.catalina.Host;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Port;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CaseServiceProvider implements CaseServiceApi {

    @Autowired
    private CaseService caseService;
    @Autowired
    private CaseChargingService chargingService;
    @Autowired
    private CaseMaterialService materialService;
    @Autowired
    private IdentificationMatterService matterService;
    @Autowired
    private IdentifiedCarService carService;
    @Autowired
    private IdentifiedObjectService objectService;
    @Autowired
    private IdentifiedPersonService personService;
    @Autowired
    private CaseSampleService caseSampleService;
    @Autowired
    private SampleService sampleService;

    @Autowired
    private Mapper dozerMapper;

    //    查询多个案例
    @Override
    public List<CaseEntity> caseList(@RequestBody CaseQuery caseQuery) throws SocketException {
        Socket socket = new Socket();
        socket.setReuseAddress(true);
        socket.setKeepAlive(true);
        socket.setTcpNoDelay(true);
        socket.setSoLinger(true,0);


        QueryWrapper<Case> queryWrapper = new QueryWrapper<>();
        if(caseQuery.getAcceptDate()!=null){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date now = caseQuery.getAcceptDate();
                String time = format.format(now);
            queryWrapper.like(caseQuery.getAcceptDate() != null, "accept_date",time);
        }
        queryWrapper.like(caseQuery.getCaseNo() != null, "case_no", caseQuery.getCaseNo())
                .like(caseQuery.getCaseCategoryId() != null, "case_category_id", caseQuery.getCaseCategoryId())
                .like(caseQuery.getClientName() != null, "client_name", caseQuery.getClientName())
                .like(caseQuery.getStatus() != null, "status", caseQuery.getStatus())
                .eq(caseQuery.getId() != null, "id", caseQuery.getId())
                .like(caseQuery.getClientPhone() != null, "client_phone", caseQuery.getClientPhone());
        return dozerMapper.map(caseService.list(queryWrapper), List.class);
    }

    // 查询单个案例
    @Override
    public CaseEntity getCaseById(@RequestParam("id") Long id) {
        // 主表
        QueryWrapper<Case> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        Case aCase = caseService.getOne(queryWrapper);
        // 收费说明
        QueryWrapper<CaseCharging> wrapper = new QueryWrapper<>();
        wrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setCaseCharging(chargingService.list(wrapper));
        // 鉴定材料
        QueryWrapper<CaseMaterial> materialWrapper = new QueryWrapper<>();
        materialWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setCaseMaterial(materialService.list(materialWrapper));
        // 鉴定事项
        QueryWrapper<IdentificationMatter> matterWrapper = new QueryWrapper<>();
        matterWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setIdentificationMatter(matterService.list(matterWrapper));
        // 鉴定车
        QueryWrapper<IdentifiedCar> carWrapper = new QueryWrapper<>();
        carWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setIdentifiedCar(carService.list(carWrapper));
        // 鉴定物
        QueryWrapper<IdentifiedObject> objectWrapper = new QueryWrapper<>();
        objectWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setIdentifiedObject(objectService.list(objectWrapper));
        // 鉴定人
        QueryWrapper<IdentifiedPerson> personWrapper = new QueryWrapper<>();
        personWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setIdentifiedPerson(personService.list(personWrapper));
        // 样本信息(如果根据ID查询样本信息，样本详情也可以查询，但是如果很多条数据，数据库运行次数太多，会导致超时)
        QueryWrapper<CaseSample> sampleWrapper = new QueryWrapper<>();
        sampleWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        aCase.setCaseSample(caseSampleService.list(sampleWrapper));
        // 样本
        if (aCase.getCaseCategoryId() == 0) {
            if (aCase.getCaseSample().size() > 0) {
                List<Long> ids = new ArrayList<>();
                for (int i = 0; i < aCase.getCaseSample().size(); i++) {
                    ids.add(aCase.getCaseSample().get(i).getSampleId());
                }
                Collection<Sample> samples1 = sampleService.listByIds(ids);
                List<Sample> samples = (List<Sample>) samples1;
                aCase.setSample(samples);
            }
        }
        return dozerMapper.map(aCase, CaseEntity.class);
    }

    // 根据ID查询鉴定材料
    @Override
    public CaseEntity getMaterialsById(Long id) {
        Case aCase = new Case();
        // 鉴定材料
        QueryWrapper<CaseMaterial> materialWrapper = new QueryWrapper<>();
        materialWrapper.eq(id != null, "case_id", id);
        aCase.setCaseMaterial(materialService.list(materialWrapper));
        return dozerMapper.map(aCase, CaseEntity.class);
    }

    // 调新增接口
    @Override
    public CaseEntity saveCase(@RequestBody CaseEntity cases) {
        // 添加时，需要先将caseId放到每个子表中的list中进行添加
        Case aCase = dozerMapper.map(cases, Case.class);
        caseService.save(aCase);
        CaseEntity caseEntity = dozerMapper.map(aCase, CaseEntity.class);
        return this.insertCase(caseEntity);
    }

    // 添加
    public CaseEntity insertCase(@RequestBody CaseEntity caseEntity){
        Case aCase = dozerMapper.map(caseEntity, Case.class);
        Integer money = 0;
        if (aCase.getCaseCharging() != null) {
            if (aCase.getCaseCharging().size() > 0) {
                List<CaseCharging> caseList = aCase.getCaseCharging();
                for (CaseCharging caseCharging : caseList) {
                    caseCharging.setCaseId(aCase.getId());
                    money = money+caseCharging.getTotalPrice();
                }
                chargingService.saveBatch(caseList);
            }
        }
        // 鉴定材料
        if (aCase.getCaseMaterial() != null) {
            if (aCase.getCaseMaterial().size() > 0) {
                List<CaseMaterial> materialList = aCase.getCaseMaterial();
                for (CaseMaterial caseMaterial : materialList) {
                    caseMaterial.setCaseId(aCase.getId());
                }
                materialService.saveBatch(materialList);
            }
        }
        // 鉴定事项
        if (aCase.getIdentificationMatter() != null) {
            if (aCase.getIdentificationMatter().size() > 0) {
                List<IdentificationMatter> materialList = aCase.getIdentificationMatter();
                for (IdentificationMatter matter : materialList) {
                    matter.setCaseId(aCase.getId());
                }
                matterService.saveBatch(materialList);
            }
        }
        // 鉴定车
        if (aCase.getIdentifiedCar() != null) {
            if (aCase.getIdentifiedCar().size() > 0) {
                List<IdentifiedCar> carList = aCase.getIdentifiedCar();
                for (IdentifiedCar car : carList) {
                    car.setCaseId(aCase.getId());
                }
                carService.saveBatch(carList);
            }
        }
        // 鉴定物
        if (aCase.getIdentifiedObject() != null) {
            if (aCase.getIdentifiedObject().size() > 0) {
                List<IdentifiedObject> objectList = aCase.getIdentifiedObject();
                for (IdentifiedObject object : objectList) {
                    object.setCaseId(aCase.getId());
                }
                objectService.saveBatch(objectList);
            }
        }
        // 鉴定人
        if (aCase.getIdentifiedPerson() != null) {
            if (aCase.getIdentifiedPerson().size() > 0) {
                List<IdentifiedPerson> personList = aCase.getIdentifiedPerson();
                for (IdentifiedPerson person : personList) {
                    person.setCaseId(aCase.getId());
                }
                personService.saveBatch(personList);
            }
        }
        // 样本
        if (aCase.getSample() != null) {
            if (aCase.getSample().size() > 0) {
                List<Sample> sampleList = aCase.getSample();
                sampleService.saveBatch(sampleList);
            }
        }
        // 样本信息
        if (aCase.getCaseSample() != null) {
            if (aCase.getCaseSample().size() > 0) {
                List<CaseSample> caseSamples = new ArrayList<>();
                List<CaseSample> sampleList = aCase.getCaseSample();
                List<Sample> sample = aCase.getSample();
                for (int i=0;i<sampleList.size();i++) {
                    CaseSample caseSample = new CaseSample();
                    caseSample.setAppellation(sampleList.get(i).getAppellation());
                    caseSample.setCaseId(aCase.getId());
                    caseSample.setSampleId(sample.get(i).getId());
                    caseSamples.add(caseSample);
                }
                caseSampleService.saveBatch(caseSamples);
            }
        }

        aCase.setTotalPrice(money);
        caseService.updateById(aCase);
        return dozerMapper.map(aCase, CaseEntity.class);
    }
    // 根据案例ID删除（多个）
    @Override
    public boolean remove(@RequestParam("ids") List<String> ids) {
        for (int i = 0; i < ids.size(); i++) {
            // 收费说明
            QueryWrapper<CaseCharging> caseChargingQueryWrapper = new QueryWrapper<>();
            caseChargingQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            chargingService.remove(caseChargingQueryWrapper);
            // 鉴定材料
            QueryWrapper<CaseMaterial> caseMaterialQueryWrapper = new QueryWrapper<>();
            caseMaterialQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            materialService.remove(caseMaterialQueryWrapper);
            // 样本信息 + 样本
            QueryWrapper<CaseSample> caseSampleQueryWrapper = new QueryWrapper<>();
            caseSampleQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            List<CaseSample> list = caseSampleService.list(caseSampleQueryWrapper);
            if(list.size()>0){
                Collection<Long> sampleList = new ArrayList<>();
                for(int j=0;j<list.size();j++){
                    sampleList.add(list.get(j).getSampleId());
                }
                sampleService.removeByIds(sampleList);
            }
            caseSampleService.remove(caseSampleQueryWrapper);
            // 鉴定事项
            QueryWrapper<IdentificationMatter> matterQueryWrapper = new QueryWrapper<>();
            matterQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            matterService.remove(matterQueryWrapper);
            // 鉴定车辆
            QueryWrapper<IdentifiedCar> carQueryWrapper = new QueryWrapper<>();
            carQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            carService.remove(carQueryWrapper);
            // 鉴定物
            QueryWrapper<IdentifiedObject> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            objectService.remove(objectQueryWrapper);
            // 鉴定人
            QueryWrapper<IdentifiedPerson> personQueryWrapper = new QueryWrapper<>();
            personQueryWrapper.eq(ids.get(i) != null, "case_id", ids.get(i));
            personService.remove(personQueryWrapper);
        }
        return caseService.removeByIds(ids);
    }

    // 根据案例ID修改状态
    @Override
    public boolean stauts(@RequestParam("ids") List<String> ids, @RequestParam("status") int status) {
        Collection<Case> cases = caseService.listByIds(ids);
        for (Case aCase : cases) {
            aCase.setStatus(status);
        }
        return caseService.updateBatchById(cases);
    }

    // 删除单个案例
    @Override
    public boolean deleteCase(@RequestParam("id") Long id) {
        return caseService.removeById(id);
    }

    // 修改案例（此处清空子表数据）
    @Override
    public CaseEntity updateCase(@RequestBody CaseEntity cases) {
        Case aCase = dozerMapper.map(cases, Case.class);
        // 添加时，需要先将caseId放到每个子表中的list中进行添加
        caseService.updateById(aCase);
        // 收费说明
        CaseCharging charging = new CaseCharging();
        charging.setCaseId(aCase.getId());
        chargingService.remove(new QueryWrapper<>(charging));
        // 鉴定材料
        CaseMaterial material = new CaseMaterial();
        material.setCaseId(aCase.getId());
        materialService.remove(new QueryWrapper<>(material));
        // 鉴定事项
        IdentificationMatter matter = new IdentificationMatter();
        matter.setCaseId(aCase.getId());
        matterService.remove(new QueryWrapper<>(matter));
        // 鉴定人
        IdentifiedPerson person = new IdentifiedPerson();
        person.setCaseId(aCase.getId());
        personService.remove(new QueryWrapper<>(person));
        // 鉴定物
        IdentifiedObject object = new IdentifiedObject();
        object.setCaseId(aCase.getId());
        objectService.remove(new QueryWrapper<>(object));
        // 鉴定车
        IdentifiedCar car = new IdentifiedCar();
        car.setCaseId(aCase.getId());
        carService.remove(new QueryWrapper<>(car));
        QueryWrapper<CaseSample> caseSampleQueryWrapper = new QueryWrapper<>();
        caseSampleQueryWrapper.eq(aCase.getId() != null, "case_id", aCase.getId());
        List<CaseSample> list = caseSampleService.list(caseSampleQueryWrapper);
        if(list.size()>0){
            Collection<Long> sampleList = new ArrayList<>();
            for(int j=0;j<list.size();j++){
                sampleList.add(list.get(j).getSampleId());
            }
            sampleService.removeByIds(sampleList);
        }
        // 案例样本
        CaseSample caseSample = new CaseSample();
        caseSample.setCaseId(aCase.getId());
        caseSampleService.remove(new QueryWrapper<>(caseSample));
        return this.insertCase(cases);
    }

    // 数量
    @Override
    public int countCase(@RequestBody CaseQuery cases) {
        QueryWrapper<Case> queryWrapper = new QueryWrapper<>();
        return caseService.count(queryWrapper);
    }

    // 根据案例ID查询数据
    @Override
    public List<CaseEntity> getCaseIds(@RequestParam("ids") List<Long> ids) {
        return dozerMapper.map(caseService.listByIds(ids), List.class);
    }
}
