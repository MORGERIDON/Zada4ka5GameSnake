package com.morgeridon.objects;

import com.morgeridon.SnakeGameMain;

public class Apple {
    public int posY;
    public int posX;

    public Apple(int posY, int posX) {
        this.posY = posY;
        this.posX = posX;
    }
    public void setRandomPosition(){
        posX=Math.abs((int) (Math.random()* SnakeGameMain.WIDTH-1));
        posY=Math.abs((int) (Math.random()* SnakeGameMain.HEIGHT-1));
    }

    public Apple(){
        setRandomPosition();
    }
}
