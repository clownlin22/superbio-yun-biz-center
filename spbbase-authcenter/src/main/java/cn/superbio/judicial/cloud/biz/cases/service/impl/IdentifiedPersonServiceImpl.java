package cn.superbio.judicial.cloud.biz.cases.service.impl;

import cn.superbio.judicial.cloud.biz.cases.DO.IdentifiedPerson;
import cn.superbio.judicial.cloud.biz.cases.mapper.IdentifiedPersonMapper;
import cn.superbio.judicial.cloud.biz.cases.service.IdentifiedPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class IdentifiedPersonServiceImpl extends ServiceImpl<IdentifiedPersonMapper, IdentifiedPerson> implements IdentifiedPersonService {

}
