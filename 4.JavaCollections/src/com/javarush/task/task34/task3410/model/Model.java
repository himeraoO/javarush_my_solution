package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader;/* = new LevelLoader(Paths.get("src/com/javarush/task/task34/task3410/res/levels.txt"));
*/
    public Model() {
        try {
            levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
        } catch (URISyntaxException e) {
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level){
        currentLevel = level;
        gameObjects = levelLoader.getLevel(currentLevel);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
        return;
        }
            if (direction.equals(Direction.UP)) {
                player.move(0, -FIELD_CELL_SIZE);
            }
            if (direction.equals(Direction.DOWN)) {
                player.move(0, FIELD_CELL_SIZE);
            }
            if (direction.equals(Direction.LEFT)) {
                player.move(-FIELD_CELL_SIZE, 0);
            }
            if (direction.equals(Direction.RIGHT)) {
                player.move(FIELD_CELL_SIZE, 0);
            }
            checkCompletion();

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        //boolean b = false;
        for (Wall w: gameObjects.getWalls()) {
            if(gameObject.isCollision(w, direction)){
               // b = true;
                return true;
            }
        }
       // return b;
        return false;
        /*
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
         */
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        Player player = gameObjects.getPlayer();
        Set<Box> boxes = gameObjects.getBoxes();
        for (Box b: boxes) {
            if (player.isCollision(b, direction)){
                for (Box bb: boxes) {
                    if(!b.equals(bb)){
                        if(b.isCollision(bb, direction)){
                            return true;
                        }
                        if(checkWallCollision(b, direction)){
                            return true;
                        }
                    }
                }
                if (direction.equals(Direction.UP)){
                    b.move(0, -FIELD_CELL_SIZE);
                }
                if (direction.equals(Direction.DOWN)){
                    b.move(0, FIELD_CELL_SIZE);
                }
                if (direction.equals(Direction.LEFT)){
                    b.move(-FIELD_CELL_SIZE, 0);
                }
                if (direction.equals(Direction.RIGHT)){
                    b.move(FIELD_CELL_SIZE, 0);
                }
            }
        }
        return false;
        /*
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box item : gameObjects.getBoxes()) {
                    if (!box.equals(item)) {
                        if (box.isCollision(item, direction)) {
                            return true;
                        }
                    }
                    if (checkWallCollision(box, direction)) {
                        return true;
                    }
                }
                int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
                int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
                box.move(dx, dy);
            }
        }
        return false;
         */
    }

    public void checkCompletion(){
        Set<Home> homes = gameObjects.getHomes();
        Set<Box> boxes = gameObjects.getBoxes();
        Map<Home, Boolean> map = new HashMap<>();
        for (Home h: homes){
            for (Box box: boxes) {
                if((h.getX() == box.getX()) && (h.getY() == box.getY())){
                    map.put(h, true);
                    break;
                }
            }
        }
        if(homes.size() == map.size()){
            eventListener.levelCompleted(currentLevel);
        }
    }
}
