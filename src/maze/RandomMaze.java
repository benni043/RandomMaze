package maze;

import main.Main;
import mega.Direction;
import mega.Point;

import java.util.ArrayList;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class RandomMaze {

    private final Cell[][] maze = new Cell[Main.X_COUNT][Main.Y_COUNT];

    public void createRandomMaze(int x, int y, boolean hasUpperWall, boolean hasRightWall) {
        if (maze[x][y] == null) {
            maze[x][y] = new Cell(hasUpperWall, hasRightWall);
        } else {
            maze[x][y].maySetUpperWall(hasUpperWall);
            maze[x][y].maySetRightWall(hasRightWall);
        }

        ArrayList<Point> validCellCords = new ArrayList<>();

        if (isValid(x + 1, y)) validCellCords.add(new Point(x + 1, y, Direction.right));
        if (isValid(x - 1, y)) validCellCords.add(new Point(x - 1, y, Direction.left));
        if (isValid(x, y + 1)) validCellCords.add(new Point(x, y + 1, Direction.bottom));
        if (isValid(x, y - 1)) validCellCords.add(new Point(x, y - 1, Direction.top));

        if (validCellCords.size() == 0) return;

        Point point = validCellCords.get((int) (Math.random() * validCellCords.size()));

        switch (point.direction()) {
            case top -> {
                createRandomMaze(point.x(), point.y(), true, true);
                createRandomMaze(x, y, false, true);
            }
            case bottom -> {
                createRandomMaze(point.x(), point.y(), false, true);
                createRandomMaze(x, y, true, true);
            }
            case left -> {
                createRandomMaze(point.x(), point.y(), true, false);
                createRandomMaze(x, y, true, true);
            }
            case right -> {
                createRandomMaze(point.x(), point.y(), true, true);
                createRandomMaze(x, y, true, false);
            }
        }

    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) return false;

        return maze[x][y] == null;
    }

    public Cell[][] getMaze() {
        return maze;
    }
}