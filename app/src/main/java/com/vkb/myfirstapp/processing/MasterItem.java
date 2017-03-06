package com.vkb.myfirstapp.processing;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;

/**
 * Created by Maha on 05-Mar-17.
 */

public class MasterItem {

    private String name;
    private Double qty;
    private UnitEnum unit;
    private FrequencyEnum frequency;
    private BuyLocationEnum buyAt;

    public MasterItem(String name, Double qty, UnitEnum unit, FrequencyEnum frequency, BuyLocationEnum buyAt) {
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.frequency = frequency;
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
