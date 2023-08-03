package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends Ball{
    private int dx;
    private int dy;

    public MovableBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);
        this.dx = 0;
        this.dy = 0;
    }

    public int getDX(){
        return dx;
    }
    public int getDY(){
        return dy;
    }

    public void setDX(int dx){
        this.dx = dx;
    }

    public void setDY(int dy){
        this.dy = dy;
    }

    public void move(){ // 현재 x 값에 단위시간 값을 더하여 ball의 값을 설정. 단위 시간만큼 이동시킴.
        setX(getX() + getDX());
        setY(getY() + getDY());
    }

    public void moveTo(int x, int y){ // 공을 지정된 x, y좌표로 이동
        setX(x);
        setY(y);
    }
}
