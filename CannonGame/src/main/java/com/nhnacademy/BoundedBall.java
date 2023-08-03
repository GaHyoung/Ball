package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall{
    //경계를 만들어 부딪치면 튕겨나가도록
    //Rectangle(직사각형) : 객체의 좌표 공간에서의 좌상의 점 (x, y) 및 그 폭과 높이에 의해 둘러싸이는 좌표 공간내의 영역

    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);
        bounds = new Rectangle(x-radius, y-radius, 2*radius, 2*radius);
    }
    
    public BoundedBall(int x, int y, int radius){ // bounds 경계 설정을 위해 값을 가져옴
        this(x, y, radius, Color.BLUE);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
    }

    public boolean isOutOfBounds(){ 
        //공이 이동한 후의 region이 bounds의 범위를 벗어나는 지 확인
        //교차된 영역의 가로, 세로 값이 공 영역인 region 값과 다르면 경계를 벗어난것.
        //Rectangle에 getWidth와 getHeight 있음.
        Rectangle region = new Rectangle(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());

        Rectangle intersection = bounds.intersection(region);

        return intersection.getWidth() != region.getWidth() || intersection.getHeight() != region.getHeight();
    }


    public void bounce(){ 
        //Rectangle에 getMinX, getMaxX 있음.
        if(getX() - getRadius() < bounds.getMinX() || bounds.getMaxX() < getX() + getRadius()){
            setDX(-getDX());
        }

        if(getY() - getRadius() < bounds.getMinY() || bounds.getMaxY() < getY() + getRadius()){
            setDY(-getDY());
        }
    }

    //move를 실행시키기 위해 movableBall의 move를 재정의해서 조건과 동작만 추가.
    @Override
    public void move(){
        super.move();
        if(isOutOfBounds()){
            bounce();
        }
    }








}
