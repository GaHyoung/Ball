package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int x;
    private int y;
    private int radius;
    private Color color;

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

