package canvas;

import main.Main;
import maze.Cell;
import maze.RandomMaze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Canvas extends JLabel {

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        Cell[][] maze = Main.getRandomMaze().getMaze();

        float i = (float) Main.WIDTH / Main.getRandomMaze().getMaze().length;

        for (int x = 0; x < Main.getRandomMaze().getMaze().length; x++) {
            for (int y = 0; y < Main.getRandomMaze().getMaze()[x].length; y++) {


                if (maze[x][y].hasUpperWall()) {
                    graphics2D.drawLine((int) (x * i), (int) (y * i), (int) (x * i + i), (int) (y * i));
                }
                if (maze[x][y].hasRightWall()) {
                    graphics2D.drawLine((int) (x * i + i), (int) (y * i), (int) (x * i + i), (int) (y * i + i));
                }

            }
        }

    }
}
