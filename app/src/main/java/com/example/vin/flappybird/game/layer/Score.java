package com.example.vin.flappybird.game.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.vin.flappybird.game.GameSurface;
import com.example.vin.flappybird.utils.Constants;

/**
 * Score
 *
 * @author: Vin
 * @time: 2016/1/24 10:05
 */
public class Score extends Baselayer {


    private float scoreX,scoreY;
    private int scoreMax;
    private int score;
    private long startTime;
    private long endTime;
    private boolean isStart;


    public Score(GameSurface surface) {
        super(surface);
        score=0;
        scoreX=20;
        scoreY=100;
        isStart=true;

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        paint.setTextSize(100);

        switch (surface.gameState){
            case Constants.GAME_START:
                canvas.drawText("最高分数："+scoreMax+"s",scoreX,scoreY,paint);
                break;
            case Constants.GAMING:
                canvas.drawText("分数："+score+"s",scoreX,scoreY,paint);
                break;


        }

    }

    @Override
    public void logic() {

        if(isStart){
            startTime=System.currentTimeMillis();
            isStart=false;
        }
        long endTime=System.currentTimeMillis();
        score=(int)(endTime-startTime)/1000;
        if(score>scoreMax){
            surface.setScoreMax(score);
        }
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }

    public int getScoreMax() {
        return scoreMax;
    }
}
