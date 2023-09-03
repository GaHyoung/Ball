package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class BoundedBallTest{
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

        // World를 정의해야 ball을 사용 가능
        MovableWorld world= new MovableWorld(100);
        frame.add(world); // world를 add했으니까 자동으로 그려줌
        frame.setVisible(true);

        BoundedBall ball1 = new BoundedBall(100, 100, 20);
        ball1.setDx(10);
        ball1.setDy(20);
        //BoundedBall의 setBound 설정. ball이 움직일 수 있는 범위를 world 크기로 설정해야힌다.
        ball1.setBounds(new Rectangle(0, 0, world.getWidth(), world.getHeight()));
        world.add(ball1);

        BoundedBall ball2 = new BoundedBall(400, 100, 50, Color.PINK);
        ball2.setDx(-20);
        ball2.setDy(20);
        ball2.setBounds(new Rectangle(0, 0, world.getWidth(), world.getHeight()));
        world.add(ball2);


        /* Ball staticBall = new Ball(250, 100, 20, Color.GRAY);
        world.add(staticBall); */
        
    
        world.setDT(30);
        world.run();
    }
}
