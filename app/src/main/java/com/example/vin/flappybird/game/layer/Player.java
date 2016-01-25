package com.example.vin.flappybird.game.layer;

import android.graphics.Canvas;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.vin.flappybird.R;
import com.example.vin.flappybird.game.GameSurface;
import com.example.vin.flappybird.utils.Assist;
import com.example.vin.flappybird.utils.Constants;


/**
 * Player
 *
 * @author: LiPeijing
 * @time: 2016/1/24 10:01
 */

public class Player extends Baselayer{

    private float playerX;
    private float playerY;
    private float radius;

    private float speedY;
    private float acc;

    public Player(GameSurface surface) {
        super(surface);

        playerX = screenW / 2;
        playerY = screenH / 2;

        radius = 50;

        speedY = 15;
        acc = 4;
    }

    /**
     * 画图
     * @param canvas
     * @param paint
     */
    public void draw(Canvas canvas, Paint paint){
        paint.setColor(Assist.getColor(res, R.color.Bird));

        switch (surface.gameState) {
            case Constants.GAME_START:
                canvas.drawCircle(screenW / 2, screenH / 2, radius, paint);
                break;
            case Constants.GAMING:
                canvas.drawCircle(playerX, playerY, radius, paint);
                break;
            case Constants.GAME_END:
                canvas.drawCircle(screenW / 2, screenH / 2, radius, paint);
                break;
            default:

                break;
        }
    }

    /**
     *逻辑
     */
    public void logic(){
        //圆移动
        playerY += speedY;
        speedY += acc;



        //与上边界碰撞
        if(playerY-radius<0){
            surface.setGameState(Constants.GAME_END);
        }
        //与下边界碰撞
        if(playerY+radius>screenH){
            surface.setGameState(Constants.GAME_END);
        }
    }

    /**
     * 触摸事件
     * @param event
     */
    public void onTouchEvent(MotionEvent event){
        speedY=-35;
    }

    /**
     * 按键点击事件
     * @param keyCode
     * @param event
     */
    public void onKeyDown(int keyCode, KeyEvent event){

    }

    public float getPlayerX() {
        return playerX;
    }

    public float getPlayerY() {
        return playerY;
    }

    public float getRadius() {
        return radius;
    }
}