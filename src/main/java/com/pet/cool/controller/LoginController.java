package com.pet.cool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLogin")
    public String showMyLoginPage(){

        return "members/loginPage";
    }

    // 拒絕訪問
    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "role/access-denied";
    }

}
