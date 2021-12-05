package com.ai.android.testmenus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class SampleMenusActivity : AppCompatActivity() {

    // Initialize this in onCreateOptions
    private var myMenu:Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val tv = TextView(this)
//        tv.text = "Hello, Android. Say hello")
//        setContentView(tv)

        setContentView(R.layout.activity_main)

        // Before calling this method make sure
        // set the content view
        registerForContextMenu(getTextView())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // call the parent to attach any system level menus
        super.onCreateOptionsMenu(menu)

        myMenu = menu

        // add a few normal menus
        addRegularMenuItems(menu)

        // add a few secondary menus
        add5SecondaryMenuItems(menu)
        addSubMenu(menu)

        // it meust return true to show the menu
        // it it is false menu won't show
        return true
    }

    private fun addRegularMenuItems(menu: Menu?) {
        menu?.apply {
            // Secondary items are shown just like everything else
            var base = Menu.FIRST   // value is 1

            val item1 = add(base, base, base, "append")
            add(base, base + 1, base + 1, "item 2")
            add(base, base + 2, base + 2, "clear")

            add(base, base + 3, base + 3, "hide secondary")
            add(base, base + 4, base + 4, "show secondary")

            add(base, base + 5, base + 5, "enable secondary")
            add(base, base + 6, base + 6, "disable secondary")

            add(base, base + 7, base + 7, "check secondary")

            val item8 = add(base, base + 8, base + 8, "uncheck secondary")

            // This will show the icon
            // It might obscure the text
            item1.setIcon(R.drawable.balloons)

            // But this does not
            item8.setIcon(R.drawable.balloons)
        }
    }

    private fun add5SecondaryMenuItems(menu: Menu?) {
        menu?.apply {
            // Secondary items are shown just like everything else
            var base = Menu.CATEGORY_SECONDARY

            add(base, base + 1, base + 1, "sec. item 1")
            add(base, base + 2, base + 2, "sec. item 2")
            add(base, base + 3, base + 3, "sec. item 3")
            add(base, base + 4, base + 4, "sec. item 4")
            add(base, base + 5, base + 5, "sec. item 5")
        }
    }

    private fun addSubMenu(menu: Menu?) {
        menu?.apply {
            // Secondary items are shown just like everything else
            var base = Menu.FIRST + 100

            val sm = addSubMenu(base, base + 1, Menu.NONE, "submenu")
            val item1 = sm.add(base, base + 2, base + 2, "sub item1")

            sm.add(base, base + 3, base + 3, "sub item2")
            sm.add(base, base + 4, base + 4, "sub item3")

            // work the icons
            // submenu item icons are not supported
            item1.setIcon(R.drawable.icon48x48_2)

            // the foolwing is ok
            sm.setIcon(R.drawable.icon48x48_1)
            // This will result in an exception
            // sm.addSubMenu("try this")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> appendText("\nhello")
            2 -> appendText("\nitem2")
            3 -> emptyText()
            4 -> {
                // hide secondary
                appendMenuItemText(item)
                myMenu?.setGroupVisible(Menu.CATEGORY_SECONDARY, false)
            }
            5 -> {
                // Show secondary
                appendMenuItemText(item)
                myMenu?.setGroupVisible(Menu.CATEGORY_SECONDARY, true)
            }
            6 -> {
                // enable secondary
                appendMenuItemText(item)
                myMenu?.setGroupEnabled(Menu.CATEGORY_SECONDARY, true)
            }
            7 -> {
                // disable secondary
                appendMenuItemText(item)
                myMenu?.setGroupEnabled(Menu.CATEGORY_SECONDARY, false)
            }
            8 -> {
                // check secondary
                appendMenuItemText(item)
                myMenu?.setGroupCheckable(Menu.CATEGORY_SECONDARY, true, false)
            }
            9 -> {
                // uncheck secondary
                appendMenuItemText(item)
                myMenu?.setGroupCheckable(Menu.CATEGORY_SECONDARY, false, false)
            }
            else -> appendMenuItemText(item)
        }
        // should return true if the menu item
        // is handled
        return true

        // If it is not our menu item
        // let the base class handle it
        // return super.onOptionsItemSelected(item);
    }

    // Context menu support
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.apply {
            setHeaderTitle("Sample menu")
            add(200, 200, 200, "item1")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        // menu item has been handled
        return true
    }

    // This method is here to demonstrate loading xml menu
    // You can call this method from the oncreateoptions menu
    // if you want to use the xml menu instead of programmatically
    // creating the menus.
    private fun loadXMLMenu(menu: Menu) {
        menuInflater.inflate(R.menu.my_menu, menu)
    }

    private fun getTextView(): TextView {
        val tv = findViewById<TextView>(R.id.textViewId)
        return tv
    }

    private fun appendText(text: String) {
        val tv = getTextView()
        tv.text = "${tv.text}$text"
    }

    private fun appendMenuItemText(menuItem: MenuItem) {
        val tv = getTextView()
        tv.text = "${tv.text}\n${menuItem.title}:${menuItem.itemId}"
    }

    private fun emptyText() {
        val tv = getTextView()
        tv.text = ""
    }

}