package com.ai.android.ExerciseSystemIntents;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ViewAnimation3 extends Animation {

    private float centerX;
    private float centerY;

    public ViewAnimation3() {}

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        centerX = width / 2.0f;
        centerY = height / 2.0f;
        setDuration(2500);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        matrix.setScale(interpolatedTime, interpolatedTime);
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}
