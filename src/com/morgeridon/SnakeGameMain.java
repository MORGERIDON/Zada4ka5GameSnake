package com.morgeridon;

import com.morgeridon.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGameMain extends JPanel implements ActionListener {
    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 10;


    Snake snake = new Snake(5, 6, 5, 5);
    Timer timer = new Timer(1000 / speed, this);

    public SnakeGameMain() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.setColor(Color.white);
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }

        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.setColor(Color.white);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        for (int l = 0; l < snake.length; l++) {
            g.setColor(Color.BLUE);
            g.fillRect(snake.sX[l] * SCALE + 1, snake.sY[l] * SCALE + 1, SCALE - 2, SCALE - 2);
        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Rabo4a9 Zona");
        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 6);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new SnakeGameMain());
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
    public class KeyBoard extends KeyAdapter {
        public void keyPressed (KeyEvent event){
            int key= event.getKeyCode();

            if (key == KeyEvent.VK_UP && snake.direction != 2) snake.direction = 0;
            if (key == KeyEvent.VK_DOWN && snake.direction != 0) snake.direction = 2;
            if (key == KeyEvent.VK_LEFT && snake.direction != 1) snake.direction = 3;
            if (key == KeyEvent.VK_RIGHT && snake.direction != 3) snake.direction = 1;
        }
    }
}