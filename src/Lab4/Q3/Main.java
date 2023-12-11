package Lab4.Q3;

import javax.swing.*;

public class Main {
public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);
        frame1.add(new A());
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 400);
        frame2.add(new B());
        frame2.setVisible(true);
    }
}