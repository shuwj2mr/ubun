package com.example.ubun.service.impl;

import com.example.ubun.mapper.SysUserMapper;
import com.example.ubun.pojo.model.SysUser;
import com.example.ubun.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(String username, String password) {
        return sysUserMapper.login(username,password);
    }
}
