package cn.superbio.judicial.cloud.biz.cases;

import cn.superbio.judicial.cloud.biz.cases.entity.DistrictEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictQueryEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "行政区划接口")
@RequestMapping("/service/api/districts")
public interface DistrictServiceApi {

    @ApiOperation(value = "查询行政区划列表", notes = "查询行政区划列表")
    @RequestMapping(value = "list", method = {RequestMethod.POST})
    public List<DistrictEntity> list(@RequestBody DistrictQueryEntity query);

    @ApiOperation(value = "保存行政区划信息", notes = "保存行政区划信息")
    @RequestMapping(value = "ss", method = {RequestMethod.POST})
    //@ResponseStatus(value = HttpStatus.CREATED)
    public DistrictEntity save(@RequestBody DistrictEntity district);


    @ApiOperation(value = "更新行政区划信息", notes = "更新行政区划信息", code = 201)
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public DistrictEntity update(@RequestBody DistrictEntity district);


    @ApiOperation(value = "批量删除指定行政区域", notes = "批量删除指定行政区域")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "codes", value = "行政区划代码", dataType = "string")
    })
    @RequestMapping(value = "", method = {RequestMethod.DELETE})
    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeBatch(@RequestParam(value = "codes", required = true) List<String> codes);

    @ApiOperation(value = "强制删除指定行政区域及其子区域", notes = "批量删除指定行政区域")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "codes", value = "行政区划代码", dataType = "string")
    })
    @RequestMapping(value = "enforcement", method = {RequestMethod.DELETE})
    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void enforcementRemove(@RequestParam(value = "codes", required = true) List<String> codes);


}
