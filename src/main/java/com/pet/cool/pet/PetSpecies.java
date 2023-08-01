package com.pet.cool.pet;

public enum PetSpecies {
    DOG("1", "狗狗"),
    CAT("2", "貓貓"),
    RABBIT("3", "兔兔"),
    PIG("4", "豬豬"),
    GECKO("5", "守宮"),
    SNAKE("6", "蛇蛇"),
    BEAR("7", "熊熊"),
    MOUSE("8", "鼠鼠");

    private final String value;

    private final String optionPetSpecies;

    PetSpecies(String value, String optionPetSpecies) {
        this.value = value;
        this.optionPetSpecies = optionPetSpecies;
    }

    public String getValue() {
        return value;
    }

    public String getOptionPetSpecies() {
        return optionPetSpecies;
    }

    public static String getOtionPetSpeciesByValue(String value){
        for(PetSpecies species : PetSpecies.values()){
            if(species.getValue().equals(value)){
                return species.getOptionPetSpecies();
            }
        }

        return null;
    }

    public static String getValueByOtionPetSpecies(String optionPetSpecies){
        for(PetSpecies species : PetSpecies.values()){
            if(species.getOptionPetSpecies().equals(optionPetSpecies)){
                return species.getValue();
            }
        }

        return null;
    }
}
