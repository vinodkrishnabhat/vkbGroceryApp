package com.vkb.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.vkb.myfirstapp.processing.MasterList;

public class MainActivity extends AppCompatActivity {
    public static final String ITEM = "com.vkb.myfirstapp.ITEM";
    public static final String QTY = "com.vkb.myfirstapp.QTY";
    public static final String ACTION = "com.vkb.myfirstapp.ACTION";
    public static final String ADD = "com.vkb.myfirstapp.ADD";
    public static final String REPLACE = "com.vkb.myfirstapp.REPLACE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAutoFillAndFocus();
    }

    protected void setAutoFillAndFocus() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, MasterList.getInstance().getItemNames());
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);
        textView.requestFocus();
    }

    /** Called when the user taps the Add button */
    public void sendAdd(View view) {
        doProcess(view, ADD);
    }

    /** Called when the user taps the Replace button */
    public void sendReplace(View view) {
        doProcess(view, REPLACE);
    }

    /** Called when the user taps the GenerateList button */
    public void generateList(View view) {
        Intent intent = new Intent(this, MonthlyListActivity.class);
        startActivity(intent);
    }

    private void doProcess(View view, String action) {
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        String item = textView.getText().toString();

        EditText qtyText = (EditText) findViewById(R.id.editText2);
        String qty = qtyText.getText().toString();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(ITEM, item);
        intent.putExtra(QTY, qty);
        intent.putExtra(ACTION, action);

        startActivity(intent);
    }
}
