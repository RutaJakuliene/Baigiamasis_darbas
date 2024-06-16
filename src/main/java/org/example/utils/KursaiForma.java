package org.example.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KursaiForma extends JPanel {
    private JTextField pavadinimasField;
    private JTextField pradziosDataField;
    private JTextField pabaigosDataField;

    public KursaiForma() {
        setupForm();
    }

    private void setupForm() {
        setLayout(new GridLayout(4, 2));

        JLabel pavadinimasLabel = new JLabel("Pavadinimas:");
        add(pavadinimasLabel);
        pavadinimasField = new JTextField(20);
        add(pavadinimasField);

        JLabel pradziosDataLabel = new JLabel("Pradžios data (yyyy-MM-dd):");
        add(pradziosDataLabel);
        pradziosDataField = new JTextField(20);
        add(pradziosDataField);

        JLabel pabaigosDataLabel = new JLabel("Pabaigos data (yyyy-MM-dd):");
        add(pabaigosDataLabel);
        pabaigosDataField = new JTextField(20);
        add(pabaigosDataField);

        JButton saveButton = new JButton("Išsaugoti");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveKursas();
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

    private void saveKursas() {
        try {
            String pavadinimas = pavadinimasField.getText().trim();
            String pradziosDataText = pradziosDataField.getText().trim();
            LocalDate pradziosData = LocalDate.parse(pradziosDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String pabaigosDataText = pabaigosDataField.getText().trim();
            LocalDate pabaigosData = LocalDate.parse(pabaigosDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Prisijungiame prie MySQL duomenų bazės
            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Sukuriame SQL užklausą, kuri įrašo duomenis į kursai lentelę
            String sql = "INSERT INTO kursai (Pavadinimas, Pradzios_data, Pabaigos_data) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pavadinimas);
            statement.setDate(2, java.sql.Date.valueOf(pradziosData));
            statement.setDate(3, java.sql.Date.valueOf(pabaigosData));

            // Įvykdome užklausą
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Kursas išsaugotas sėkmingai.");
                clearForm();
            }

            connection.close();
        } catch (DateTimeException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida įrašant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        pavadinimasField.setText("");
        pradziosDataField.setText("");
        pabaigosDataField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Kursų Forma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new KursaiForma(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}