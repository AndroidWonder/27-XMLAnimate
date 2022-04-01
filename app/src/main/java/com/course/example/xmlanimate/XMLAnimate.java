package com.course.example.xmlanimate;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class XMLAnimate extends Activity {

    private ImageView img;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        img = (ImageView) findViewById(R.id.simple_anim);
        //set ImageView background to AnimationDrawable XML resource.
        img.setBackgroundResource(R.drawable.simple_animation);

        //instantiate inner classes
        AnimationStart start = new AnimationStart();
        AnimationStop stop = new AnimationStop();

        Timer t = new Timer();
        t.schedule(start, 1000);
        t.schedule(stop, 5000);

    }

    class AnimationStart extends TimerTask {

        @Override
        public void run() {
            // Get the background, which has been compiled to an AnimationDrawable object.
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.start();
        }
    }

    class AnimationStop extends TimerTask {

        @Override
        public void run() {
            // Get the background, which has been compiled to an AnimationDrawable object.
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.stop();
        }
    }

}
