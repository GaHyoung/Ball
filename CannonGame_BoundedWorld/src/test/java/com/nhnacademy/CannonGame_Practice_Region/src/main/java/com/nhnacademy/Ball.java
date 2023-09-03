package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// x, y, radius 값을 지우고 region으로 x, y, radius 값을 구하기
// region을 통해 중심 좌표와 반지름을 사용하여 위치 및 크기를 관리
public class Ball {
    /* private int x;
    private int y;
    private int radius; */
    Color color;
    Rectangle region; //Rextangle : 직사각형

    public Ball(int x, int y, int radius){
        this(x, y, radius, Color.ORANGE);
             
    }

    public Ball(int x, int y, int radius, Color color){

        //공의 중심좌표와 반지름을 이용해 공의 영역을 구하기
        //Rectangle 객체는 (0,0) 좌표를 가지고 반지름*2만큼의 크기를 가짐 -> region변수에 넣음
        region = new Rectangle(x-radius, y-radius, 2*radius, 2*radius);
        this.color = color;
    }

    //getter
    //region의 (0,0)에서 중심으로 가려면 가로의 반을 더함
    public int getX(){
        return (int)(region.getX() + region.getWidth()/2);
    }
    public int getY(){
        return (int)(region.getY() + region.getHeight()/2);
    }
    public int getRadius(){
        return (int)(region.getWidth()/2);
    }
    //getter에 region 추가
    public Rectangle getRegion(){
        return region;
    }


    //setter
    //set이 될 때 region이 새 위치로 바뀜
    //변경하려는 공의 새 x, y좌표를 받아서 region 변수의 위치를 변경
    //공의 중심을 새 x 좌표로 옮기고 y 좌표는 그대로 둔다 -> 반지름을 가져와서 region의 경계를 새로 설정
    public void setX(int x){
        region.setLocation(x-getRadius(), getY()-getRadius());
    }
    public void setY(int y){
        region.setLocation(getX()-getRadius(), y-getRadius());
    }


    public Color getColor(){
        return color;
    }

    public void setColor(Color color){//접근제한자 타입 메소드명 (파라미터)
        this.color = color;
    }

    public void paint(Graphics g){
        Color oldColor = g.getColor();  //get에 파라미터 없음!!!!
        g.setColor(color);
        //(0, 0, width, heigh) -> 타원그리기
        g.fillOval(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
        //사각형그리기
        //사각형 왼쪽 모서리의 x좌표 = 원의중심x좌표 - 반지름
        //사각형 왼쪽 모서리의 y좌표 = 원의중심y좌표 - 반지름
        g.drawRect((int)(region.getMinX() + region.getWidth()/2) - (int)(region.getWidth()/2),
                    (int)(region.getMinY() + region.getHeight()/2) - (int)(region.getHeight()/2), 
                    2*(int)(region.getWidth()/2), 2*(int)(region.getWidth()/2));
        g.setColor(oldColor);
    }


    
}