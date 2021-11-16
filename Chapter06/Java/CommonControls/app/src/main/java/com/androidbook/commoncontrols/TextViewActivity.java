package com.androidbook.commoncontrols;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

public class TextViewActivity extends ComponentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);

        TextView tv = findViewById(R.id.tv);
        EditText et = findViewById(R.id.et);
        AutoCompleteTextView actv = findViewById(R.id.actv);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]{"English", "Hebrew", "Hindi", "Spanish", "German", "Greek"});

        actv.setAdapter(aa);

        MultiAutoCompleteTextView mactv = findViewById(R.id.mactv);
        ArrayAdapter<String> aa2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]{"English", "Hebrew", "Hindi", "Spanish", "German", "Greek"});

        mactv.setAdapter(aa2);

        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}