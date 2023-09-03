package com.nhnacademy;

import java.awt.Color;

//Motion을 받아옴
public class MovableBall extends Ball {
    Motion motion;

    public MovableBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);
        /* this.dx = 0;
        this.dy = 0; */
        this.motion = Motion.createPosition(0, 0);
    }
    
    public MovableBall(int x, int y, int radius) {
        this(x, y, radius, Color.BLUE);
    }

    public int getDx(){
        return motion.getDx();
    }
    public int getDy(){
        return motion.getDy();
    }

    public void setDx(int dx){
        motion.setDx(dx);
    }
    public void setDy(int dy){
        motion.setDy(dy);
    }


    public void move(){//현재 x 값에 단위시간 값을 더하여 ball의 값을 설정. 단위 시간만큼 이동시킴.
        /* setX(getX() + getDX());
        setY(getY() + getDY()); */
        moveTo(getX() + getDx(), getY() + getDy());
    }
    public void moveTo(int x, int y){ //공을 지정된 x, y좌표로 이동 
        setX(x);
        setY(y);
    }
    
}
