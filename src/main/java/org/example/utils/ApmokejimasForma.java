package org.example.utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ApmokejimasForma extends JPanel {
    private JTextField sumaField;
    private JTextField mokejimoBudasField;
    private JTextField asmuoIdField;
    private JTextField kursaiIdField;
    public ApmokejimasForma() {
        setupForm();
    }
    private void setupForm() {
        setLayout(new GridLayout(5, 2));
        JLabel sumaLabel = new JLabel("Suma:");
        add(sumaLabel);
        sumaField = new JTextField(20);
        add(sumaField);
        JLabel mokejimoBudasLabel = new JLabel("Mokėjimo būdas:");
        add(mokejimoBudasLabel);
        mokejimoBudasField = new JTextField(20);
        add(mokejimoBudasField);
        JLabel asmuoIdLabel = new JLabel("Asmuo ID:");
        add(asmuoIdLabel);
        asmuoIdField = new JTextField(20);
        add(asmuoIdField);
        JLabel kursaiIdLabel = new JLabel("Kursai ID:");
        add(kursaiIdLabel);
        kursaiIdField = new JTextField(20);
        add(kursaiIdField);
        JButton saveButton = new JButton("Išsaugoti");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveApmokejimas();
            }
        });
        add(saveButton);
        JButton clearButton = new JButton("Išvalyti");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        add(clearButton);
    }
    private void saveApmokejimas() {
        try {
            String sumaText = sumaField.getText().trim();
            double suma = Double.parseDouble(sumaText);
            String mokejimoBudas = mokejimoBudasField.getText().trim();
            String asmuoIdText = asmuoIdField.getText().trim();
            int asmuoId = Integer.parseInt(asmuoIdText);
            String kursaiIdText = kursaiIdField.getText().trim();
            int kursaiId = Integer.parseInt(kursaiIdText);
            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO apmokejimas (Suma, Mokejimo_budas, Asmuo_ID, Kursai_ID) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, suma);
            statement.setString(2, mokejimoBudas);
            statement.setInt(3, asmuoId);
            statement.setInt(4, kursaiId);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Įrašas išsaugotas sėkmingai.");
                clearForm();
            }
            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida įrašant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearForm() {
        sumaField.setText("");
        mokejimoBudasField.setText("");
        asmuoIdField.setText("");
        kursaiIdField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Įrašų Forma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ApmokejimasForma(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
