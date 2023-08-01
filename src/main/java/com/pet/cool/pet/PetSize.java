package com.pet.cool.pet;

public enum PetSize {
    SMALL("1", "小型: 0-10kg"),
    MEDIUM("2", "中型: 10-25kg"),
    LARGE("3", "大型: 25-45kg"),
    EXTRA_LARGE("4", "特大型: 45kg以上");

    private final String value;

    private final String optionPetSize;

    PetSize(String value, String optionPetSize) {
        this.value = value;
        this.optionPetSize = optionPetSize;
    }

    public String getValue() {
        return value;
    }

    public String getOptionPetSize() {
        return optionPetSize;
    }

    public static String getOptionPetSizeByValue(String value){
        for(PetSize size : PetSize.values()){
            if(size.getValue().equals(value)){
                return size.getOptionPetSize();
            }
        }

        return null;
    }

    public static String getValueByOptionPetSize(String optionPetSize){
        for(PetSize size : PetSize.values()){
            if(size.getOptionPetSize().equals(optionPetSize)){
                return size.getValue();
            }
        }

        return null;
    }
}
