package com.queonetics.association.models.enums;

public enum EnumStatus {

    AVAILABLE(1L, "Disponível"),
    UNAVAILABLE(2l, "Associado");

    private Long id;
    private String description;

    EnumStatus(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public String getValue(){
        return this.description;
    }
}
