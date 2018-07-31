package apps.com.certapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Activity_Splashscreen extends AppCompatActivity{
    ImageView imageViewLogo;

    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashcscreen);

        imageViewLogo = (ImageView)findViewById(R.id.iv_logo);
        sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);

//        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slidedown);
//        imageViewLogo.startAnimation(slide_down);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                    Intent i = new Intent(Activity_Splashscreen.this, Activity_Main.class);
                    startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
