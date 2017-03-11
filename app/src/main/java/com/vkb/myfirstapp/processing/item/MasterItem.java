package com.vkb.myfirstapp.processing.item;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;

public class MasterItem extends Item {

    public MasterItem(String name, Double qty, UnitEnum unit, FrequencyEnum frequency, BuyLocationEnum buyAt) {
        super(frequency, name, qty, unit, buyAt);
    }
}
