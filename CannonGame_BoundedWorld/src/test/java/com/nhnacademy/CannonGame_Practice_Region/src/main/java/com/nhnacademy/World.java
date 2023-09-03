package com.nhnacademy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

// 물체간 충돌하지 않게 수정 //
/* world에 ball이 추가될 때 해당 영역을 다른 ball이 없는지 확인하고 추가하도록 수정. 
만약, 다른 ball이 차지하고 있어 새로운 ball의 추가가 어렵다면 exception을 발생*/

public class World extends JPanel{
    List<Ball> ballList;
    
    public World(){ // 생성자 -> 상위클래스 호출, ballList 초기화 !!!!!!
        super();
        ballList = new ArrayList<>();
    }

    public void add(Ball ball){ //ball추가 삭제는 ballList의 ball 존재 여부를 확인
        
        // 1. ball간 거리를 계산하여 코드를 작성하는 방법.
        // ball 중심간 거리에서 두 반지름 값을 뺀 값이 음수이면 겹친것.
        /* if(!ballList.contains(ball)){
            for(Ball2 otherBall : ballList){
                double balldistance = Math.sqrt(Math.pow(otherBall.getX()-ball.getX(), 2) + Math.pow(otherBall.getY()-ball.getY(),2))
                - (otherBall.getRadius() + ball.getRadius());
                if(balldistance < 0){
                    throw new RuntimeException("Error");
                }
                
            }
        }
        ballList.add(ball); */
        
        // 2. ball에 getRegion을 추가하여 ball.getRegion()을 하여 간단히 코드를 작성하는 방법.
        if(!ballList.contains(ball)){
            for(Ball otherBall : ballList){
               if(otherBall instanceof BoundedBall){
                   Rectangle region = ball.getRegion();
                   Rectangle otherRegion = otherBall.getRegion();

                   if(otherRegion.intersects(region)){
                       throw new RuntimeException("Error");
                   }
               }

            }
        }
        ballList.add(ball);
    }

    public void remove(Ball ball){
        if(ballList.contains(ball)){
            ballList.remove(ball);
        }
    }

    public int getBallCount(){
        return ballList.size();
    }

    public Ball getBall(int index){
        return ballList.get(index);
    }


    public void removeBall(int index){
        if(index < ballList.size()){
            ballList.remove(index);
        }

    }

    // Jpanel에 그리기가 정의되어있음 거기에 볼을 그리는 작업을 추가해줘야함 -> 기능을 바꿔줘야함
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(Ball ball : ballList){
            if(ball != null) // ballList에 null 값이 저장되어 있지 않다면
            ball.paint(g); // Ball 객체의 paint 메서드를 호출
        }
        /* repaint(); */
    }
}

    //"Practice Region"코드이니 학습해

