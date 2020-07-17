package com.xzw.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/link")
public class GotoPageController {

    @RequestMapping(value = "/gotoLoginClient")
    public String gotoLogin(){
        return "login";
    }
}
