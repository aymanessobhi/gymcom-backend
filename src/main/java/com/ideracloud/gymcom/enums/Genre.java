package com.ideracloud.gymcom.enums;

public enum Genre {
    HOMME("Homme"),FEMME("Femme"),ENFANT("Enfant < 15 ans");
    public String description;

    Genre(String desc){
        description = desc;
    }


}
