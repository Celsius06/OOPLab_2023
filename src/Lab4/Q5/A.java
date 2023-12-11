package Lab4.Q5;

import javax.swing.*;
import java.awt.*;

public class A {
    public class SquareSpiral extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int length = 0;
            int x = getWidth() / 2;
            int y = getHeight() / 2;

            for (int i = 0; i < 15; i++) {
                switch (i % 4) {
                    case 0: // Move up
                        g.drawLine(x, y, x, y - length);
                        y -= length;
                        break;
                    case 1: // Move right
                        g.drawLine(x, y, x + length, y);
                        x += length;
                        break;
                    case 2: // Move down
                        g.drawLine(x, y, x, y + length);
                        y += length;
                        break;
                    case 3: // Move left
                        g.drawLine(x, y, x - length, y);
                        x -= length;
                        break;
                }
                if (i % 2 != 0) {
                    length += 20; // Increase length after every second line
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new A().new SquareSpiral());
        frame.setVisible(true);
    }
}