package puf.example.a10doigts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainView extends View {

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Finger.setup();
    }

    /* délégation de la gestion des touches à Finger */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();

     return true;
    }

    Rect storyModeButton = new Rect();
    Rect arcadeModeButton = new Rect();
    Rect backGround = new Rect();
    Rect settingsButton = new Rect();
    Rect helpButton = new Rect();

    Bitmap backGroundImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.screen_menu)).getBitmap();
    Bitmap storyModeImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.btn_story)).getBitmap();
    Bitmap arcadeModeImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.btn_arcade)).getBitmap();
    Bitmap settingsButtonImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.btn_settings)).getBitmap();
    Bitmap helpButtonImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.btn_help)).getBitmap();

    @Override
    protected void onDraw(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        //background
        backGround.set(0,0,width, height);
        canvas.drawBitmap(backGroundImg,null,backGround,paint);

        //storymode button
        storyModeButton.set(width / 10, 2 * height / 3 , width / 2 - width / 10, height - width / 10);
        canvas.drawBitmap(storyModeImg,null,storyModeButton,paint);

        //arcade button
        arcadeModeButton.set(width / 2 + width / 10, 2 * height / 3, width - width / 10,height - width / 10);
        canvas.drawBitmap(arcadeModeImg,null,arcadeModeButton,paint);

        //settings button
        settingsButton.set(width - width / 15,0,width,width / 15);
        canvas.drawBitmap(settingsButtonImg,null,settingsButton,paint);

        int distanceHelpSettings = width / 40;

        //help button
        helpButton.set(width - 2 * width / 15 - distanceHelpSettings,0,width - width / 15 - distanceHelpSettings,width / 15);
        canvas.drawBitmap(helpButtonImg,null,helpButton,paint);

        Finger f = Finger.fingers[0];
        if (f.active ) {
            paint.setColor(Color.GREEN);
            canvas.drawCircle(f.x, f.y, 100, paint);
        }
        this.postInvalidate();
    }
}
