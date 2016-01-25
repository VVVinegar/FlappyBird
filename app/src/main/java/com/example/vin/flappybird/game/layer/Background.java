package com.example.vin.flappybird.game.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.vin.flappybird.R;
import com.example.vin.flappybird.game.GameSurface;
import com.example.vin.flappybird.utils.Assist;

/**
 * Background
 *
 * @author: LiPeijing
 * @time: 2016/1/24 10:02
 */

public class Background extends Baselayer {

    private int color;

    public Background(GameSurface surface) {
        super(surface);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {

        paint.setColor(Assist.getColor(res, R.color.backGround));

        canvas.drawRect(0, 0, screenW, screenH, paint);



    }

    @Override
    public void logic() {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }
}

