package edu.duke.compsci290.squirt;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Elizabeth on 5/14/2018.
 */

public class MainThread extends Thread {

    private SurfaceHolder mSurfaceHolder;
    private GameView mGameView;
    private boolean mIsRunning;
    public static Canvas mCanvas;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView){
        super();
        mSurfaceHolder = surfaceHolder;
        mGameView = gameView;
    }

    @Override
    public void run() {
        while (mIsRunning) {
            mCanvas = null;
            try {
                mCanvas = this.mSurfaceHolder.lockCanvas();
                synchronized(mSurfaceHolder) {
                    this.mGameView.update();
                    this.mGameView.draw(mCanvas);
                }
            } catch (Exception e) {} finally {
                if (mCanvas != null) {
                    try {
                        mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning) {
        mIsRunning = isRunning;
    }
}