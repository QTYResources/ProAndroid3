package com.ai.android.ExerciseSystemIntents;

import android.util.Log;
import android.view.animation.Animation;

public class ViewAnimationListener implements Animation.AnimationListener {

    @Override
    public void onAnimationStart(Animation animation) {
        Log.d("Animation Example", "onAnimationStart");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.d("Animation Example", "onAnimationEnd");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.d("Animation Example", "onAnimationRepeat");
    }
}
