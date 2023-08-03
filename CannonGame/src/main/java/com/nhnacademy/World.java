package com.nhnacademy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class World extends JPanel {

    List<Ball> ballList; //List<자료형 or 클래스> -> Generics타입

    public World(){ //생성자 -> 상위클래스 호출, ballList 초기화
        super();
        ballList = new ArrayList<>();
    }

    public void add(Ball ball){
        if(!ballList.contains(ball)){ //ball
            ballList.add(ball);
        }
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
            ball.paint(g);
        }
        repaint();
    }
    
}
