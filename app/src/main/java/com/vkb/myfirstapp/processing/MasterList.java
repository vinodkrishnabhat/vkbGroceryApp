package com.vkb.myfirstapp.processing;

import android.support.annotation.NonNull;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Maha on 05-Mar-17.
 */

public class MasterList {
    private static final MasterList ourInstance = new MasterList();

    public static MasterList getInstance() {
        return ourInstance;
    }

    private Map<String, MasterItem> masterList;

    private MasterList() {
        masterList = new LinkedHashMap<>();

        populateMasterList();
        populateRareList();
    }

    private void populateMasterList() {
        addToMasterList("Thick Avalakki", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Thin Avalakki", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Kadale Puri", 0.8, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Black Chana", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Fried Gram", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Green Moong Dal", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Green Peas", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Kabul Chana", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Moong Dal", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Peanuts", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Toor Dal", 6.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Urad Dal", 3.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Kadale Bele", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Gram Flour", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Idli Rava", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Maida Flour", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Rava Ordinary", 2.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Rice Flour", 1.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Ragi Flour", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Rice Sevai", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Wheat Flour", 5.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Nirmal Coconut", 1.0, UnitEnum.LITRE, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Sunflower Oil", 3.0, UnitEnum.LITRE, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Boost", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Sugar", 5.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Salt", 4.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Byadagi Chilli", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Coriander Seeds", 250.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Jaggery", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Jeera", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Methi Seeds", 300.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Mustard Seeds", 300.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Tamarind", 0.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Bisibelebath powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Chilli powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Coriander powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Cumin powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Garam masala powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Rasam powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Vangibath powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Puliyogare powder", 200.0, UnitEnum.GRAMS, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Biscuit", 1.0, UnitEnum.PACK, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Rice", 25.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Tea Powder", 1.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Surf Excel Powder", 1.5, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Surf Excel Soap", 4.0, UnitEnum.PACK, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Vim Soap", 4.0, UnitEnum.PACK, FrequencyEnum.MONTHLY, BuyLocationEnum.PATANJALI);
        addToMasterList("Soaps", 5.0, UnitEnum.PACK, FrequencyEnum.MONTHLY, BuyLocationEnum.PATANJALI);
        addToMasterList("Parachute Oil", 0.5, UnitEnum.LITRE, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Gingelly oil (cooking)", 1.0, UnitEnum.LITRE, FrequencyEnum.MONTHLY, BuyLocationEnum.DMART);
        addToMasterList("Dappakki (Fat Rice)", 3.0, UnitEnum.KG, FrequencyEnum.MONTHLY, BuyLocationEnum.SHETTY);
        addToMasterList("Gingelly oil (deepa)", 3.0, UnitEnum.LITRE, FrequencyEnum.MONTHLY, BuyLocationEnum.SHETTY);
    }
    
    private void addToMasterList(String name, Double qty, UnitEnum unit, FrequencyEnum frequency, BuyLocationEnum buyAt) {
        String key = getKey(name);
        MasterItem item = new MasterItem(name, qty, unit, frequency, buyAt);
        
        masterList.put(key, item);
    }

    private void populateRareList() {
        addToMasterList("Bansi Rava", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Rava Idli Mix", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Maggi Hot & Sweet", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Chilli Sauce", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Pasta", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Tomato Ketchup", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Chakke", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Gasagase", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Sabbakki", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Asafoetida", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Saumph", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("White Til", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Badam Powder", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Chocos", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Honey", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Jam", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Quaker Oats", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Honey Loops", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Front Load Powder", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Bleaching Powder", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Harpic", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Lizol", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Tissues", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Match Box", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Toothbrush", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.FOODWORLD);
        addToMasterList("Colgate", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Handwash", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Talcum Powder", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Nivea Blue", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Nyle shampoo", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Vaseline mosturizer", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Vicks Vaporub", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Scotch Brite", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
        addToMasterList("Shaving Cream", 0.0, UnitEnum.PACK, FrequencyEnum.RARELY, BuyLocationEnum.DMART);
    }

    public String[] getItemNames() {
        Set<String> itemSet = masterList.keySet();

        return itemSet.toArray(new String[itemSet.size()]);
    }

    public Map<String, MasterItem> getMasterList() {
        return masterList;
    }

    @NonNull
    private String getKey(String item) {
        return item;
    }
}
