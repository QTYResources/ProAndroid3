package com.androidbook.commoncontrols

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class RadioGroupActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radiogroup)

        val radGrp = findViewById<RadioGroup>(R.id.radGrp)

        val checkedRadioButtonID = radGrp.checkedRadioButtonId

        radGrp.setOnCheckedChangeListener {_, id ->
            when (id) {
                -1 -> Log.v(TAG, "Choices cleared!")
                R.id.chRBtn -> Log.v(TAG, "Chose Chicken")
                R.id.fishRBtn -> Log.v(TAG, "Chose Fish")
                R.id.stkRBtn -> Log.v(TAG, "Chose Steak")
                else -> Log.v(TAG, "Huh?")
            }
        }
    }

    companion object {
        const val TAG = "RadioGroupActivity"
    }
}