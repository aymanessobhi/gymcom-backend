package com.ideracloud.gymcom.enums;

public enum TypeAbonnement {
    ABONN1("Mentuelle"),
    ABONN2("Trimestriellle"),
    ABONN3("Annuelle");

    public String description;

    TypeAbonnement(String description) {
        this.description = description;
    }
}
