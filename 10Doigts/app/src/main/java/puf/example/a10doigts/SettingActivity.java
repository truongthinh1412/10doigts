package puf.example.a10doigts;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {
    ImageButton[] List = new ImageButton[10];
    ImageButton btn_back, btn_check;
    int volume = 0;
    SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        List[0] = (ImageButton) findViewById(R.id.sound_0);
        List[1] = (ImageButton) findViewById(R.id.sound_1);
        List[2] = (ImageButton) findViewById(R.id.sound_2);
        List[3] = (ImageButton) findViewById(R.id.sound_3);
        List[4] = (ImageButton) findViewById(R.id.sound_4);
        List[5] = (ImageButton) findViewById(R.id.sound_5);
        List[6] = (ImageButton) findViewById(R.id.sound_6);
        List[7] = (ImageButton) findViewById(R.id.sound_7);
        List[8] = (ImageButton) findViewById(R.id.sound_8);
        List[9] = (ImageButton) findViewById(R.id.sound_9);

        btn_back = (ImageButton) findViewById(R.id.btn_back_setting);
        btn_check = (ImageButton) findViewById(R.id.sound_check);

        setting = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        if (setting.contains("sound")){
            if (setting.getString("sound","").equals("off")){
                btn_check.setBackgroundResource(R.drawable.btn_checkmark_unchecked);
                btn_check.setTag("off");
            }
            else {
                btn_check.setBackgroundResource(R.drawable.btn_checkmark_checked);
                btn_check.setTag("on");
            }
        }
        if (setting.contains("volume")){
            volume = Integer.valueOf(setting.getString("volume",""));
            Load_Volume_Level(volume);
        }

        if (btn_check.getTag()=="on") {
            if (setting.contains("volume")){
                volume = Integer.valueOf(setting.getString("volume",""));
                Load_Volume_Level(volume);
            }
            for (int i = 0; i < List.length; i++) {
                final int finalI = i;
                List[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        volume = finalI;
                        Load_Volume_Level(volume);
                        SharedPreferences.Editor edit = setting.edit();
                        edit.putString("sound","on");
                        edit.putString("volume",volume+"");
                        edit.commit();
                    }
                });
            }
        }
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_check.getTag()=="off")
                {
                    btn_check.setBackgroundResource(R.drawable.btn_checkmark_checked);
                    btn_check.setTag("on");
                    if (setting.contains("volume")){
                        volume = Integer.valueOf(setting.getString("volume",""));
                        Load_Volume_Level(volume);
                    }
                    for (int i = 0; i < List.length; i++) {
                        final int finalI = i;
                        List[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                volume = finalI;
                                Load_Volume_Level(volume);
                                SharedPreferences.Editor edit = setting.edit();
                                edit.putString("sound","on");
                                edit.putString("volume",volume+"");
                                edit.commit();
                            }
                        });
                    }
                }
                else {
                    btn_check.setBackgroundResource(R.drawable.btn_checkmark_unchecked);
                    btn_check.setTag("off");
                    for (int i = 0; i < List.length; i++){
                        List[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // do nothing
                            }
                        });
                    }
                }
            }
        });

        btn_back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        btn_back.setBackgroundResource(R.drawable.btn_back_pressed);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        btn_back.setBackgroundResource(R.drawable.btn_back);
                        SharedPreferences.Editor edit = setting.edit();
                        if (btn_check.getTag()=="off")
                            edit.putString("sound","off");
                        else edit.putString("sound","on");
                        edit.putString("volume",volume+"");
                        edit.commit();
                        finish();
                        break;
                    }
                }
                return true;
            }
        });
    }

    public void Load_Volume_Level(int vol){
        for (int i = 0; i < List.length; i++) {
            if (i<=vol) {
                List[i].setTag("enable");
                List[i].setBackgroundResource(R.drawable.btn_volume_slider_on);
            }
            else {
                List[i].setTag("disable");
                List[i].setBackgroundResource(R.drawable.btn_volume_slider_off);
            }
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor edit = setting.edit();
        if (btn_check.getTag()=="off")
            edit.putString("sound","off");
        else edit.putString("sound","on");
        edit.putString("volume",volume+"");
        edit.commit();
        super.onBackPressed();
        finish();
    }
}
