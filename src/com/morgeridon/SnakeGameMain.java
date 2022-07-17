package com.morgeridon;

import com.morgeridon.objects.Apple;
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
    Apple apple = new Apple();
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
            g.setColor(Color.WHITE);
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }

        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.setColor(Color.WHITE);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        g.setColor(Color.GREEN);
        g.fillOval(apple.posX * SCALE + 3, apple.posY * SCALE + 3, SCALE - 3, SCALE - 3);

        for (int l = 1; l < snake.length; l++) {
            g.setColor(Color.BLUE);
            g.fillRect(snake.sX[l] * SCALE + 1, snake.sY[l] * SCALE + 1, SCALE - 1, SCALE - 1);
            g.setColor(Color.CYAN);
            g.fillRect(snake.sX[0] * SCALE + 1, snake.sY[0] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Rabo4a9 Zona");
        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 38);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new SnakeGameMain());
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if ((snake.sX[0] == apple.posX) && (snake.sY[0] == apple.posY)) {
            apple.setRandomPosition();
            snake.length++;
        }
        for (int l = 1; l < snake.length; l++) {
            if ((snake.sX[l] == apple.posX) && (snake.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }
            if ((snake.sX[l] == snake.sX[0]) && (snake.sY[l] == snake.sX[0])) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Game over, Replay?");
//                int confirmDialog = JOptionPane.showConfirmDialog(null, "Game over, Replay?");
//                System.out.println(confirmDialog);
//                if (confirmDialog == 1) {
                    jFrame.setVisible(false);
                    snake.length = 2;
                    apple.setRandomPosition();
                    jFrame.setVisible(true);
                    timer.start();
//                }
            }
        }


//        apple.setRandomPosition();
        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_UP && snake.direction != 2) snake.direction = 0;
            if (key == KeyEvent.VK_DOWN && snake.direction != 0) snake.direction = 2;
            if (key == KeyEvent.VK_LEFT && snake.direction != 1) snake.direction = 3;
            if (key == KeyEvent.VK_RIGHT && snake.direction != 3) snake.direction = 1;
        }
    }
}