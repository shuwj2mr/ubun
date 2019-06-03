package com.example.ubun.service;

import com.example.ubun.pojo.model.SysUser;

public interface SysUserService {
    SysUser login(String username, String password);
}
