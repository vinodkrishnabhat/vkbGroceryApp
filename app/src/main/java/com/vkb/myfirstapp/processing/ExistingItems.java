package com.vkb.myfirstapp.processing;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.HashMap;


/**
 * Created by Maha on 05-Mar-17.
 */

public class ExistingItems {
    private static final ExistingItems ourInstance = new ExistingItems();

    public static ExistingItems getInstance() {
        return ourInstance;
    }

    private Map<String, Double> existingItems;

    private ExistingItems() {
        existingItems = new HashMap<>();
    }

    public Double addToExistingItems(String existingItem, Double deltaQuantity) {
        Double existingQuantity = getExistingQuantity(existingItem);

        Double newQuantity = existingQuantity + deltaQuantity;

        return replaceExistingItem(existingItem, newQuantity);
    }

    public Double replaceExistingItem(String existingItem, Double newQuantity) {
        return updateQuantity(existingItem, newQuantity);
    }

    private Double updateQuantity(String existingItem, Double newQuantity) {
        String key = getKey(existingItem);
        existingItems.put(key, newQuantity);

        return newQuantity;
    }

    @NonNull
    public Double getExistingQuantity(String existingItem) {
        String key = getKey(existingItem);
        Double currentQuantity = existingItems.get(key);
        if(currentQuantity == null) {
            currentQuantity = 0.0;
        }
        return currentQuantity;
    }

    @NonNull
    private String getKey(String item) {
        return item.toLowerCase();
    }
}
