package com.pet.cool.service;

import com.pet.cool.Exception.PetNotFoundException;
import com.pet.cool.dao.PetDao;
import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import com.pet.cool.pet.PetSize;
import com.pet.cool.pet.PetSpecies;
import com.pet.cool.pet.WebPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    private PetDao petDao;

    @Autowired
    public PetServiceImpl(PetDao thePetDao){
        this.petDao = thePetDao;
    }

    @Override
    public void save(Pet pet, WebPet webPet, String imagePath, User user) {
        pet.setPetName(webPet.getPetName());
        pet.setBreed(webPet.getBreed());
        pet.setGender(webPet.getGender());
        pet.setCoatColor(webPet.getCoatColor());
        pet.setAge(webPet.getAge());
        pet.setLocation(webPet.getLocation());

        // 種類
        String specie = PetSpecies.getOtionPetSpeciesByValue(webPet.getSpecies());
        pet.setSpecies(specie);

        // 品種
        String size = PetSize.getOptionPetSizeByValue(webPet.getSize());
        pet.setSize(size);

        pet.setQuest(webPet.getQuest());

        pet.setPhotos(imagePath);
        pet.setEnabled(true);
        pet.setUser(user);

        petDao.save(pet);
    }

    @Override
    public void disablePetByPetId(int petId) throws PetNotFoundException{

        Pet pet = petDao.findById(petId);

        if(pet!=null){
            pet.setEnabled(false);
            petDao.disablePet(pet);
        }else{
            throw new PetNotFoundException("沒有該寵物編號: " + petId);
        }

    }

    @Override
    public Pet findById(int petId) {
        return petDao.findById(petId);
    }

    @Override
    public List<Pet> findAllByUserId(int userId) {
        return petDao.findAllByUserId(userId);
    }
}
