package com.example.ubun.controller.system;

import com.example.ubun.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    public void login(){
        System.out.println (1);
    }
}
