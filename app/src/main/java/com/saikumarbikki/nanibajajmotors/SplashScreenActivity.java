package com.saikumarbikki.nanibajajmotors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by sbikki on 12/7/2017.
 */

public class SplashScreenActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    ImageView Welcomepage_bike_icon_IV;
    private Animation myAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This below 2 lines is to hide status bar on Activity.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen_activity_layout);

        RelativeLayout splashScreen_title_layout = (RelativeLayout) findViewById(R.id.splashscreen_title_layout);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
        splashScreen_title_layout.startAnimation(animation1);

        Welcomepage_bike_icon_IV = (ImageView) findViewById(R.id.Welcomepage_bike_icon);
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.mytransition_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashScreenActivity.this, HomePageActivity.class);
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                myAnimation.cancel();
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Welcomepage_bike_icon_IV.startAnimation(myAnimation);
    }


}
