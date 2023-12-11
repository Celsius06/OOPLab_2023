package Lab4.Q2;

import javax.swing.*;
import java.awt.*;

public class Q2 extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.drawLine(0, 0, w, h); 
        g.drawLine(w, 0, 0, h);
        g.drawLine(0, h/2, w, h/2);
        g.drawLine(w/2, 0, w/2, h); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new Q2());
        frame.setVisible(true);
    }
}
