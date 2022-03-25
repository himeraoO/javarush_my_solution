package com.javarush.task.task34.task3410.model;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
        Player player = null;
//        Home home = new Home(Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE/2);
        Set<Home> homes = new HashSet<>();
//        homes.add(home);
//        Box box = new Box(Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE/2);
        Set<Box> boxes = new HashSet<>();
//        boxes.add(box);
//        Wall wall1 = new Wall(Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE/2);
//        Wall wall2 = new Wall(Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE/2);
//        Wall wall3 = new Wall(Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE/2);
        Set<Wall> walls = new HashSet<>();
//        walls.add(wall1);
//        walls.add(wall2);
//        walls.add(wall3);
 
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(levels.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] strings = stringBuilder.toString().split("[*]{37}");
        String maze = "";
//        if(level > 60) {
//            level = level - 60 * (level/60);
//        }
int lvl;
        if (level > 60) {
            lvl = level % 60;
        } else {
            lvl = level;
        }
//        if(strings.length >= level) {
            String mazeLevel = strings[lvl];
//            System.out.println(mazeLevel);
            int n1 = mazeLevel.indexOf("Size X: ");
            int n2 = mazeLevel.indexOf("Size Y: ");
            int n3 = mazeLevel.indexOf("End: ");
            String sizeX = mazeLevel.substring(n1 + 8, n2);
            String sizeY = mazeLevel.substring(n2 + 8, n3);
//            System.out.println("sizeX: " + sizeX);
//            System.out.println("sizeY: " + sizeY);
            int sX = Integer.parseInt(sizeX);
            int sY = Integer.parseInt(sizeY);
            String mazeBody = mazeLevel.substring(mazeLevel.length() - (sX*sY));
//            System.out.println("mazeBody: " + mazeBody);

       //   GameObject [][] arr = new GameObject[str.length][str[0].length()];
            int x0 = Model.FIELD_CELL_SIZE/2;
            int y0 = Model.FIELD_CELL_SIZE/2;

            for (int i = 0, c = 0; (c < mazeBody.length()) && (i < sY); i++) {
                for (int j = 0; j < sX; j++) {
                    char c1 = mazeBody.toCharArray()[c];
                    switch (c1){
                        case 'X': Wall wall = new Wall(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                                    walls.add(wall);
                                    c++;
                                    break;
                        case '*': Box box = new Box(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                                    boxes.add(box);
                                     c++;
                                     break;
                        case '&': Box box1 = new Box(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                            boxes.add(box1);
                            Home home1 = new Home(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                            homes.add(home1);
                            c++;
                            break;
                        case '.': Home home = new Home(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                                    homes.add(home);
                                    c++;
                                    break;
                        case '@': player = new Player(Model.FIELD_CELL_SIZE * j + x0, Model.FIELD_CELL_SIZE * i + y0);
                                     c++;
                                     break;
                        case ' ':  c++;
                        break;
                    }
                }
            }

//        }

        //System.out.println(Arrays.toString(strings));

        return new GameObjects(walls, boxes, homes, player);
/*
Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int loopLevel;
        if (level > 60) {
            loopLevel = level % 60;
        } else {
            loopLevel = level;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            int readLevel = 0;
            int x;
            int y = Model.FIELD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    readLevel = Integer.valueOf(line.split(" ")[1]);
                    continue;
                }
                if (readLevel == loopLevel) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;

                        isLevelMap = !isLevelMap;

                        if (isEnd && !isLevelMap) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (isLevelMap) {
                        x = Model.FIELD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    homes.add(new Home(x, y));
                                    break;
                                case '&':
                                    boxes.add(new Box(x, y));
                                    homes.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += Model.FIELD_CELL_SIZE;
                        }
                        y += Model.FIELD_CELL_SIZE;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
 */
    }
}
