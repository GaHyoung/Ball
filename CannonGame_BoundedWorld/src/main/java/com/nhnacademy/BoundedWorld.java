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
        Rectangle ballRegion = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());
    
        Rectangle intersection = getBounds().intersection(ballRegion);

        return intersection.getWidth() != ballRegion.getWidth() || intersection.getHeight() != ballRegion.getHeight();
    }

    //ball이 경계를 벗어나면 방향을 바꿔 bounce하도록 처리.
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
        //움직이는 공들간에 교차점이 있으면 방향 변화
        for(int i=0; i<getBallCount(); i++){ //world의 getBallCount
            Ball ball = getBall(i); //i번째에 해당하는 ball을 가져옴. world의 getBall(int index)
            
            if(ball instanceof MovableBall){ //ball이 MovableBall일 때

                for(int j=0; j<getBallCount(); j++){ //otherBall을 하나 더 생성하여 영역을 비교
                    Ball otherBall = getBall(j);

                    if(ball != otherBall && ball.getRegion().intersects(otherBall.getRegion())){//두 볼이 같지 않음에도 겹친다면
                        Rectangle intersection = ball.getRegion().intersection(otherBall.getRegion());

                        if(intersection.getWidth() < ball.getRegion().getWidth()){ //교차 너비영역이 ball의 너비보다 짧을 때는 좌우 반대
                            ((MovableBall)ball).setDX(-((MovableBall)ball).getDX());
                        }
                        if(intersection.getHeight() < ball.getRegion().getHeight()){ //교차 높이영역이 ball의 높이보다 짧을 때는 상하 반대
                            ((MovableBall)ball).setDY(-((MovableBall)ball).getDY());
                        }
                    }

                } 
            }
        }
        //공이 벽에서 넘어가면 bounce
        for(int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i);
            if(ball instanceof MovableBall)
                bounceBall((MovableBall)ball);
        }
    }
}
