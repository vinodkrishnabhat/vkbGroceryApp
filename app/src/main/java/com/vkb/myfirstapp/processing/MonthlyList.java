package com.vkb.myfirstapp.processing;

import android.support.annotation.NonNull;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public class MonthlyList {
    public static Map<String, String> getMonthlyListAsMap() {
        Map<BuyLocationEnum, Map<String, Double>> monthlyMap = getMonthlyList();

        Map<String, String> retMap = new LinkedHashMap<>();

        for (BuyLocationEnum buyLocation : BuyLocationEnum.values()) {
            Map<String, Double> buyLocationList = monthlyMap.get(buyLocation);
            if(buyLocationList == null) {
                continue;
            }

            String buyLocationStr = buyLocation.toString();
            String listStr = getListAsString(buyLocationList);

            retMap.put(buyLocationStr, listStr);
        }

        return retMap;
    }

    public static Map<String, String> getInfrequentListAsMap() {
        Map<String, MasterItem> masterList = MasterList.getInstance().getMasterList();

        Map<String, String> retMap = new LinkedHashMap<>();

        for (String key : masterList.keySet()) {
            MasterItem masterItem = masterList.get(key);

            if (FrequencyEnum.RARELY.equals(masterItem.getFrequency())) {
                String list = retMap.get(masterItem.getBuyAt().toString());
                if(list == null) {
                    list = "";
                }
                list += key + "     ";

                retMap.put(masterItem.getBuyAt().toString(), list);
            }
        }

        return retMap;
    }

    private static Map<BuyLocationEnum, Map<String, Double>> getMonthlyList() {
        Map<String, MasterItem> masterList = MasterList.getInstance().getMasterList();

        Map<BuyLocationEnum, Map<String, Double>> retList = new LinkedHashMap<>();

        for (String key : masterList.keySet()) {
            MasterItem masterItem = masterList.get(key);

            if (FrequencyEnum.RARELY.equals(masterItem.getFrequency())) {
                continue;
            }
            else if (FrequencyEnum.MONTHLY.equals(masterItem.getFrequency())) {
                populateRetList(retList, key, masterItem);
            }
            else {
                throw new IllegalArgumentException("Unknown Frequency::" + masterItem.getFrequency().toString());
            }
        }

        return retList;
    }

    private static void populateRetList(Map<BuyLocationEnum, Map<String, Double>> retList, String key, MasterItem masterItem) {
        Double masterQuantity = getQuantityInKG(masterItem);
        Double existingQuantity = ExistingItems.getInstance().getExistingQuantity(key);

        Double orderQuantity = (masterQuantity > existingQuantity) ? (masterQuantity - existingQuantity) : 0;

        Map<String, Double> retMap = retList.get(masterItem.getBuyAt());
        if (retMap == null) {
            retMap = new LinkedHashMap<>();
        }
        retMap.put(key, orderQuantity);

        retList.put(masterItem.getBuyAt(), retMap);
    }

    private static Double getQuantityInKG(MasterItem masterItem) {
        Double qty = masterItem.getQty();

        switch(masterItem.getUnit()) {
            case KG:
                break;
            case GRAMS:
                qty /= 1000;
                break;
            case LITRE:
                break;
            case ML:
                break;
            case PACK:
                break;
            default:
                throw new IllegalArgumentException("Unknown Unit::" + masterItem.getUnit());
        }

        return qty;
    }


    @NonNull
    private static String getListAsString(Map<String, Double> list) {
        String retStr = "";

        for (String key : list.keySet()) {
            Double value = list.get(key);

            if (value > 0) {
                retStr += key + " - " + value + "     ";
            }
        }

        return retStr;
    }
}
