package com.nhnacademy;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class BoundedWorldTest {
    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 300;

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        frame.setSize(WIDTH, HEIGHT);
        
        BoundedWorld world = new BoundedWorld();
        frame.add(world);
        frame.setVisible(true);
        
        //BoundedBall로 ball을 생성 시 BoundedWorld의 경계에 갇혀 이동 범위가 더 작다.
        MovableBall ball1 = new MovableBall(100, 100, 30);
        ball1.setDx(20);
        ball1.setDy(10);
        world.add(ball1);
        
        MovableBall ball2 = new MovableBall(400, 100, 20, Color.pink);
        ball2.setDx(-10);
        ball2.setDy(10);
        world.add(ball2);
        
        Ball staticBall = new Ball(250, 100, 30, Color.yellow);
        world.add(staticBall);
        
        world.setDT(100);
        world.run();
    }
}
