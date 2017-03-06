package com.vkb.myfirstapp.processing.enums;

/**
 * Created by Maha on 05-Mar-17.
 */

public enum BuyLocationEnum {
    FOODWORLD ("FoodWorld"), PATANJALI("Patanjali"), SHETTY("Shetty"), DMART("DMart");

    private final String name;

    BuyLocationEnum(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
