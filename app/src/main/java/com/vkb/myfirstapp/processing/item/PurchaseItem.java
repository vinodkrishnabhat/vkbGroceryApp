package com.vkb.myfirstapp.processing.item;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;

public class PurchaseItem extends Item {
    private PurchaseItem(String name, Double qty, UnitEnum unit, FrequencyEnum frequency, BuyLocationEnum buyAt) {
        super(frequency, name, qty, unit, buyAt);
    }

    public static PurchaseItem getPurchaseItem(MasterItem masterItem, Double qty, UnitEnum unit) {
        return new PurchaseItem(masterItem.getName(), qty, unit, masterItem.getFrequency(), masterItem.getBuyAt());
    }
}
