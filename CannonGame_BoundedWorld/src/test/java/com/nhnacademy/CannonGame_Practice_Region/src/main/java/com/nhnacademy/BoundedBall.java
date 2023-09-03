package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall{
    
    public BoundedBall(int x, int y, int radius){
        super(x, y, radius);
        bounds = new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    public BoundedBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);
        bounds = new Rectangle(x-radius, y-radius, 2*radius, 2*radius);
    }
    

    Rectangle bounds;

    public Rectangle getBounds(){
        return bounds;
    }
    public void setBounds(Rectangle newBounds){
        bounds = newBounds;
    }

    public boolean isOutOfBounds(){
        Rectangle ballRegion = new Rectangle(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());

        Rectangle intersection = bounds.intersection(ballRegion);

        return intersection.getWidth() != ballRegion.getWidth() || intersection.getHeight() != ballRegion.getHeight();
    }

    public void bounce(){
        if(getX() - getRadius() < bounds.getMinX() || bounds.getMaxX() < getX() + getRadius()){
            setDx(-getDx());
        }
        
        if(getY() - getRadius() < bounds.getMinY() || bounds.getMaxY() < getY() + getRadius()){
            setDy(-getDy());
        }
    }

    @Override
    public void move(){
        super.move();
        if(isOutOfBounds())
            bounce();
    }
}
