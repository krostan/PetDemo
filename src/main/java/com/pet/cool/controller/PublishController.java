package com.pet.cool.controller;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;
import com.pet.cool.entity.User;
import com.pet.cool.service.PetService;
import com.pet.cool.service.PublishService;
import com.pet.cool.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
    創建刊登：/publish/create
    讀取(除了自己的刊登)的刊登：/publish/allPublishes
    顯示自己的刊登：/publish/myPublishes
    刪除刊登：/publish/{publishId}/delete
* */
@Controller
@RequestMapping("/publish")
public class PublishController {

    private PetService petService;

    private UserService userService;

    private PublishService publishService;

    @Autowired
    public PublishController(PetService thePetService, UserService theUserService, PublishService thePublishService){
        this.petService = thePetService;
        this.userService = theUserService;
        this.publishService = thePublishService;
    }

    @PostMapping("/create")
    public String create(@RequestParam("petId") String petId, HttpSession session){

        String userName = (String) session.getAttribute("userName");

        // 取得目前使用者編號
        User user = userService.findByUserName(userName);
        int userId = user.getUserId();

        // 將 ajax傳過來的 (由一堆petId組成的字串)分解成一個個petId
        String[] petIds = petId.split(",");

        // 判斷是否已經刊登過此寵物
        Publish publish;

        // 取得目前時間
        LocalDateTime currDateTime = LocalDateTime.now();

        // 如果目前寵物編號 已有在刊登表上 就不刊登
        for (String idStr : petIds) {

            // 字串轉整數
            int id = Integer.parseInt(idStr);
            // 判斷該寵物是否已經刊登
            publish = publishService.findByPetId(id);

            if (publish == null) {
               publishService.save(currDateTime, id, userId);
            }
        }

        return "redirect:/member";
    }

    @GetMapping("/allPublishes")
    public String searchAllPublishes(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        User user = userService.findByUserName(userName);

        List<Publish> publishList = publishService.getAllPublishes(user.getUserId());

        List<Pet> petList = new ArrayList<>();

        for(Publish publish : publishList){
            petList.add(publish.getPet());
        }

        model.addAttribute("pets", petList);

        return "pets/list-pets";
    }

    @PostMapping("/sortByPet")
    public String sortByPet(@RequestParam("sortData") String sortData
            , HttpSession session, Model model){

        String userName = (String) session.getAttribute("userName");
        User user = userService.findByUserName(userName);

        List<Publish> publishList = publishService.sortAllPublishes(sortData);

        List<Pet> petList = new ArrayList<>();

        for(Publish publish : publishList){
            petList.add(publish.getPet());
        }

        model.addAttribute("pets", petList);

        return "pets/list-pets";
    }

    @GetMapping("/myPublishes")
    public String myPublishes(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        User user = userService.findByUserName(userName);

        List<Publish> publishList = publishService.getUserPublishByUserId(user.getUserId());

        List<Pet> petList = new ArrayList<>();

        for(Publish publish : publishList){
            petList.add(publish.getPet());
        }

        model.addAttribute("pets", petList);

        return "members/showMyPublishes";
    }

    @GetMapping("/deletePublish/{petId}")
    public String myPublishes(Model theModel, @PathVariable("petId") int petId){

        System.out.println(petId);

        publishService.deletePublish(petId);
        return "redirect:/publish/myPublishes";
    }
}
