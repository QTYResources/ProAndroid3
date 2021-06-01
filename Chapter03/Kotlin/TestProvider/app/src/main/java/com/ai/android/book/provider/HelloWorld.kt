package com.ai.android.book.provider

import android.os.Bundle
import android.util.Log
import android.view.MenuItem

class HelloWorld : MonitoredDebugActivity(R.menu.main_menu, "HelloWorld"), IReportBack {

    private val providerTester: ProviderTester = ProviderTester(this, this)

    override fun onMenuItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, item.title.toString())
        when (item.itemId) {
            R.id.menu_add -> providerTester.addBook()
            R.id.menu_display_table -> providerTester.showBooks()
            R.id.menu_delete -> providerTester.removeBook()
        }
        return true
    }

}