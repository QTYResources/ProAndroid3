package com.ai.android.frameanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animations_layout);
        setupButton();
    }

    private void setupButton() {
        Button b = findViewById(R.id.startFAButtonId);
        b.setOnClickListener(this::parentButtonClicked);
    }

    private void parentButtonClicked(View v) {
        animate();
    }

    private void animate() {
        ImageView imgView = findViewById(R.id.imageView);
        imgView.setVisibility(ImageView.VISIBLE);
        imgView.setBackgroundResource(R.drawable.frame_animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) imgView.getBackground();
        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.stop();
            frameAnimation.start();
        }
    }

}