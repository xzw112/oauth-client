package com.xzw.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/r")
public class TestController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')") // 拥有p1权限方可访问此url
    public String r1(){
        return "成功访问r1资源";
    }

    @GetMapping(value = "/r2")
    @PreAuthorize("hasAnyAuthority('p2')") // 拥有p1权限方可访问此url
    public String r2(){
        return "成功访问r2资源";
    }

}
