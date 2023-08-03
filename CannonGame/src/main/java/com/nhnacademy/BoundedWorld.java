package com.nhnacademy;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    //클래스의 모든 인스턴스에서 공유하기 위해 static 값으로 설정.
    //생성자에 MovableWorld의 파라미터인 int maxMovementCount값을 주지않고 상수 값을 준다.
    static final int DEFAULT_MAX_MOVE_COUNT = 100;

    public BoundedWorld(){
        super(DEFAULT_MAX_MOVE_COUNT);
    }

    //Ball의 ball이 경계를 벗어나는 지 확인.
    public boolean outOfBounds(Ball ball){
        Rectangle region = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());
    
        Rectangle intersection = getBounds().intersection(region);

        return intersection.getWidth() != region.getWidth() || intersection.getHeight() != region.getHeight();
    }

    public void bounceBall(MovableBall ball){
        //BoundedWorld의 경우 파라미터 값에 ball을 가져와 ball.을 해서 값을 가져와야함.
        //BoundedBall의 경우 필드값인 bounds.getRadius()도 괜찮지만 BoundedWorld의 경우 getBounds로 값을 가져와야함.
        if(ball.getX() - ball.getRadius() < getBounds().getMinX() || getBounds().getMaxX() < ball.getX() + ball.getRadius()){
            ball.setDX(-ball.getDX());
        }
        if(ball.getY() - ball.getRadius() < getBounds().getMinY() || getBounds().getMaxY() < ball.getY() + ball.getRadius()){
            ball.setDY(-ball.getDY());
        }
    }

    @Override
    public void move(){
        super.move();
        for(int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i); //i번째에 해당하는 ball을 가져옴
            if(ball instanceof MovableBall && outOfBounds(ball)){
                bounceBall((MovableBall)ball);
            }
        }
    }
}
