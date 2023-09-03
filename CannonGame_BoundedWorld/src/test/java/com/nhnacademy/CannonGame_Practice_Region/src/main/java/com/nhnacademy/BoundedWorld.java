package com.nhnacademy;

import java.awt.Rectangle;

// 물체간 충돌하지 않게 수정 //

public class BoundedWorld extends MovableWorld {
    
    static final int MAX_MOVE_COUNT = 1000;
    public BoundedWorld(){
        super(MAX_MOVE_COUNT);
    }

    public boolean outOfBounds(Ball ball){
        Rectangle ballRegion = new Rectangle(ball.getX()-ball.getRadius(), ball.getY()-ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());

        Rectangle intersection = getBounds().intersection(ballRegion);

        return intersection.getWidth() != ballRegion.getWidth() || intersection.getHeight() != ballRegion.getHeight();
    }

    public void bounceBall(MovableBall ball){
        if(ball.getX() - ball.getRadius() < getBounds().getMinX() || getBounds().getMaxX() < ball.getX() + ball.getRadius()){
            ball.setDx(-ball.getDx());
        }
        if(ball.getY() - ball.getRadius() < getBounds().getMinY() || getBounds().getMaxY() < ball.getY() + ball.getRadius()){
            ball.setDy(-ball.getDy());
        }
    }

    @Override
    public void move(){
        super.move();
        for(int i=0; i<getBallCount(); i++){ // world의 getBallCount
            Ball ball = getBall(i); // i번째에 해당하는 ball을 가져옴. world의 getBall(int index)

            if(ball instanceof MovableBall){

                for(int j=0; j<getBallCount(); j++){
                    Ball otherBall = getBall(j); //ball과 otherBall이 같은 경우 발생

                    if((ball != otherBall) && (ball.getRegion().intersects(otherBall.getRegion()))){
                        Rectangle intersection = ball.getRegion().intersection(otherBall.getRegion());
                        
                        //두 공이 겹치는 영역이 있다면
                        if((intersection.getWidth() != 0) && (intersection.getHeight() != 0)){
                            //겹치는영역의 길이가 ball영역의 길이보다 짧다면 방향을 바꾼다.
                            if(intersection.getWidth() < ball.getRegion().getWidth()){
                                ((MovableBall)ball).setDx(-((MovableBall)ball).getDx());
                            }
                            if(intersection.getHeight() < ball.getRegion().getHeight()){
                                ((MovableBall)ball).setDy(-((MovableBall)ball).getDy());
                            }  
                        }
                    }
                }
            }
        }
        //frame 영역을 넘어가면 bound
        for(int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i);
            if(ball instanceof MovableBall){
                bounceBall((MovableBall)ball);
            }
        }
    }

}
