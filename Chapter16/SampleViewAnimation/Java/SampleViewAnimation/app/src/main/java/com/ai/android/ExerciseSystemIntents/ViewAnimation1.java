package com.ai.android.ExerciseSystemIntents;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ViewAnimation1 extends Animation {

    private static final String TAG = ViewAnimation1.class.getSimpleName();

    private float centerX;
    private float centerY;
    private Camera cam;

    public ViewAnimation1(float cx, float cy) {
        cam = new Camera();
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
        Log.d(TAG, "transform: " + interpolatedTime);
        final Matrix matrix = t.getMatrix();
        cam.save();
        cam.translate(0.0f, 0.0f, (1300 - 1300.0f * interpolatedTime));
        cam.rotateY(360 * interpolatedTime);
        cam.getMatrix(matrix);

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        cam.restore();
    }
}
