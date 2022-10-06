package canvas;

import main.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Window {

    private final Canvas canvas;

    public Canvas getDraw() {
        return canvas;
    }

    public Window() {
        JFrame jFrame = new JFrame("Sudoku Solver");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.requestFocus();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        canvas.setVisible(true);

        jFrame.add(canvas);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
