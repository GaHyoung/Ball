package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x;
    private int y;
    private int radius;
    private Color color;
    Rectangle region;

    public Ball(int x, int y, int radius){
        this(x, y, radius, Color.BLUE);
    }
    public Ball(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getRadius(){
        return radius;
    }
    public Color getColor(){
        return color;
    }

    // 물체간 충돌하지 않도록 World의 add메소드에서 사용할 getRegion()추가
    public Rectangle getRegion(){ //region을 부를 때마다 새로운 영역값이 생성되어 ball이 새로 그려질때 region도 함께 움직여야한다.
        return new Rectangle(getX()-getRadius(), getY()-getRadius(), 2 * getRadius(), 2 * getRadius());
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public void paint(Graphics g){
        Color oldColor = getColor();
        g.setColor(color);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
        g.setColor(oldColor);
    }

}

