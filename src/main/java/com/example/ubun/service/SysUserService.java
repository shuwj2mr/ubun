package com.example.ubun.service;

import com.example.ubun.pojo.model.SysUser;

public interface SysUserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    SysUser login(String username, String password);
}
