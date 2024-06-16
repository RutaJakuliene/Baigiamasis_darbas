package org.example.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AsmuoForma extends JPanel {

    private JTextField vardasField;
    private JTextField pavardeField;
    private JTextField gimimoDataField;
    private JTextField adresasField;
    private JTextField elPastasField;
    private JTextField telefonasField;

    public AsmuoForma() {
        setupForm();
    }

    private void setupForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel vardasLabel = new JLabel("Vardas:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(vardasLabel, gbc);
        vardasField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(vardasField, gbc);

        JLabel pavardeLabel = new JLabel("Pavardė:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(pavardeLabel, gbc);
        pavardeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(pavardeField, gbc);

        JLabel gimimoDataLabel = new JLabel("Gimimo data (yyyy-MM-dd):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(gimimoDataLabel, gbc);
        gimimoDataField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(gimimoDataField, gbc);

        JLabel adresasLabel = new JLabel("Adresas:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(adresasLabel, gbc);
        adresasField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(adresasField, gbc);

        JLabel elPastasLabel = new JLabel("El. paštas:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(elPastasLabel, gbc);
        elPastasField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(elPastasField, gbc);

        JLabel telefonasLabel = new JLabel("Telefonas:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(telefonasLabel, gbc);
        telefonasField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(telefonasField, gbc);

        JButton saveButton = new JButton("Išsaugoti");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsmuo();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(saveButton, gbc);

        JButton findButton = new JButton("Surasti pagal pavardę");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAsmuoByPavarde();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(findButton, gbc);

        JButton deleteButton = new JButton("Ištrinti pagal pavardę");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAsmuoByPavarde();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(deleteButton, gbc);

        JButton clearButton = new JButton("Išvalyti formą");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(clearButton, gbc);
    }

    private void saveAsmuo() {
        try {
            String vardas = vardasField.getText().trim();
            String pavarde = pavardeField.getText().trim();
            String gimimoDataText = gimimoDataField.getText().trim();
            LocalDate gimimoData = LocalDate.parse(gimimoDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String adresas = adresasField.getText().trim();
            String elPastas = elPastasField.getText().trim();
            String telefonas = telefonasField.getText().trim();

            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO asmuo (Vardas, Pavarde, Gimimo_data, Adresas, El_pastas, Telefonas) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vardas);
            statement.setString(2, pavarde);
            statement.setDate(3, java.sql.Date.valueOf(gimimoData));
            statement.setString(4, adresas);
            statement.setString(5, elPastas);
            statement.setString(6, telefonas);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Asmuo išsaugotas sėkmingai.");
                clearForm();
            }

            connection.close();
        } catch (SQLException | DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Klaida įrašant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void findAsmuoByPavarde() {
        try {
            String pavarde = pavardeField.getText().trim();

            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM asmuo WHERE Pavarde = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pavarde);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                vardasField.setText(resultSet.getString("Vardas"));
                gimimoDataField.setText(resultSet.getDate("Gimimo_data").toString());
                adresasField.setText(resultSet.getString("Adresas"));
                elPastasField.setText(resultSet.getString("El_pastas"));
                telefonasField.setText(resultSet.getString("Telefonas"));
            } else {
                JOptionPane.showMessageDialog(this, "Asmuo su pavardė '" + pavarde + "' nerastas.", "Nerasta", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida ieškant duomenų: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAsmuoByPavarde() {
        try {
            String pavarde = pavardeField.getText().trim();

            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM asmuo WHERE Pavarde = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pavarde);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Asmuo su pavardė '" + pavarde + "' ištrintas sėkmingai.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Asmuo su pavardė '" + pavarde + "' nerastas.", "Nerasta", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida trinant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        vardasField.setText("");
        pavardeField.setText("");
        gimimoDataField.setText("");
        adresasField.setText("");
        elPastasField.setText("");
        telefonasField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Asmens Forma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new AsmuoForma(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
