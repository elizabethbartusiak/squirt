package edu.duke.compsci290.squirt;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Elizabeth on 5/14/2018.
 */

public class CharacterSprite {

    private Bitmap image;

    public CharacterSprite(Bitmap bmp) {
        image = bmp;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 100, 100, null);
    }
}
