package Lab4.Q4;

import javax.swing.*;
import java.awt.*;

public class A extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int steps = 15;
        int widthStep = getWidth() / steps;
        int heightStep = getHeight() / steps;

        int i = 0;
        while (i < steps) {
            g.drawLine(0, i * heightStep, (i + 1) * widthStep, getHeight());
            i++;
        }
    }
}