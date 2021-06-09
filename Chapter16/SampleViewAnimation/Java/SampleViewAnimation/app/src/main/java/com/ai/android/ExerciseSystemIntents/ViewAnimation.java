package com.ai.android.ExerciseSystemIntents;

import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ViewAnimation extends Animation {

    private static final String TAG = "ViewAnimation";

    private float centerX;
    private float centerY;

    public ViewAnimation(float cx, float cy) {
        centerX = cx;
        centerY = cy;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        Log.d(TAG, "width: " + width);
        Log.d(TAG, "height: " + height);
        Log.d(TAG, "pwidth: " + parentWidth);
        Log.d(TAG, "pheight: " + parentHeight);
        setDuration(2500);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        applyTransformationNew(interpolatedTime, t);
    }

    protected void applyTransformationNew(float interpolatedTime, Transformation t) {
        Log.d(TAG, "applyTransformationNew=>transform: " + interpolatedTime);
        final Matrix matrix = t.getMatrix();
        matrix.setScale(interpolatedTime, interpolatedTime);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX, centerY);
    }
}
