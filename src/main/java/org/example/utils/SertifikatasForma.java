package org.example.utils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SertifikatasForma extends JPanel {
    private JTextField pavadinimasField;
    private JTextField sertifikavimoDataField;
    private JTextField galiojimoDataField;
    private JTextField asmuoIdField;

    public SertifikatasForma() {
        setupForm();
    }

    private void setupForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel pavadinimasLabel = new JLabel("Pavadinimas:");
        add(pavadinimasLabel, gbc);

        gbc.gridx = 1;
        pavadinimasField = new JTextField(20);
        add(pavadinimasField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel sertifikavimoDataLabel = new JLabel("Sertifikavimo data (yyyy-MM-dd):");
        add(sertifikavimoDataLabel, gbc);

        gbc.gridx = 1;
        sertifikavimoDataField = new JTextField(20);
        add(sertifikavimoDataField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel galiojimoDataLabel = new JLabel("Galiojimo data (yyyy-MM-dd):");
        add(galiojimoDataLabel, gbc);

        gbc.gridx = 1;
        galiojimoDataField = new JTextField(20);
        add(galiojimoDataField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel asmuoIdLabel = new JLabel("Asmuo ID:");
        add(asmuoIdLabel, gbc);

        gbc.gridx = 1;
        asmuoIdField = new JTextField(20);
        add(asmuoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton saveButton = new JButton("Išsaugoti");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSertifikatas();
            }
        });
        buttonPanel.add(saveButton);

        JButton clearButton = new JButton("Išvalyti");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        buttonPanel.add(clearButton);

        JButton printButton = new JButton("Spausdinti");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printSertifikatas();
            }
        });
        buttonPanel.add(printButton);

        JButton findButton = new JButton("Surasti pagal kursą");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findSertifikatasByCourse();
            }
        });
        buttonPanel.add(findButton);

        add(buttonPanel, gbc);
    }

    private void saveSertifikatas() {
        try {
            String pavadinimas = pavadinimasField.getText().trim();
            String sertifikavimoDataText = sertifikavimoDataField.getText().trim();
            LocalDate sertifikavimoData = LocalDate.parse(sertifikavimoDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String galiojimoDataText = galiojimoDataField.getText().trim();
            LocalDate galiojimoData = LocalDate.parse(galiojimoDataText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String asmuoIdText = asmuoIdField.getText().trim();
            int asmuoId = Integer.parseInt(asmuoIdText);

            String url = "jdbc:mysql://localhost:3306/baigiamasis";
            String user = "root";
            String password = "jakuliene";

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO sertifikatas (Pavadinimas, Sertifikavimo_data, Galiojimo_data, Asmuo_ID) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pavadinimas);
            statement.setDate(2, java.sql.Date.valueOf(sertifikavimoData));
            statement.setDate(3, java.sql.Date.valueOf(galiojimoData));
            statement.setInt(4, asmuoId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Sertifikatas išsaugotas sėkmingai.");
                clearForm();
            }

            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Klaida įrašant duomenis: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        pavadinimasField.setText("");
        sertifikavimoDataField.setText("");
        galiojimoDataField.setText("");
        asmuoIdField.setText("");
    }

    private void printSertifikatas() {
        JOptionPane.showMessageDialog(this, "Spausdinimas dar neįgyvendintas.", "Informacija", JOptionPane.INFORMATION_MESSAGE);
    }

    private void findSertifikatasByCourse() {
        try {
            JPanel inputPanel = new JPanel(new GridLayout(2, 2));
            JTextField kursasPavadinimasField = new JTextField();
            JTextField asmensIdField = new JTextField();

            inputPanel.add(new JLabel("Įveskite kurso pavadinimą:"));
            inputPanel.add(kursasPavadinimasField);
            inputPanel.add(new JLabel("Įveskite asmens ID:"));
            inputPanel.add(asmensIdField);

            int result = JOptionPane.showConfirmDialog(this, inputPanel, "Paieška pagal kursą ir asmens ID", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String kursasPavadinimas = kursasPavadinimasField.getText().trim();
                String asmensIdText = asmensIdField.getText().trim();
                int asmensId = Integer.parseInt(asmensIdText);

                String url = "jdbc:mysql://localhost:3306/baigiamasis";
                String user = "root";
                String password = "jakuliene";

                Connection connection = DriverManager.getConnection(url, user, password);

                String sql = "SELECT * FROM sertifikatas WHERE Pavadinimas LIKE ? AND Asmuo_ID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + kursasPavadinimas + "%");
                statement.setInt(2, asmensId);

                ResultSet resultSet = statement.executeQuery();
                StringBuilder results = new StringBuilder();
                results.append("Rasti sertifikatai pagal kursą '").append(kursasPavadinimas).append("' ir asmens ID '").append(asmensId).append("':\n\n");

                boolean found = false;
                while (resultSet.next()) {
                    found = true;
                    int id = resultSet.getInt("ID");
                    String pavadinimas = resultSet.getString("Pavadinimas");
                    LocalDate sertifikavimoData = resultSet.getDate("Sertifikavimo_data").toLocalDate();
                    LocalDate galiojimoData = resultSet.getDate("Galiojimo_data").toLocalDate();
                    int asmuoId = resultSet.getInt("Asmuo_ID");

                    results.append("ID: ").append(id).append("\n");
                    results.append("Pavadinimas: ").append(pavadinimas).append("\n");
                    results.append("Sertifikavimo data: ").append(sertifikavimoData).append("\n");
                    results.append("Galiojimo data: ").append(galiojimoData).append("\n");
                    results.append("Asmuo ID: ").append(asmuoId).append("\n\n");
                }

                if (found) {
                    JOptionPane.showMessageDialog(this, results.toString(), "Paieškos rezultatai", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Kursas nerastas pagal įvestus kriterijus.", "Paieškos rezultatai", JOptionPane.INFORMATION_MESSAGE);
                }

                connection.close();
            }
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Klaida vykdant paiešką: " + ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Sertifikato Forma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new SertifikatasForma(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
