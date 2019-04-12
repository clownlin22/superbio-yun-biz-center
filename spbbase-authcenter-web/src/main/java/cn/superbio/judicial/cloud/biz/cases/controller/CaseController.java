package cn.superbio.judicial.cloud.biz.cases.controller;

import cn.superbio.judicial.cloud.biz.cases.consumer.AttachmentConsumer;
import cn.superbio.judicial.cloud.biz.cases.consumer.CaseServiceConsumer;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseMaterialEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseQuery;
import cn.superbio.spbbase.attachment.service.api.entity.Attachment;
import cn.superbio.spbbase.core.pagination.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "案例服务接口")
@RequestMapping("/api/case")
@RestController
public class CaseController {

    @Autowired
    private CaseServiceConsumer serviceConsumer;
    @Autowired
    private AttachmentConsumer attachmentConsumer;

    @ApiOperation(value = "根据条件查询案例", notes = "根据条件查询案例")
    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public List<CaseEntity> list(CaseQuery query) throws SocketException {
        return serviceConsumer.caseList(query);
    }

    @ApiOperation(value = "获取单个案例信息", notes = "获取单个案例信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "long", value = "案例编号", required = true),
    })
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public CaseEntity get(String id) {
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setStatus(11);
        caseEntity.setCaseNo("123123");
        caseEntity.setCaseCategoryId(123123L);
        return caseEntity;
//        Long ids = Long.valueOf(id);
//        return serviceConsumer.getCaseById(ids);
    }

    @ApiOperation(value = "根据ID查询鉴定材料", notes = "根据ID查询鉴定材料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "long", value = "案例编号", required = true),
    })
    @RequestMapping(value = "/getMaterials", method = {RequestMethod.GET})
    public CaseEntity getMaterials(String id) {
        Long ids = Long.valueOf(id);
        return serviceConsumer.getMaterialsById(ids);
    }

    @ApiOperation(value = "调整某个案例审核状态", notes = "调整某个案例审核状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "案例编号", allowMultiple = true, dataType = "string", required = true),
            @ApiImplicitParam(name = "status", value = "新的状态", dataType = "int", required = true)
    })
    @RequestMapping(value = "/status", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public String status(@RequestParam("ids") List<String> ids, @RequestParam("status") int status) {
        boolean str = serviceConsumer.stauts(ids, status);
        if (str) {
            return "true";
        }
        return null;
    }

    @ApiOperation(value = "新增案例信息", notes = "新增案例信息")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public CaseEntity save(@RequestBody @Validated CaseEntity caseVo) {
        CaseEntity caseEntity = serviceConsumer.saveCase(caseVo);
        List<CaseMaterialEntity> caseMaterial = caseEntity.getCaseMaterial();
        if (caseMaterial.size() > 0) {
            List<Attachment> attachmentList = new ArrayList<>();
            for (int i = 0; i < caseMaterial.size(); i++) {
                if (caseMaterial.get(i).getAttachmentId() != null) {
                    Attachment attachment = new Attachment();
                    attachment.setBizId(caseMaterial.get(i).getId());
                    attachment.setId(caseMaterial.get(i).getAttachmentId());
                    attachmentList.add(attachment);
                }
            }
            if (attachmentList.size() > 0) {
                attachmentConsumer.update(attachmentList);
            }
        }
        return caseEntity;
    }

    @ApiOperation(value = "更新案例信息", notes = "更新案例信息")
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public CaseEntity update(@RequestBody CaseEntity caseVo) {
        CaseEntity caseEntity = serviceConsumer.updateCase(caseVo);
        List<CaseMaterialEntity> caseMaterial = caseEntity.getCaseMaterial();
        if (caseMaterial.size() > 0) {
            List<Attachment> attachmentList = new ArrayList<>();
            for (int i = 0; i < caseMaterial.size(); i++) {
                if (caseMaterial.get(i).getAttachmentId() != null) {
                    Attachment attachment = new Attachment();
                    attachment.setBizId(caseMaterial.get(i).getId());
                    attachment.setId(caseMaterial.get(i).getAttachmentId());
                    attachmentList.add(attachment);
                }
            }
            if (attachmentList.size() > 0) {
                attachmentConsumer.update(attachmentList);
            }
        }
        return caseEntity;
    }

    @ApiOperation(value = "批量删除指定案例", notes = "批量删除指定案例")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定案例编号", dataType = "string", allowMultiple = true, required = true)
    })
    @RequestMapping(value = "removeBatch", method = {RequestMethod.GET})
    @ResponseStatus(value = HttpStatus.CREATED)
    public String remove(@RequestParam("ids") List<String> ids) {
        boolean res = serviceConsumer.remove(ids);
        if (res) {
            return "true";
        }
        return null;
    }
}
