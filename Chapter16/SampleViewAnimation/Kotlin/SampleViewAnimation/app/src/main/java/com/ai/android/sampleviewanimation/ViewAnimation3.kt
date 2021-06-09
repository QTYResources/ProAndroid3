package com.ai.android.sampleviewanimation

import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

class ViewAnimation3: Animation() {

    private var centerX: Float = 0.0f
    private var centerY: Float = 0.0f

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        centerX = width / 2.0f
        centerY = height / 2.0f
        duration = 2500
        fillAfter = true
        interpolator = LinearInterpolator()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        t?.apply {
            matrix?.apply {
                setScale(interpolatedTime, interpolatedTime)
                preTranslate(-centerX, -centerY)
                postTranslate(centerX, centerY)
            }
        }
    }
}