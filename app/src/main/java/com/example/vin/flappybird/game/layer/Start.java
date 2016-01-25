package com.example.vin.flappybird.game.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.vin.flappybird.R;
import com.example.vin.flappybird.game.GameSurface;
import com.example.vin.flappybird.utils.Assist;
import com.example.vin.flappybird.utils.Constants;

/**
 * Start
 *
 * @author: LiPeijing
 * @time: 2016/1/24 10:02
 */

public class Start extends Baselayer{

    private float x;
    private float y;
    private float w;
    private float h;

    private float triangleW, traingleH;

    public Start(GameSurface surface) {
        super(surface);

        w = 200;
        h = 100;
        x = screenW / 2 - w / 2;
        y = screenH / 3 - h / 2;

        triangleW = 50;
        traingleH = 20;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.WHITE);

        canvas.drawRect(x, y, x + w, y + h, paint);

        paint.setColor(Color.GREEN);
        Path path = new Path();
        path.moveTo(x + w / 2 - traingleH / 2, y + h / 2 - triangleW / 2);
        path.lineTo(x + w / 2 - traingleH / 2, y + h / 2 + triangleW / 2);
        path.lineTo(x + w / 2 + traingleH / 2, y + h / 2);
        canvas.drawPath(path, paint);
    }

    @Override
    public void logic() {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //判断是否点击了开始按钮
        if(touchX > x && touchX < x + w && touchY > y && touchY < y + h){
            surface.setGameState(Constants.GAMING);
        }
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }
}
