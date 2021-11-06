package com.ai.android.book.resources

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

class TestActivity: MonitoredDebugActivity, IReportBack {

    private lateinit var resourceTester: ResourceTester

    constructor(): super(R.menu.main_menu, TAG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resourceTester = ResourceTester(this, this)
    }

    override fun onMenuItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_test_strings -> {
                resourceTester.testEnStrings()
                true
            }
            R.id.menu_test_arrays -> {
                resourceTester.testStringArray()
                true
            }
            R.id.menu_test_layout -> {
                val i = Intent(this, HelloWorldActivity::class.java)
                startActivity(i)
                true
            }
            R.id.menu_test_color_drawables -> {
                testColorDrawables()
                true
            }
            R.id.menu_test_colors -> {
                resourceTester.testColor()
                true
            }
            R.id.menu_test_image -> {
                testImage()
                true
            }
            R.id.menu_test_shape -> {
                testShape()
                true
            }
            R.id.menu_test_string_variations -> {
                resourceTester.testStringVariations()
                true
            }
            R.id.menu_test_xml -> {
                resourceTester.testXML()
                true
            }
            R.id.menu_test_rawfile -> {
                resourceTester.testRawFile()
                true
            }
            R.id.menu_test_assets -> {
                resourceTester.testAssets()
                true
            }
            else -> true
        }
    }

    private fun testImage() {
        // Call getDrawable to get the image
        var d = resources.getDrawable(R.drawable.sample_image)
        // You can use the drawable the to set the background
        getTextView().setBackgroundDrawable(d)
        // or you can set the background directly from the Resource Id
        getTextView().setBackgroundResource(R.drawable.sample_image)
    }

    private fun testColorDrawables() {
        // Get a drawable
        val redDrawable = resources.getDrawable(R.drawable.red_rectangle) as ColorDrawable

        // Set it as a background to a text view
        getTextView().setBackgroundDrawable(redDrawable)
    }

    private fun testShape() {
        // Get a drawable
        val roundedRectangle = resources.getDrawable(R.drawable.my_rounded_rectangle) as GradientDrawable

        // Set it as a background to a text view
        getTextView().setBackgroundDrawable(roundedRectangle)
    }

    companion object {
        const val TAG = "TestActivity"
    }
}