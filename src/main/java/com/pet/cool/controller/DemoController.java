package com.pet.cool.controller;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import com.pet.cool.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {


    private UserService userService;

    @Autowired
    public DemoController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHome(){

        return "home";
    }

    @GetMapping("/animation")
    public String showAnimation(){

        return "animation";
    }

    @GetMapping("/member")
    public String showMemberPage(Model model, HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();

            User user = userService.findByUserName(userName);

            // 因為設定是fetch = FetchType.EAGER, 可直接取得資料
            List<Pet> pets = user.getPets();

            // 找出enable 是1的 pet (1代表未刪除, 0代表刪除)
            List<Pet> enabledPet = new ArrayList<>();

            for(Pet pet : pets){
                if(pet.isEnabled()){
                    enabledPet.add(pet);
                }
            }

            model.addAttribute("pets", enabledPet);
            session.setAttribute("userName", user.getUserName());

            return "members/member";
        }else{
            return "redirect:/showMyLogin";
        }
    }

    @GetMapping("/leaders")
    public String showLeaders(){

        return "role/aCatAndDog";
    }

    @GetMapping("/systems")
    public String showSystems(){

        return "role/systems";
    }

}
