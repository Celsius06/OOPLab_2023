package Lab4.Q4;

import javax.swing.*;
import java.awt.*;

public class B extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int steps = 15;
        int gH = getHeight();
        int gW = getWidth();
        int widthStep = getWidth() / steps;
        int heightStep = getHeight() / steps;

        int x = widthStep;
        int y = heightStep;

        int i = 0;
        while (i < steps) {
            g.drawLine(0, i * y, (i + 1) * x, gH);
            g.drawLine(gW, i * y, gW - (i + 1) * x, gH);
            g.drawLine(0, gH - i * y, (i + 1) * x, 0);
            g.drawLine(gW, gH - i * y, gW - (i + 1) * x, 0);
            i++;
        }
    }
}
