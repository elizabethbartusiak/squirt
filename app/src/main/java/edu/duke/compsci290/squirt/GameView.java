package edu.duke.compsci290.squirt;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by Elizabeth on 5/14/2018.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mThread;
    private CharacterSprite mShampoo;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        mThread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mThread.setRunning(true);
        mThread.start();
        mShampoo = new CharacterSprite(BitmapFactory.decodeResource(getResources(),
                R.drawable.shampoocond));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                mThread.setRunning(false);
                mThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update(){

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
//            canvas.drawColor(Color.WHITE);
//            Paint paint = new Paint();
//            paint.setColor(Color.rgb(250, 0, 0));
//            canvas.drawRect(100, 100, 200, 200, paint);
//
            mShampoo.draw(canvas);
        }
    }



}
