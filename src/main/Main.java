package main;

import canvas.Window;
import maze.RandomMaze;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Main {

    private static RandomMaze randomMaze;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public static final int X_COUNT = 5;
    public static final int Y_COUNT = 5;

    public static void main(String[] args) {
        randomMaze = new RandomMaze();
        randomMaze.createRandomMaze(0, 0, true, true);

        new Window();
    }

    public static RandomMaze getRandomMaze() {
        return randomMaze;
    }
}
