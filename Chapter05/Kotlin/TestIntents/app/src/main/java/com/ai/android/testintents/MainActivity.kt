package com.ai.android.testintents

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.telephony.PhoneNumberUtils
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    // Initialize this in onCreateOptions
    private var myMenu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setupButton()
        setupEditText()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        myMenu = menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        try {
            handleMenus(item)
        } catch (e: Exception) {
            Log.d(TAG, e.message, e)
            throw RuntimeException("error", e)
        }
        return true
    }

    private fun handleMenus(item: MenuItem) {
        appendMenuItemText(item)
        when (item.itemId) {
            R.id.menu_clear -> emptyText()
            R.id.menu_basic_view -> IntentsUtils.invokeBasicActivity(this)
            R.id.menu_show_browser -> IntentsUtils.invokeWebBrowser(this)
            R.id.menu_dial -> IntentsUtils.dial(this)
            R.id.menu_call -> IntentsUtils.call(this)
            R.id.menu_map -> IntentsUtils.showMapAtLatLong(this)
            R.id.menu_testPick -> IntentsUtils.invokePick(this)
            R.id.menu_testGetContent -> IntentsUtils.invokeGetContent(this)
            R.id.menu_search -> IntentsUtils.invokeWebSearch(this)
        }
    }

    @SuppressLint("WrongViewCast")
    private fun getTextView(): TextView {
        return findViewById<TextView>(R.id.textViewId)
    }

    public fun appendText(text: String) {
        val tv = getTextView()
        tv.text = "${tv.text}$text"
    }

    public fun appendMenuItemText(menuItem: MenuItem) {
        val title = menuItem.title.toString()
        val tv = getTextView()
        tv.text = "${tv.text}\n$title:${menuItem.itemId}"
    }

    private fun emptyText() {
        getTextView().text = ""
    }

    private fun dial() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun setupButton() {
        val b = findViewById<Button>(R.id.button1)
        b.setOnClickListener {
            parentButtonClicked(it)
        }
    }

    private fun parentButtonClicked(v: View) {
        appendText("\nbutton clicked")
        dialUsingEditText()
    }

    private fun dialWithNumber(tel: String) {
        val telUriString = "tel:$tel"
        Log.d(TAG, telUriString)
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(telUriString)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun dialUsingEditText() {
        val etext = findViewById<EditText>(R.id.editTextId)
        val text = etext.text.toString()
        if (PhoneNumberUtils.isGlobalPhoneNumber(text)) {
            dialWithNumber(text)
        }
    }

    @SuppressLint("WrongViewCast")
    private fun getEditText(): EditText {
        return findViewById<EditText>(R.id.editTextId)
    }

    private fun setupEditText() {
        getEditText().addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        IntentsUtils.parseResult(this, requestCode, resultCode, data!!)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}