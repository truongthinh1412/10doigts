package puf.example.a10doigts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton GoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        GoBack = (ImageButton) findViewById(R.id.btn_back_help);
        GoBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        GoBack.setBackgroundResource(R.drawable.btn_back_pressed);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        GoBack.setBackgroundResource(R.drawable.btn_back);
                        finish();
                        break;
                    }
                }
                return true;
            }
        });
    }
}
