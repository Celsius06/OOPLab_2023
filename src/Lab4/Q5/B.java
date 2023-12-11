package Lab4.Q5;

import javax.swing.*;
import java.awt.*;

public class B {
    private static final int frameSize = 400, maxRadius = 200, numLoops = 50;

    public class CircularSpiral extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = getWidth() / 2;
            int y = getHeight() / 2;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(0.5f));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            double angleStep = Math.PI / numLoops;
            double radiusStep = maxRadius / (2.0 * Math.PI * numLoops);
            double angle = 0;
            double radius = 0;

            int oldX = x, oldY = y;
            while (radius < maxRadius) {
                int newX = x + (int) (radius * Math.cos(angle));
                int newY = y + (int) (radius * Math.sin(angle));
                g2d.drawLine(oldX, oldY, newX, newY);
                oldX = newX;
                oldY = newY;

                angle += angleStep;
                radius += radiusStep;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSize, frameSize);
        frame.add(new B().new CircularSpiral());
        frame.setVisible(true);
    }
}
