package com.ai.android.alternativemenutest

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val criteriaIntent = Intent()
        criteriaIntent.component = ComponentName("com.ai.android.alternativemenu", "com.ai.android.alternativemenu.MenuActivity")
        criteriaIntent.addCategory(Intent.CATEGORY_ALTERNATIVE)
        criteriaIntent.type = "text/plain"
        menu?.addIntentOptions(
            Menu.CATEGORY_ALTERNATIVE,  // Group
            Menu.CATEGORY_ALTERNATIVE,  // Any unique IDs we might care to add.
            Menu.CATEGORY_ALTERNATIVE,  // order
            ComponentName(
                packageName,
                MainActivity::javaClass.name
            ),   // Name of the activity class displaying
            // the menu--here, it's this class
            null,   // variable "this" points to activity
            criteriaIntent,  // Previously created intent that
            Menu.FLAG_APPEND_TO_GROUP,          // No flags.
            null   // returned menu items
        )
        return true;
    }

}