package com.example.ubun.controller.system;

import com.example.ubun.pojo.model.SysUser;
import com.example.ubun.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public void login(@RequestParam() String username,
                      @RequestParam() String password) {
        SysUser sysUser = sysUserService.login (username, password);
        return;
    }
}
