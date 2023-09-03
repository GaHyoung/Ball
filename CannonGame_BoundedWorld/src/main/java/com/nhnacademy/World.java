package com.nhnacademy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class World extends JPanel {

    List<Ball> ballList; //List<자료형 or 클래스> -> Generics타입

    public World(){ //생성자 -> 상위클래스 호출, ballList 초기화
        super();
        ballList = new LinkedList<>();
    }

    //물체간 충돌하지 않도록 ball이 추가될 때 해당영역에 다른 볼이 없는지 확인하고 추가.
    public void add(Ball ball){
        //물체간 충돌 방지방법 1 : ball간 거리를 계산하여 코드를 작성
        /* if(!ballList.contains(ball)){
            for(Ball otherBall : ballList){
                double ballDistance = Math.sqrt(Math.pow(otherBall.getX()-ball.getX(),2) + Math.pow(otherBall.getY()-ball.getY(), 2)
                -(otherBall.getRadius() - ball.getRadius()));
                
                if(ballDistance < 0){
                    throw new RuntimeException("Error");
                }
            }
        }
        ballList.add(ball); */

        //물체간 충돌 방지방법 2 : Ball클래스에 getRiegion을 추가, 메서드에 영역을 만들어 교차영역 확인
        if(!ballList.contains(ball)){
            for(Ball otherBall : ballList){

                Rectangle region = ball.getRegion();
                Rectangle otherRegion = otherBall.getRegion();

                if(region.intersects(otherRegion)){
                    throw new RuntimeException("Error");
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

    public Ball getBall(int index){ //getBall을 하면 Ball을 가져오므로 int가 아니라 Ball !!
        return ballList.get(index);
    }

    public void removeBall(int index){
        if(index < ballList.size()){
            ballList.remove(index);
        }
    }

    @Override
    public void paint(Graphics g){ //불러오고, ball을 리스트에서 하나씩 꺼내서 칠함 -> 다시 칠함.
        super.paint(g);
        for(Ball ball : ballList){
            if(ball != null)
            ball.paint(g);
        }
        repaint();
    }
    
}
