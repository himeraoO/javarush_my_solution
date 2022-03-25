package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (GameObject gO: view.getGameObjects().getAll()) {
            gO.draw(g);
        }
//        Wall wall = new Wall(0, 0);
//        wall.draw(g);
//        Box box = new Box(100, 100);
//        box.draw(g);
//        Player player = new Player(5, 5);
//        player.draw(g);
//        Home home = new Home(50, 50);
//        home.draw(g);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
//            switch (e){
//                case KeyEvent.VK_LEFT:
//                    eventListener.move(Direction.LEFT);
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    eventListener.move(Direction.RIGHT);
//                    break;
//                case KeyEvent.VK_UP:
//                    eventListener.move(Direction.UP);
//                    break;
//                case KeyEvent.VK_DOWN:
//                    eventListener.move(Direction.DOWN);
//                    break;
//                case KeyEvent.VK_R:
//                    eventListener.restart();
//                    break;
//            }
            int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    eventListener.move(Direction.LEFT);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    eventListener.move(Direction.RIGHT);
                }
                if (key == KeyEvent.VK_UP) {
                    eventListener.move(Direction.UP);
                }
                if (key == KeyEvent.VK_DOWN) {
                    eventListener.move(Direction.DOWN);
                }
                if (key == KeyEvent.VK_R) {
                    eventListener.restart();
                }

            //super.keyPressed(e);
        }
    }
}
