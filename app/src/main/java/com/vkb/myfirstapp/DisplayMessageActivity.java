package com.vkb.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.vkb.myfirstapp.processing.ExistingItems;

public class DisplayMessageActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAutoFillAndFocus();

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String item = intent.getStringExtra(MainActivity.ITEM);
        Double qty = Double.valueOf(intent.getStringExtra(MainActivity.QTY));
        String action = intent.getStringExtra(MainActivity.ACTION);

        processAndShowResponse(item, qty, action);
    }

    private void processAndShowResponse(String item, Double qty, String action) {
        String performedActionMsg;
        Double newQuantity;

        switch(action) {
            case MainActivity.ADD:
                newQuantity = ExistingItems.getInstance().addToExistingItems(item, qty);
                performedActionMsg = "Added";
                break;
            case MainActivity.REPLACE:
                newQuantity = ExistingItems.getInstance().replaceExistingItem(item, qty);
                performedActionMsg = "Replaced";
                break;
            default:
                throw new IllegalArgumentException("Unknown action");
        }

        String message = "Successfully " + performedActionMsg + " " + qty + "kg of " + item + ". Qty is " + newQuantity;

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}
