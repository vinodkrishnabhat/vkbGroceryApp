package com.vkb.myfirstapp.processing;

import android.support.annotation.NonNull;

import com.vkb.myfirstapp.processing.enums.BuyLocationEnum;
import com.vkb.myfirstapp.processing.enums.FrequencyEnum;
import com.vkb.myfirstapp.processing.enums.UnitEnum;
import com.vkb.myfirstapp.processing.item.MasterItem;
import com.vkb.myfirstapp.processing.item.PurchaseItem;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class MonthlyList {
    private static DecimalFormat FORMATTER = new DecimalFormat("0.###");

    public static Map<String, String> getMonthlyListAsMap() {
        Map<BuyLocationEnum, Map<String, PurchaseItem>> monthlyMap = getMonthlyList();

        Map<String, String> retMap = new LinkedHashMap<>();

        for (BuyLocationEnum buyLocation : BuyLocationEnum.values()) {
            Map<String, PurchaseItem> buyLocationList = monthlyMap.get(buyLocation);
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
                list += key + " ____ ____     ";

                retMap.put(masterItem.getBuyAt().toString(), list);
            }
        }

        return retMap;
    }

    private static Map<BuyLocationEnum, Map<String, PurchaseItem>> getMonthlyList() {
        Map<String, MasterItem> masterList = MasterList.getInstance().getMasterList();

        Map<BuyLocationEnum, Map<String, PurchaseItem>> retList = new LinkedHashMap<>();

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

    private static void populateRetList(Map<BuyLocationEnum, Map<String, PurchaseItem>> retList, String key, MasterItem masterItem) {
        Double masterQuantity = getQuantityInKG(masterItem);
        Double existingQuantity = ExistingItems.getInstance().getExistingQuantity(key);

        Double orderQuantity = (masterQuantity > existingQuantity) ? (masterQuantity - existingQuantity) : 0;

        Map<String, PurchaseItem> retMap = retList.get(masterItem.getBuyAt());
        if (retMap == null) {
            retMap = new LinkedHashMap<>();
        }

        PurchaseItem purchaseItem;

        if(orderQuantity < 1) {
            purchaseItem = PurchaseItem.getPurchaseItem(masterItem, orderQuantity * 1000, UnitEnum.g);
        }
        else {
            purchaseItem = PurchaseItem.getPurchaseItem(masterItem, orderQuantity, masterItem.getUnit());
        }

        retMap.put(key, purchaseItem);

        retList.put(masterItem.getBuyAt(), retMap);
    }

    private static Double getQuantityInKG(MasterItem masterItem) {
        Double qty = masterItem.getQty();

        switch(masterItem.getUnit()) {
            case KG:
                break;
            case g:
                qty /= 1000;
                break;
            case L:
                break;
            case ML:
                break;
            case pack:
                break;
            default:
                throw new IllegalArgumentException("Unknown Unit::" + masterItem.getUnit());
        }

        return qty;
    }

    @NonNull
    private static String getListAsString(Map<String, PurchaseItem> list) {
        String retStr = "";

        for (String key : list.keySet()) {
            PurchaseItem purchaseItem = list.get(key);

            if (purchaseItem.getQty() > 0) {
                retStr += key + "-" + FORMATTER.format(purchaseItem.getQty()) + purchaseItem.getUnit() + "     ";
            }
        }

        return retStr;
    }
}