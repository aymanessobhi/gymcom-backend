package com.ideracloud.gymcom.enums;

public enum TypeDocument {
    CIN_R("Carte d'identité nationale (recto)"),
    CIN_V("Carte d'identité nationale (verso)"),
    PHOTO("Photo");

    public String description;

    TypeDocument(String description) {
        this.description = description;
    }
}
