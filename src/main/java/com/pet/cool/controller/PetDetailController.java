package com.pet.cool.controller;

import com.pet.cool.Exception.PetNotFoundException;
import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import com.pet.cool.file.FileOutput;
import com.pet.cool.pet.PetSize;
import com.pet.cool.pet.PetSpecies;
import com.pet.cool.pet.WebPet;
import com.pet.cool.service.PetService;
import com.pet.cool.service.UserService;
import com.pet.cool.user.WebUser;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/pets")
public class PetDetailController {

    private PetService petService;

    private UserService userService;

    @Autowired
    public PetDetailController(PetService thePetService, UserService theUserService){
        this.petService = thePetService;
        this.userService = theUserService;
    }

    // show
    @GetMapping("/showPetForm")
    public String showPetForm(Model theModel){
        theModel.addAttribute("webPet", new WebPet());

        return "pets/pet-form";
    }

    // save
    @PostMapping("/processPetForm")
    public String processPetForm(@Valid @ModelAttribute WebPet theWebPet,
                                 @RequestParam("image") MultipartFile image,
                                 HttpSession session,
                                 HttpServletRequest request) throws IOException {
        String userName = (String) session.getAttribute("userName");

        User user = userService.findByUserName(userName);
        Pet pet = new Pet();

        // 處理上傳檔案
        // 使用者資料夾
        String mk = File.separator + user.getUserId();
        // 設定儲存檔案的資料夾路徑
        String savePath = request.getSession().getServletContext().getRealPath("") + "images" + mk;
        // 儲存檔案
        FileOutput.saveFile(image, savePath);
        // 得到新檔名
        String fileName = FileOutput.generateFileName(image);

        // 要儲存到資料庫的路徑 顯示時 可以直接使用的路徑
        String imagePath = File.separator + "images" + mk + File.separator + fileName;

        petService.save(pet, theWebPet, imagePath, user);

        return "redirect:/member";
    }

    // search
    @GetMapping("/{petId}/edit")
    public String searchPet(Model theModel, @PathVariable ("petId") int petId){

        Pet pet = petService.findById(petId);

        // 將Pet轉換成 WebPet
        theModel.addAttribute("webPet", convertToWebPet(pet));

        theModel.addAttribute("petId",pet.getPetId());
        theModel.addAttribute("imagePath",pet.getPhotos());

        return "pets/update-pet";
    }

    // update
    @PostMapping("/{petId}")
    public String updatePet(@Valid @ModelAttribute WebPet theWebPet,
                            @RequestParam("image") MultipartFile image,
                            @PathVariable ("petId") int petId,
                            HttpSession session,
                            HttpServletRequest request) throws IOException {

        String userName = (String) session.getAttribute("userName");

        User user = userService.findByUserName(userName);
        Pet pet = petService.findById(petId);

        // 處理上傳檔案
        // 使用者資料夾
        String mk = File.separator + user.getUserId();
        // 設定儲存檔案的資料夾路徑
        String savePath = request.getSession().getServletContext().getRealPath("") + "images" + mk;
        // 儲存檔案
        FileOutput.saveFile(image, savePath);
        // 得到新檔名
        String fileName = FileOutput.generateFileName(image);

        // 要儲存到資料庫的路徑 顯示時 可以直接使用的路徑
        String imagePath = File.separator + "images" + mk + File.separator + fileName;

        if(Objects.equals(image.getOriginalFilename(), "")){
            imagePath = pet.getPhotos();
        }

        petService.save(pet, theWebPet, imagePath, user);

        return "redirect:/member";
    }

    // delete
    @GetMapping("/{petId}/disable")
    public String disablePet(@PathVariable ("petId") int petId, Model model){

        try{
            petService.disablePetByPetId(petId);
            return "redirect:/member";
        }catch(PetNotFoundException e){

            model.addAttribute("messageError", e.getMessage());
            return "";
        }

    }

    private WebPet convertToWebPet(Pet pet){
        WebPet webPet = new WebPet();

        webPet.setPetName(pet.getPetName());
        webPet.setBreed(pet.getBreed());
        webPet.setGender(pet.getGender());
        webPet.setCoatColor(pet.getCoatColor());
        webPet.setAge(pet.getAge());
        webPet.setLocation(pet.getLocation());


        webPet.setSpecies(PetSpecies.getValueByOtionPetSpecies(pet.getSpecies()));
        webPet.setSize(PetSize.getValueByOptionPetSize(pet.getSize()));

        webPet.setQuest(pet.getQuest());

        return webPet;
    }



}
