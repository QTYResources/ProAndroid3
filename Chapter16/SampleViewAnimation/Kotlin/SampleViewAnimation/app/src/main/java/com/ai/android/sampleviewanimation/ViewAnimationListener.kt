package com.ai.android.sampleviewanimation

import android.util.Log
import android.view.animation.Animation

class ViewAnimationListener: Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation?) {
        Log.d(TAG, "onAnimationStart")
    }

    override fun onAnimationEnd(animation: Animation?) {
        Log.d(TAG, "onAnimationEnd")
    }

    override fun onAnimationRepeat(animation: Animation?) {
        Log.d(TAG, "onAnimationRepeat")
    }
    
    companion object {
        const val TAG = "ViewAnimationListener"
    }
}