package puf.example.a10doigts;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ArcadeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcade_menu);


        ImageButton level1Btn = (ImageButton) findViewById(R.id.level1_button_arcademenu);
        ImageButton level2Btn = (ImageButton) findViewById(R.id.level2_button_arcademenu);
        ImageButton level3Btn = (ImageButton) findViewById(R.id.level3_button_arcademenu);
        ImageButton backBtn = (ImageButton) findViewById(R.id.back_arcademenu);

        level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLvl1 =  new Intent(ArcadeMenuActivity.this,Level1Activity.class);
                startActivity(intentLvl1);
            }
        });

        level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLvl2 =  new Intent(ArcadeMenuActivity.this,Level1Activity.class);
                startActivity(intentLvl2);
            }
        });

        level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLvl3 =  new Intent(ArcadeMenuActivity.this,Level1Activity.class);
                startActivity(intentLvl3);
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch previous activity
            }
        });
    }
}
