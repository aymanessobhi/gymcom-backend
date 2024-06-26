package com.ideracloud.gymcom.enums;

public enum TypeAbonnement {
    ABONN1("Mentuelle",500),
    ABONN2("Trimestriellle",1000),
    ABONN3("Annuelle",3000);

    public String description;
    public double prix;

    TypeAbonnement(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }
}
