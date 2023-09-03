package com.nhnacademy;

public class MovableWorld extends World {
    private int movementCount;
    private int maxMovementCount;
    private long dt;

    public MovableWorld(int maxMovementCount) {
        super();
        movementCount = 0;
        this.maxMovementCount = maxMovementCount;
        dt = 100;
    }

    public void reset() { // 상태를 초기화
        movementCount = 0;
    }

    public void move() { // 볼 중에서! 이동할 수 있는 MovableBall만! 이동
        for (Ball ball : ballList) {
            if (ball instanceof MovableBall) {
                ((MovableBall) ball).move();
            }
        }
        repaint(); // 이동하고 나면 ball을 다시 그린다. for문 뒤에!
    }

    public void run() { //지정한 횟수만큼 ball을 이동. 이동한 후에는 sleep
        for (int i = 0; i < getMaxMovementCount(); i++) {
            move();
            try {
                Thread.sleep(dt);
            } catch (InterruptedException ignore) { // 인터럽트(Interrupt)가 발생할 때 던지는 예외를 무시
                Thread.currentThread().interrupt();
            }
        }
    }

    // getDT, setDT를 통해 new World 등 새로운 값을 설정해 줄 때 사용. dx=1000은 초기값
    public long getDT(){
        return dt;
    }
    public void setDT(long dt){
        this.dt = dt;
    }


    public int getMovementCount(){
        return movementCount;
    }

    public int getMaxMovementCount(){
        return maxMovementCount;
    }

    public void setMaxMovementCount(int maxMovementCount){
        this.maxMovementCount = maxMovementCount;
    }

}
