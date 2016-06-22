package puf.example.a10doigts;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    ImageView logoView;
    Animation animationFadeOut;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    ImageButton storyModeBtn, arcadeModeBtn,helpBtn,settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoView = (ImageView) findViewById(R.id.logo);
        animationFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        logoView.startAnimation(animationFadeOut);

        animationFadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setContentView(R.layout.activity_menu);
                storyModeBtn = (ImageButton) findViewById(R.id.story_btn_menu);
                arcadeModeBtn = (ImageButton) findViewById(R.id.arcade_btn_menu);
                helpBtn = (ImageButton) findViewById(R.id.help_button_mainmenu);
                settingsBtn = (ImageButton) findViewById(R.id.settings_button_mainmenu);

                arcadeModeBtn.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:{
                                arcadeModeBtn.setBackgroundResource(R.drawable.btn_arcade_pressed);
                                break;
                            }
                            case MotionEvent.ACTION_UP:{
                                arcadeModeBtn.setBackgroundResource(R.drawable.btn_arcade);
                                startActivity(new Intent(MainActivity.this,ArcadeMenuActivity.class));
                                break;
                            }
                        }
                        return true;
                    }
                });

                storyModeBtn.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:{
                                storyModeBtn.setBackgroundResource(R.drawable.btn_story_pressed);
                                break;
                            }
                            case MotionEvent.ACTION_UP:{
                                storyModeBtn.setBackgroundResource(R.drawable.btn_story);
                                startActivity(new Intent(MainActivity.this,StoryMenuTutorial.class));
                                break;
                            }
                        }
                        return true;
                    }
                });

                helpBtn.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:{
                                helpBtn.setBackgroundResource(R.drawable.btn_help_pressed);
                                break;
                            }
                            case MotionEvent.ACTION_UP:{
                                helpBtn.setBackgroundResource(R.drawable.btn_help);
                                startActivity(new Intent(MainActivity.this,HelpActivity.class));
                                break;
                            }
                        }
                        return true;
                    }
                });

                settingsBtn.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:{
                                settingsBtn.setBackgroundResource(R.drawable.btn_settings_pressed);
                                break;
                            }
                            case MotionEvent.ACTION_UP:{
                                settingsBtn.setBackgroundResource(R.drawable.btn_settings);
                                startActivity(new Intent(MainActivity.this,SettingActivity.class));
                                break;
                            }
                        }
                        return true;
                    }
                });
            }
        });
    }
}
