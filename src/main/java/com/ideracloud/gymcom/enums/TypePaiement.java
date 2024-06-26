package com.ideracloud.gymcom.enums;

public enum TypePaiement {
    ESPECE("Espèce"),
    CHEQUE("Chèque"),
    VIREMENT("Virement bancaire");

    public String description;

    TypePaiement(String description) {
        this.description = description;
    }
}
