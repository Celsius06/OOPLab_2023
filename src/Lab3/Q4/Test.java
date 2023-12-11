package Q4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Point Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            String[] columnNames = {"Type", "x", "y", "z"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            String x2D = JOptionPane.showInputDialog(frame, "Enter x for Point2D:");
            String y2D = JOptionPane.showInputDialog(frame, "Enter y for Point2D:");
            Point_2D point2D = new Point_2D();
            point2D.setX(Float.parseFloat(x2D));
            point2D.setY(Float.parseFloat(y2D));

            model.addRow(new Object[]{"Point2D", point2D.getX(), point2D.getY(), null});

            String x3D = JOptionPane.showInputDialog(frame, "Enter x for Point3D:");
            String y3D = JOptionPane.showInputDialog(frame, "Enter y for Point3D:");
            String z3D = JOptionPane.showInputDialog(frame, "Enter z for Point3D:");
            Point_3D point3D = new Point_3D();
            point3D.setX(Float.parseFloat(x3D));
            point3D.setY(Float.parseFloat(y3D));
            point3D.setZ(Float.parseFloat(z3D));

            model.addRow(new Object[]{"Point3D", point3D.getX(), point3D.getY(), point3D.getZ()});

            frame.pack();
            frame.setVisible(true);
        });
    }
}