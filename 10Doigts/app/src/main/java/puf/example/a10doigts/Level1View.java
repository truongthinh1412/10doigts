package puf.example.a10doigts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Admin on 22/6/2016.
 */
public class Level1View extends View {

    int maxTouch = 5;

    public Level1View(Context context, AttributeSet attrs) {
        super(context, attrs);
        Finger.setup();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Finger.onTouchEvent(event);
        this.postInvalidate();
        return true;
    }

    public int randomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n) + 1;
    }

    int value = randomNumber(maxTouch);

    public Bitmap randomNumberImg(int n){
        Bitmap numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number0);
        switch (n)
        {
            case 1:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number1);
                break;
            case 2:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number2);
                break;
            case 3:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number3);
                break;
            case 4:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number4);
                break;
            case 5:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number5);
                break;
            case 6:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number6);
                break;
            case 7:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number7);
                break;
            case 8:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number8);
                break;
            case 9:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number9);
                break;
            case 10:
                numberImg = BitmapFactory.decodeResource(getResources(),R.drawable.number10);
                break;
        }
        return numberImg;
    }

    Paint paint = new Paint();

    Rect backGround = new Rect();
    Bitmap backGroundImg = BitmapFactory.decodeResource(getResources(),R.drawable.screen_game);

    Rect number = new Rect();
    Bitmap numberImg = randomNumberImg(value);

    @Override
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        paint.setColor(Color.BLACK);

        backGround.set(0,0,width,height);
        canvas.drawBitmap(backGroundImg,null,backGround,paint);

        number.set(width / 2 - width / 10, height / 2 - width / 5,width / 2 + width / 10, height / 2 + width / 5 );
        canvas.drawBitmap(numberImg,null,number,paint);

        int count = 0;
        for (Finger f : Finger.fingers)
            if (f.active) {
                paint.setColor(Color.GREEN);
                canvas.drawCircle(f.x, f.y, 100, paint);
                count++;
            }

        if(count == value){
            value = randomNumber(maxTouch);
            numberImg = randomNumberImg(value);
        }
        this.postInvalidate();
    }
}
