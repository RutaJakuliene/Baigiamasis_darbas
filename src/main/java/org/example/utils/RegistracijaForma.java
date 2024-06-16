//veikia
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

public class RegistracijaForma extends JPanel {
    private JTextField registracijosDataField;
    private JTextField asmuoIdField;

    public RegistracijaForma() {
        setupForm();
    }

    private void setupForm() {
        setLayout(new GridLayout(3, 2));

        JLabel registracijosDataLabel = new JLabel("Registracijos data:");
        add(registracijosDataLabel);
        registracijosDataField = new JTextField(20);
        add(registracijosDataField);

        JLabel asmuoIdLabel = new JLabel("Asmuo ID:");
        add(asmuoIdLabel);
        asmuoIdField = new JTextField(20);
        add(asmuoIdField);

        JButton saveButton = new JButton("Išsaugoti");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRegistracija();
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

    private void saveRegistracija() {
        try {
            String registracijosDataText = registracijosDataField.getText().trim();
            LocalDate registracijosData = LocalDate.parse(registracijosDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            String asmuoIdText = asmuoIdField.getText().trim();
            int asmuoId = Integer.parseInt(asmuoIdText);

            // Prisijungiame prie MySQL duomenų bazės
            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Sukuriame SQL užklausą, kuri įrašo duomenis į registracija lentelę
            String sql = "INSERT INTO registracija (Registracijos_data, Asmuo_ID) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(registracijosData));
            statement.setInt(2, asmuoId);

            // Įvykdome užklausą
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registracija išsaugota sėkmingai.");
                clearForm();
            }

            connection.close();
        } catch (NumberFormatException | DateTimeException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida įrašant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        registracijosDataField.setText("");
        asmuoIdField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Registracija Forma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new RegistracijaForma(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
