package com.ai.android.sampleviewanimation

import android.graphics.Camera
import android.util.Log
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

class ViewAnimation1(
    private val centerX: Float,
    private val centerY: Float
): Animation() {

    private val cam = Camera()

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        Log.d(TAG, "width: $width")
        Log.d(TAG, "height: $height")
        Log.d(TAG, "pwidth: $parentWidth")
        Log.d(TAG, "pheight: $parentHeight")
        duration = 2500
        fillAfter = true
        interpolator = LinearInterpolator()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        applyTransformationNew(interpolatedTime, t)
    }

    private fun applyTransformationNew(interpolatedTime: Float, t: Transformation?) {
        Log.d(TAG, "transform: $interpolatedTime")
        t?.apply {
            matrix?.apply {
                cam.save()
                cam.translate(0.0f, 0.0f, (1300 - 1300.0f * interpolatedTime))
                cam.rotateY(360 * interpolatedTime)
                cam.getMatrix(this)

                preTranslate(-centerX, -centerY)
                postTranslate(centerX, centerY)
                cam.restore()
            }
        }
    }

    companion object {
        const val TAG = "ViewAnimation1"
    }
}