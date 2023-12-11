package Lab4.Q1;

import javax.swing.JOptionPane;

public class Q1 {
    public static void main(String[] args) {
        String name;
        name = JOptionPane.showInputDialog("What is your name ? ");
        String message = "Welcome, " + name + ", to Java Programming!" ;
        JOptionPane.showMessageDialog(null, message);
    }
}
