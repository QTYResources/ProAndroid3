package com.androidbook.codeinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mNameContainer;
    private LinearLayout mAddressContainer;
    private LinearLayout mParentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNameContainer();
        createAddressContainer();
        createParentContainer();
        setContentView(mParentContainer);
    }

    private void createNameContainer() {
        mNameContainer = new LinearLayout(this);
        mNameContainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mNameContainer.setOrientation(LinearLayout.HORIZONTAL);

        TextView nameLbl = new TextView(this);
        nameLbl.setText("Name:");

        TextView nameValue = new TextView(this);
        nameValue.setText("John Doe");

        mNameContainer.addView(nameLbl);
        mNameContainer.addView(nameValue);
    }

    private void createAddressContainer() {
        mAddressContainer = new LinearLayout(this);
        mAddressContainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mAddressContainer.setOrientation(LinearLayout.HORIZONTAL);

        TextView addrLbl = new TextView(this);
        addrLbl.setText("Address:");

        TextView addrValue = new TextView(this);
        addrValue.setText("911 Hollywood Blvd");

        mAddressContainer.addView(addrLbl);
        mAddressContainer.addView(addrValue);
    }

    private void createParentContainer() {
        mParentContainer = new LinearLayout(this);
        mParentContainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        mParentContainer.setOrientation(LinearLayout.VERTICAL);

        mParentContainer.addView(mNameContainer);
        mParentContainer.addView(mAddressContainer);
    }
}