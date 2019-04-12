package cn.superbio.judicial.cloud.biz.cases.service.impl;

import cn.superbio.judicial.cloud.biz.cases.DO.Case;
import cn.superbio.judicial.cloud.biz.cases.mapper.CaseMapper;
import cn.superbio.judicial.cloud.biz.cases.service.CaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {

}
