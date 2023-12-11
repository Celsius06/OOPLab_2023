package Q3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static List<Person> people = new ArrayList<>();
    private static DefaultTableModel model;
    private static String[] columnNames = {"Type", "Name", "Address", "School", "Year/Fee", "Pay"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student/Staff Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1, 0));

            JButton addStudentButton = new JButton("Add Student");
            addStudentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addStudent();
                }
            });
            buttonPanel.add(addStudentButton);

            JButton addStaffButton = new JButton("Add Staff");
            addStaffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addStaff();
                }
            });
            buttonPanel.add(addStaffButton);

            JButton removeButton = new JButton("Remove Student/Staff");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        model.removeRow(selectedRow);
                        people.remove(selectedRow);
                    }
                }
            });
            buttonPanel.add(removeButton);

            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static void addStudent() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField nameField = new JTextField();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        JTextField addressField = new JTextField();
        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        JTextField schoolField = new JTextField();
        panel.add(new JLabel("School:"));
        panel.add(schoolField);

        JTextField yearField = new JTextField();
        panel.add(new JLabel("Year:"));
        panel.add(yearField);

        JTextField feeField = new JTextField();
        panel.add(new JLabel("Fee:"));
        panel.add(feeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Student Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String address = addressField.getText();
            String school = schoolField.getText();
            int year = Integer.parseInt(yearField.getText());
            int fee = Integer.parseInt(feeField.getText());

            Student student = new Student(name, address, school, year, fee);
            people.add(student);

            Object[] row = {"Student", student.getName(), student.getAddress(), student.getSchool(), student.getYear(), student.getFee()};
            model.addRow(row);
        }
    }

    private static void addStaff() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        JTextField addressField = new JTextField();
        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        JTextField schoolField = new JTextField();
        panel.add(new JLabel("School:"));
        panel.add(schoolField);

        JTextField payField = new JTextField();
        panel.add(new JLabel("Pay:"));
        panel.add(payField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Staff Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String address = addressField.getText();
            String school = schoolField.getText();
            double pay = Double.parseDouble(payField.getText());

            Staff staff = new Staff(name, address, school, pay);
            people.add(staff);

            Object[] row = {"Staff", staff.getName(), staff.getAddress(), staff.getSchool(), null, staff.getPay()};
            model.addRow(row);
        }
    }
}