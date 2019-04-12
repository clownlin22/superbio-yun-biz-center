package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.CaseEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.CaseQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.net.SocketException;
import java.util.List;

@Api(tags = "案例接口")
@RequestMapping("/service/api/case")
public interface CaseServiceApi {

    /**
     * 查询List
     */
    @ApiOperation(value = "根据条件查询案例", notes = "根据条件查询案例")
    @RequestMapping(value = "/caseList", method = RequestMethod.POST)
    List<CaseEntity> caseList(@RequestBody CaseQuery caseQuery) throws SocketException;

    /**
     * 查询单个
     */
    @ApiOperation(value = "获取案例信息接口", notes = "获取案例信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案例编号", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getCaseById", method = RequestMethod.GET)
    CaseEntity getCaseById(@RequestParam("id") Long id);

    /**
     * 根据ID查询鉴定材料
     */
    @ApiOperation(value = "获取案例信息接口", notes = "获取案例信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案例编号", required = true, paramType = "query", example = "123")
    })
    @RequestMapping(value = "/getMaterialsById", method = RequestMethod.GET)
    CaseEntity getMaterialsById(@RequestParam("id") Long id);

    /**
     * 添加
     */
    @ApiOperation(value = "添加案例信息", notes = "添加案例信息")
    @RequestMapping(value = "/saveCase", method = RequestMethod.POST)
    CaseEntity saveCase(@RequestBody CaseEntity cases);

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除案例信息接口", notes = "批量删除案例信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定案例编号", dataType = "String", allowMultiple = true, required = true)

    })
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    boolean remove(@RequestParam("ids") List<String> ids);

    /**
     * 删除
     */
    @ApiOperation(value = "批量修改案例信息状态", notes = "批量修改案例信息状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定案例编号", dataType = "String", allowMultiple = true, required = true),
            @ApiImplicitParam(name = "status", value = "案例状态", dataType = "int", required = true)
    })
    @RequestMapping(value = "/stauts", method = RequestMethod.POST)
    boolean stauts(@RequestParam("ids") List<String> ids, @RequestParam("status") int status);

    /**
     * 删除
     */
    @ApiOperation(value = "删除案例信息接口", notes = "删除案例信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案例编号", required = true, paramType = "query")
    })
    @RequestMapping(value = "/deleteCase", method = RequestMethod.GET)
    boolean deleteCase(@RequestParam("id") Long id);

    /**
     * 修改
     */
    @ApiOperation(value = "修改案例信息", notes = "修改案例信息")
    @RequestMapping(value = "/updateCase", method = RequestMethod.POST)
    CaseEntity updateCase(@RequestBody CaseEntity cases);

    /**
     * 总条数
     */
    @ApiOperation(value = "查询案例信息列表总记录数", notes = "查询案例信息列表总记录数")
    @RequestMapping(value = "countCase", method = RequestMethod.POST)
    int countCase(@RequestBody CaseQuery cases);


    /**
     * 删除
     */
    @ApiOperation(value = "根据案例ID查询数据", notes = "根据案例ID查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "指定案例编号", dataType = "Long", allowMultiple = true, required = true),
    })
    @RequestMapping(value = "/getCaseIds", method = RequestMethod.POST)
    List<CaseEntity> getCaseIds(@RequestParam("ids") List<Long> ids);

    /**
     * 修改
     */
    @ApiOperation(value = "修改案例信息", notes = "修改案例信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    CaseEntity insertCase(@RequestBody CaseEntity cases);

}
