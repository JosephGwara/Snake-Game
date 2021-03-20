package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene{
    Rect background,foreground;
    Snake Snake;
    KL keyListener;
    public  Food food;


    public GameScene(KL keyListener){
        background = new Rect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        foreground = new Rect(24,48,Constants.TILE_WIDTH * 31,Constants.TILE_WIDTH * 22);
        Snake = new Snake(10,48,48+24,24,24,foreground);

        this.keyListener = keyListener;
        food = new Food(foreground,Snake,12,12,Color.GREEN);
        food.spawn();

    }

    @Override
    public void update(double dt) {
        if(keyListener.isTheKeyPressed(KeyEvent.VK_UP)){
            Snake.changeDirection(Direction.UP);}
        else if(keyListener.isTheKeyPressed(KeyEvent.VK_DOWN)){
            Snake.changeDirection(Direction.DOWN);
        }else if(keyListener.isTheKeyPressed(KeyEvent.VK_RIGHT)){
            Snake.changeDirection(Direction.RIGHT);
        }
        else if(keyListener.isTheKeyPressed(KeyEvent.VK_LEFT)){
            Snake.changeDirection(Direction.LEFT);
        }

        if(!food.isSpawned)food.spawn();


        food.update(dt);
        Snake.update(dt);

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
       g2.fill(new Rectangle2D.Double(background.x,background.y,background.width,background.height));
       g2.setColor(Color.WHITE);
       g2.fill(new Rectangle2D.Double(foreground.x,foreground.y,foreground.width,foreground.height));
       Snake.draw(g2);
       food.draw(g2);


    }
}
