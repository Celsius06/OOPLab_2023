package Lab4.Q3;

import javax.swing.*;
import java.awt.*;

public class B extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        int steps = 15; 
        int xStep = w/steps; 
        int yStep = h/steps; 
        int x = w;
        int y = 0;
        while(x > 0 && y < h){
            x -= xStep;
            y += yStep;
            g2.drawLine(0, 0, x, y);
            g2.drawLine(w, h, x, y);    
        }
        x = 0;
        y = 0;
        while(x < w && y < h){
            x += xStep;
            y += yStep;
            g2.drawLine(w, 0, x, y);
            g2.drawLine(0, h, x, y);
        }
    }
}