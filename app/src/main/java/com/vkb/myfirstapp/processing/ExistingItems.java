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

    public void addToExistingItems(String existingItem, Double deltaQuantity) {
        Double existingQuantity = getExistingQuantity(existingItem);

        Double newQuantity = existingQuantity + deltaQuantity;

        replaceExistingItem(existingItem, newQuantity);
    }

    public void replaceExistingItem(String existingItem, Double newQuantity) {
        updateQuantity(existingItem, newQuantity);
    }

    private void updateQuantity(String existingItem, Double newQuantity) {
        String key = getKey(existingItem);
        existingItems.put(key, newQuantity);
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
