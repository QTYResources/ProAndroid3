package com.ai.android.sampleviewanimation

import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

class ViewAnimation2: Animation() {

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        duration = 2500
        fillAfter = true
        interpolator = LinearInterpolator()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        t?.apply {
            matrix?.apply {
                setScale(interpolatedTime, interpolatedTime)
            }
        }
    }
}