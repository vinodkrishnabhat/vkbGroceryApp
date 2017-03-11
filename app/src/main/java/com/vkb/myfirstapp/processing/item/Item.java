package com.vkb.myfirstapp.processing.item;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;

abstract class Item {
    private String name;
    private Double qty;
    private UnitEnum unit;
    private FrequencyEnum frequency;
    private BuyLocationEnum buyAt;

    protected Item(FrequencyEnum frequency, String name, Double qty, UnitEnum unit, BuyLocationEnum buyAt) {
        this.frequency = frequency;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.buyAt = buyAt;
    }

    public String getName() {
        return name;
    }

    public Double getQty() {
        return qty;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public FrequencyEnum getFrequency() {
        return frequency;
    }

    public BuyLocationEnum getBuyAt() {
        return buyAt;
    }
}
