package com.vkb.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.vkb.myfirstapp.processing.MonthlyList;

import java.util.List;
import java.util.Map;

public class MonthlyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_list);

        String message = getMonthlyListAsString();

        message += getInfrequentListAsString();

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    private String getInfrequentListAsString() {
        Map<String, List<String>> infrequentListMap = MonthlyList.getInfrequentListAsMap();

        String retStr = "";

        for (String location : infrequentListMap.keySet()) {
            retStr += "**********   INFREQUENT " + location + "   **********\n";

            List<String> list = infrequentListMap.get(location);
            for (String s : list) {
                retStr += s + "          ";
            }

            retStr += "\n";
        }

        return retStr;
    }

    private String getMonthlyListAsString() {
        Map<String, String> monthlyListMap = MonthlyList.getMonthlyListAsMap();

        String retStr = "";

        for (String location : monthlyListMap.keySet()) {
            retStr += "**********   " + location + "   **********\n";
            retStr += monthlyListMap.get(location);
        }

        return retStr;
    }
}
