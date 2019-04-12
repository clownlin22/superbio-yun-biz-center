package cn.superbio.judicial.cloud.biz.cases.service.impl;

import cn.superbio.judicial.cloud.biz.cases.DO.AuthUser;
import cn.superbio.judicial.cloud.biz.cases.mapper.AuthUserMapper;
import cn.superbio.judicial.cloud.biz.cases.service.AuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

}
