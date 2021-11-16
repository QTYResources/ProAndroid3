package com.androidbook.codeinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mNameContainer: LinearLayout;
    private lateinit var mAddressContainer: LinearLayout;
    private lateinit var mParentContainer: LinearLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNameContainer()
        createAddressContainer()
        createParentContainer()
        setContentView(mParentContainer)
    }

    private fun createNameContainer() {
        mNameContainer = LinearLayout(this)
        mNameContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mNameContainer.orientation = LinearLayout.HORIZONTAL

        val nameLbl = TextView(this)
        nameLbl.text = "Name: "

        val nameValue = TextView(this)
        nameValue.text = "John Doe"

        mNameContainer.addView(nameLbl)
        mNameContainer.addView(nameValue)
    }

    private fun createAddressContainer() {
        mAddressContainer = LinearLayout(this)
        mAddressContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mAddressContainer.orientation = LinearLayout.HORIZONTAL

        val addrLbl = TextView(this)
        addrLbl.text = "Address:"

        val addrValue = TextView(this)
        addrValue.text = "911 Hoolywood Blvd"

        mAddressContainer.addView(addrLbl)
        mAddressContainer.addView(addrValue)
    }

    private fun createParentContainer() {
        mParentContainer = LinearLayout(this)
        mParentContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mParentContainer.orientation = LinearLayout.VERTICAL

        mParentContainer.addView(mNameContainer)
        mParentContainer.addView(mAddressContainer)
    }
}