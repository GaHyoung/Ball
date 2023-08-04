package com.nhnacademy;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MovableWorldTest {
    
    public static void main(String[] args) {
        final int BALL_COUNT = 10;
        final int WIDTH = 400;
        final int HEIGHT = 300;
        final int MAX_MOVE_COUNT = 10;
        

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            // WindowListener : 윈도우 이벤트를 처리하는 인터페이스
            // WindowAdapter : WindowListener의 추상 클래스. 필요한 메소드만 오버라이드하여 사용 가능.(windowClosing)
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //World를 정의해야 ball을 사용 가능
        MovableWorld world = new MovableWorld(MAX_MOVE_COUNT);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(world);
        frame.setVisible(true);

        //랜덤한 ball 생성. 랜덤함 x, y 좌표값, 랜덤한 dx, dy값 설정
        for(int i = 0; i< BALL_COUNT; i++){
            int radius = (int)(10 + Math.random() * (50-10));
            int x = (int)(10 + Math.random() * (WIDTH -2 * radius)); //radius를 최소값으로 줘야 경계를 벗어나지 않음.
            int y = (int)(10 + Math.random() * (HEIGHT - 2 * radius));

            int dx = (int)(-20 + Math.random() * 40-(-20));
            int dy = (int)(-20 + Math.random() * 40-(-20));


            //앞의 값을 이용하여 MovableBall 객체를 생성해 ball 변수에 저장.
            MovableBall ball = new MovableBall(x, y, radius);
            ball.setDX(dx);
            ball.setDY(dy);
            world.add(ball); //현재 world의 add가 겹치는 영역이 있으면 런타임에러가 나므로 실행이 안됨.

        }
        
        // 지정한 횟수만큼 ball을 move()
        world.run();;   
    }
    
}

