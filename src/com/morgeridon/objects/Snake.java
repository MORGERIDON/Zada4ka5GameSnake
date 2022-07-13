package com.morgeridon.objects;

import static com.morgeridon.SnakeGameMain.*;

public class Snake {
    public int length = 2;
    public int direction = 3;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake(int x1, int y1, int x2, int y2) {
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move() {
        for (int l = length; l > 0; l--) {
            sX[l] = sX[l - 1];
            sY[l] = sY[l - 1];
        }

        switch (direction) {
            //up
            case 0:
                sY[0]--;
                break;
            //down
            case 2:
                sY[0]++;
                break;
            //right
            case 1:
                sX[0]++;
                break;
            //left
            case 3:
                sX[0]--;
                break;
        }
        if (sY[0] > HEIGHT - 1) sY[0] = 0;
        if (sY[0] < 0) sY[0] = HEIGHT - 1;

        if (sX[0] > WIDTH - 1) sX[0] = 0;
        if (sX[0] < 0) sX[0] = WIDTH - 1;

    }
}
