package Lab4.Q3;

import javax.swing.*;
import java.awt.*;

public class A extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int steps = 15;
        int w = getWidth() / steps;
        int h = getHeight() / steps;

        for (int i = 0; i < steps; i++) {
            g.drawLine(0, 0, i * w, getHeight() - i * h);
        }
    }
}
