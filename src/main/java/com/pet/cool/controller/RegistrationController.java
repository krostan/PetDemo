package com.pet.cool.controller;

import com.pet.cool.entity.User;
import com.pet.cool.service.UserService;
import com.pet.cool.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private Logger logger = Logger.getLogger(getClass().getName());
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model theModel){
        // 建立一個webUser物件
        // 當表單送出時 透過@ModelAttribute 獲得
        theModel.addAttribute("webUser",new WebUser());

        return "members/register-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("webUser") WebUser theWebUser,
                                          BindingResult theBindingResult,
                                          HttpSession session, Model theModel){
        String userName = theWebUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        if(theBindingResult.hasErrors()){
            return "members/register-form";
        }

        User existing = userService.findByUserName(userName);

        // 當帳號已存在
        if(existing != null){
            // 重新建立 webUser物件
            theModel.addAttribute("webUser", new WebUser());
            // 傳送錯誤訊息
            theModel.addAttribute("registrationError", "帳號已存在");

            logger.warning("User name already exists.");
            return "members/register-form";
        }

        userService.save(theWebUser);

        session.setAttribute("user",theWebUser);

        return "members/registration-confirmation";
    }
}
