package Lab4.Q6;

import javax.swing.*;
import java.awt.*;

public class Q6 {
    private static final int numBars = 5, barHeight = 20, barGap = 30, frameSize = 400;
    private static int n = numBars;
    private static int h = barHeight;
    private static int bG = barGap;
    private static int fS = frameSize;

    public static class barChart extends JFrame {
        private final int[] values = new int[n];
        private final Color[] colors = new Color[n];

        public barChart() {
            for (int i = 0; i < n; i++) {
                values[i] = getValidInput("Enter a number: ");
                colors[i] = new Color((int) (Math.random() * 0x1000000));
            }
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(fS, fS);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int y = 80;
            for (int i = 0; i < n; i++) {
                g.setColor(colors[i]);
                g.fillRect(100, y, values[i], h);
                y += bG;
            }
            y = 80;
            for (int i = 0; i < n; i++) {
                g.setColor(Color.BLACK);
                int x = 80 - (String.valueOf(values[i]).length() - 1) * 10;
                g.drawString(String.valueOf(values[i]), x, y + h / 2);
                y += bG;
            }
        }

        private int getValidInput(String message) {
            while (true) {
                try {
                    return Integer.parseInt(JOptionPane.showInputDialog(message));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Wrong input! Please input a valid integer.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new barChart();
    }
}
