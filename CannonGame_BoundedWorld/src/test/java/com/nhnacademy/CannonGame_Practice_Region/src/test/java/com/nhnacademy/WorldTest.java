package com.nhnacademy;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;

public class WorldTest {
    public static void main(String[] args) {
        final int BALL_COUNT = 10; // 변수를 상수(변경할 수 없는 변수)로 선언
        final int MAX_RADIUS = 50;
        final int MIN_RADIUS = 10;
        final int WIDTH = 500;
        final int HEIGHT = 300;
        final Color[] colors = {Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.ORANGE};

        // JFrame 클래스를 이용하여 새로운 창을 생성. Frame 객체를 생성했다는 것만으로 창이 나타나지는 않음.
        JFrame frame = new JFrame();
        
        // World 클래스의 인스턴스인 world 생성
        World world = new World(); 
        

        frame.add(world); // 생성한 world 인스턴스를 frame 창에 추가
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true); // frame 창을 화면에 나타낼 것인지를 설정

       
        for (int i = 0; i < BALL_COUNT; i++) {
            int radius = (int) (MIN_RADIUS + Math.random() * (MAX_RADIUS - MIN_RADIUS));
            int x = (int) (radius + Math.random() * (world.getWidth() - 2 * radius));
            int y = (int) (radius + Math.random() * (world.getHeight() - 2 * radius));
            // world의 너비, 높이 범위 내에서 랜덤한 위치로 생성

            Color color = colors[(int) (Math.random() * colors.length)];
            // colors 배열에서 랜덤한 인덱스를사용하여 색상 선택
            Ball ball = new Ball(x, y, radius, color); // 랜덤 color를 사용하여 새로운 Ball객체를 생성.
            world.add(ball);// 새로 생성된 ball 객체를 world에 추가 -> 반복
        }

        frame.addWindowListener(new WindowAdapter() { // 윈도우 닫기버튼 누르면 프로그램 종료 구현
            // WindowListener : 윈도우 이벤트를 처리하는 인터페이스
            // WindowAdapter : WindowListener의 추상 클래스. 필요한 메소드만 오버라이드하여 사용 가능.(windowClosing)
            @Override
            public void windowClosing(WindowEvent e) { // 창 닫을 때 발생하는 windowClosing메소드 오버라이드
                System.exit(0);// 프로그램 종료
            }
        });

    }
}
