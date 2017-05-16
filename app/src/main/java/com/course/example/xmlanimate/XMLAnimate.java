package com.course.example.xmlanimate;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class XMLAnimate extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        ImageView img = (ImageView) findViewById(R.id.simple_anim);
        img.setBackgroundResource(R.drawable.simple_animation);

        AnimationRoutine1 task1 = new AnimationRoutine1();
        AnimationRoutine2 task2 = new AnimationRoutine2();

        Timer t = new Timer();
        t.schedule(task1, 1000);
        Timer t2 = new Timer();
        t2.schedule(task2, 5000);

    }

    class AnimationRoutine1 extends TimerTask {

        @Override
        public void run() {
            ImageView img = (ImageView) findViewById(R.id.simple_anim);
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.start();
        }
    }

    class AnimationRoutine2 extends TimerTask {

        @Override
        public void run() {
            ImageView img = (ImageView) findViewById(R.id.simple_anim);
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.stop();
        }
    }

}
