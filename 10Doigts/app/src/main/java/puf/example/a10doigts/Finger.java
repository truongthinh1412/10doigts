package puf.example.a10doigts;

import android.view.MotionEvent;

/**
 * Created by Admin on 20/6/2016.
 */
public class Finger {
    float x;
    float y;
    boolean active;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    static int finger_max_nb = 20;

    static public Finger [] fingers;

    static void setup() {
        fingers = new Finger[finger_max_nb]; // here to be ready for event
        for (int f=0; f<fingers.length; f++)
            fingers[f] = new Finger();
    }

    static public void onTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                /* Only one touch event is stored in the MotionEvent. Extract
                 * the pointer identifier of this touch from the first index
                 * within the MotionEvent object. */
                int id = event.getPointerId(0);
                fingers[id].x = event.getX(0);
                fingers[id].y = event.getY(0);
                fingers[id].active = true;

                break;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                /* A non-primary pointer has gone down, after an event for the
                 * primary pointer (ACTION_DOWN) has already been received.
                 * The MotionEvent object contains multiple pointers. Need to
                 * extract the index at which the data for this particular event
                 * is stored. */
                int index = event.getActionIndex();
                int id = event.getPointerId(index);
                fingers[id].x = event.getX(index);
                fingers[id].y = event.getY(index);
                fingers[id].active = true;
                break;
            }
            case MotionEvent.ACTION_UP: {
                /* Final pointer has gone up and has ended the last pressed
                 * gesture.
                 * Extract the pointer identifier for the only event stored in
                 * the MotionEvent object and remove it from the list of active
                 * touches. */
                int id = event.getPointerId(0);
                fingers[id].active = false;
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                /* A non-primary pointer has gone up and other pointers are
                 * still active.
                 * The MotionEvent object contains multiple pointers. Need to
                 * extract the index at which the data for this particular event
                 * is stored. */
                int index = event.getActionIndex();
                int id = event.getPointerId(index);
                fingers[id].active = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                /* A change event happened during a pressed gesture. (Between
                 * ACTION_DOWN and ACTION_UP or ACTION_POINTER_DOWN and
                 * ACTION_POINTER_UP) */
                for (int index = 0; index < event.getPointerCount(); index++) {
                    int id = event.getPointerId(index);
                    fingers[id].x = event.getX(index);
                    fingers[id].y = event.getY(index);
                }
                break;
            }

        }
    }

    public Finger() {
        x = 0;
        y = 0;
        active = false;
    }
}
