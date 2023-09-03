package com.nhnacademy;

public class Motion {
    //2차원 공간에서의 물체 이동과 관련된 클래스
    //필드 : x축 변화량, y축 변화량
    int dx;
    int dy;

    //외부에서 접근 불가능. createPosition, createDisplacement 메서드를 통해 객체를 생성
    private Motion(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }
    
    //Motion 객체를 복사하여 새로운 Motion 객체를 생성하는 생성자
    public Motion(Motion motion){
        dx = motion.getDx();
        dy = motion.getDy();
    }

    //dx, dy 값을 받아 Motion 객체를 생성
    public static Motion createPosition(int dx, int dy){
        return new Motion(dx, dy);
    }

    //크기와 각도값을 받아 dx, dy 값을 계산하여 Motion객체를 생성 -> 이동량을 계산
    public static Motion createDisplacement(int magnitude, int angle){
        return new Motion((int)(magnitude * Math.cos(Math.toRadians(angle))),
         (int)(magnitude * Math.sin(Math.toRadians(angle))));
    }

    //getter
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    //setter
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }

    //빗변
    //현재 Motion 객체의 크기(빗변)를 계산하여 반환
    public int getMagnitude(){
        return (int)(Math.sqrt(Math.pow(getDx(), 2)) + Math.pow(getDy(), 2));
    }
    //각도
    //현재 Motion 객체의 각도(angle)를 계산하여 반환
    public int getTheta() {
        return (int) (Math.toDegrees(Math.atan(getDy()) / (double) getDx()));
    }
}
