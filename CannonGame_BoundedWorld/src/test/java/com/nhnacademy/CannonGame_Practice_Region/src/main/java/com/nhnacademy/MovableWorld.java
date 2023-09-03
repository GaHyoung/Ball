package com.nhnacademy;

public class MovableWorld extends World {
    int moveCount; // 움직인 횟수
    int maxMoveCount; // 움직인 최대 횟수
    long dt = 1000; // 움직임 간격

    public MovableWorld(int maxMoveCount) {
        super(); // World클래스의 생성자 호출
        moveCount = 0;
        this.maxMoveCount = maxMoveCount;
        // 매개변수로 받은 maxMoveCount 값을 MovableWorld 클래스의 maxMoveCount 변수에 할당
    }

    public void reset() {
        moveCount = 0;
    }


    public int getMoveCount() {
        return moveCount;// 현재 이동 횟수 반환
    }
    public int getMaxMoveCount() {
        return maxMoveCount;// 최대 이동 횟수 반환. run() 메서드에서 이동 횟수를 제어하는 데 사용됨
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    
    public long getDT() { //아래 sleep에 dt값을 주기 위해 getDT, setDT값을 준다.
        return dt;
    }
    public void setDT(int dt) {
        this.dt = dt;
    }


    protected void move() { // ballList에 있는 모든 Ball 객체를 움직임
        /* for (Ball ball : ballList) { // 모든 공을 차례로 가져옴
            if (ball instanceof MovableBall) {
                ((MovableBall) ball).move();
            }
            // Ball에 있는 ball이 MovableBall의 인스턴스라면 MovableBall로 캐스팅하여 움직이도록 함.
        }
        repaint(); */
        for (int i = 0; i < getBallCount(); i++) {
            Ball ball = getBall(i);
            if (ball instanceof MovableBall) { 
                ((MovableBall) ball).move();
            }
        }
        repaint();
    }

    public void run() { // World 실행 메서드
        for (int i = 0; maxMoveCount ==0 || i < maxMoveCount; i++) {
            move(); // getMaxMoveCount(최대이동횟수)만큼 move()메서드 반복
            try {
                Thread.sleep(getDT());// 쉬는시간
            } catch (InterruptedException ignore) { // 인터럽트(Interrupt)가 발생할 때 던지는 예외를 무시
                Thread.currentThread().interrupt();
            }
        }
    }
}
