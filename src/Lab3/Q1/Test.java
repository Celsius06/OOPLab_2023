package Q1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Test {
    static ArrayList<MyShape> shapeList = new ArrayList<>();
    static DefaultTableModel tableModel;
    static JPanel drawingPanel;
    private static int lineCounter = 0;
    private static int rectangleCounter = 0;
    private static int ovalCounter = 0;

    public static void main(String[] args) {
        JFrame Frame = new JFrame();
        Frame.setSize(800, 800);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (MyShape shape : shapeList) {
                    shape.draw(g);
                }
            }
        };
        Frame.add(drawingPanel);

        JPanel controlPanel = new JPanel();
        JButton drawLineButton = new JButton("Draw Line");
        JButton drawRectangleButton = new JButton("Draw Rectangle");
        JButton drawOvalButton = new JButton("Draw Oval");

        drawLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShape("Line", Frame);
                drawingPanel.repaint();
            }
        });

        drawRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShape("Rectangle", Frame);
                drawingPanel.repaint();
            }
        });

        drawOvalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShape("Oval", Frame);
                drawingPanel.repaint();
            }
        });

        controlPanel.add(drawLineButton);
        controlPanel.add(drawRectangleButton);
        controlPanel.add(drawOvalButton);
        Frame.add(controlPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Shape Type", "Area"}, 0);
        JTable shapeTable = new JTable(tableModel);
        Frame.add(new JScrollPane(shapeTable), BorderLayout.EAST);

        Frame.setVisible(true);
    }

    private static void addShape(String shapeType, JFrame frame) {
        if (shapeList.size() >= 5) {
            JOptionPane.showMessageDialog(frame, "You have drawn 5 shapes. You can't draw more.");
            return;
        }

        int x1, y1, x2, y2, x, y, width, height;
        Dimension panelSize = drawingPanel.getSize();
        double scale = Math.min(panelSize.getWidth() / 1920.0, panelSize.getHeight() / 1080.0);

        if (shapeType.equals("Line")) {
            x1 = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the first x coordinate"));
            y1 = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the first y coordinate"));
            x2 = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the second x coordinate"));
            y2 = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the second y coordinate"));
            shapeList.add(new MyLine(x1, y1, x2, y2));
            lineCounter++;
            tableModel.addRow(new Object[]{shapeType + " " + lineCounter, "N/A"});
        } else {
            x = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the x coordinate:"));
            y = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the y coordinate:"));
            width = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the width:"));
            height = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the height:"));
            x = (int) (x * scale);
            y = (int) (y * scale);

            switch (shapeType) {
                case "Rectangle":
                    MyRectangle rectangle = new MyRectangle(x, y, width, height);
                    shapeList.add(rectangle);
                    rectangleCounter++;
                    tableModel.addRow(new Object[]{shapeType + " " + rectangleCounter, String.valueOf(rectangle.getArea())});
                    break;
                case "Oval":
                    MyOval oval = new MyOval(x, y, width, height);
                    shapeList.add(oval);
                    ovalCounter++;
                    tableModel.addRow(new Object[]{shapeType + " " + ovalCounter, String.valueOf(oval.getArea())});
                    break;
            }
        }
    }
}