package com.vkb.myfirstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.vkb.myfirstapp.post.CallAPI;
import com.vkb.myfirstapp.processing.MonthlyList;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MonthlyListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_list);

        doProcess();
    }

    private void doProcess() {
        Map<String, String> monthlyListMap = MonthlyList.getMonthlyListAsMap();
        Map<String, String> infrequentListMap = MonthlyList.getInfrequentListAsMap();

        displayOnScreen(monthlyListMap, infrequentListMap);

        sendToPrint(monthlyListMap, infrequentListMap);
    }

    private void sendToPrint(Map<String, String> monthlyListMap, Map<String, String> infrequentListMap) {
        Map<String, String> postMap = getPostParams(monthlyListMap, infrequentListMap);

        CallAPI.call(postMap, this);
    }

    @NonNull
    private Map<String, String> getPostParams(Map<String, String> monthlyListMap, Map<String, String> infrequentListMap) {
        Map<String, String> postMap = new LinkedHashMap<>();
        postMap.putAll(monthlyListMap);

        for(String infrequentLocations: infrequentListMap.keySet()) {
            postMap.put("INFREQUENT " + infrequentLocations, infrequentListMap.get(infrequentLocations));
        }

        String allLocationsStr = getAllLocationsString(monthlyListMap, infrequentListMap);
        postMap.put("LOCATIONS", allLocationsStr);

        return postMap;
    }

    @NonNull
    private String getAllLocationsString(Map<String, String> monthlyListMap, Map<String, String> infrequentListMap) {
        Set<String> allLocations = new HashSet<>();
        allLocations.addAll(monthlyListMap.keySet());
        allLocations.addAll(infrequentListMap.keySet());

        String allLocationsStr = "";
        for(String str:allLocations) {
            allLocationsStr += str + ",";
        }
        return allLocationsStr;
    }

    private void displayOnScreen(Map<String, String> monthlyListMap, Map<String, String> infrequentListMap) {
        String message = getStringFromMap(monthlyListMap, "");
        message += getStringFromMap(infrequentListMap, "INFREQUENT ");

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    @NonNull
    private String getStringFromMap(Map<String, String> infrequentListMap, String header) {
        String retStr = "";

        for (String location : infrequentListMap.keySet()) {

            retStr += "**********   " + header + location + "   **********\n";
            retStr += infrequentListMap.get(location);
            retStr += "\n";
        }
        return retStr;
    }

}
