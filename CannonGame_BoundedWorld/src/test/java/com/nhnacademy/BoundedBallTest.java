package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class BoundedBallTest {
    public static void main(String[] args) {
        final int WIDTH = 400;
        final int HEIGHT = 300;

        JFrame frame = new JFrame();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        // World를 정의해야 ball을 사용 가능
        MovableWorld world= new MovableWorld(100);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(world);
        frame.setVisible(true);

        BoundedBall ball1 = new BoundedBall(200, 100, 40);
        ball1.setDX(10);
        ball1.setDY(10);
        //BoundedBall의 setBound 설정. ball이 움직일 수 있는 범위를 world 크기로 설정해야힌다.
        ball1.setBounds(new Rectangle(0, 0, world.getWidth(), world.getHeight()));
        world.add(ball1);

        BoundedBall ball2 = new BoundedBall(50, 30, 30, Color.PINK);
        ball2.setDX(20);
        ball2.setDY(30);
        ball2.setBounds(new Rectangle(0, 0, world.getWidth(), world.getHeight()));
        world.add(ball2);


        world.run();
    }
}
