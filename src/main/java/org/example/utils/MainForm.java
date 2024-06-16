package org.example.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainForm extends JFrame {
    public MainForm() {
        setupMainForm();
    }
    private void setupMainForm() {
        setTitle("Pagrindinė Forma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1)); // Pridėtas vienas mygtukas, taigi GridLayout turi būti 6, 1

        JButton apmokejimasButton = new JButton("Apmokėjimas Forma");
        apmokejimasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showApmokejimasForma();
            }
        });
        add(apmokejimasButton);

        JButton asmuoButton = new JButton("Asmuo Forma");
        asmuoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAsmuoForma();
            }
        });
        add(asmuoButton);

        JButton kursaiButton = new JButton("Kursai Forma");
        kursaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showKursaiForma();
            }
        });
        add(kursaiButton);

        JButton registracijaButton = new JButton("Registracija Forma");
        registracijaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistracijaForma();
            }
        });
        add(registracijaButton);

        JButton sertifikatasButton = new JButton("Sertifikatas Forma");
        sertifikatasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSertifikatasForma();
            }
        });
        add(sertifikatasButton);

        JButton uzdarytiButton = new JButton("Uždaryti");
        uzdarytiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Uždaro pagrindinę formą
            }
        });
        add(uzdarytiButton);

        pack();
        setLocationRelativeTo(null); // Centruoja langą ekrane
    }

    private void showApmokejimasForma() {
        JFrame frame = new JFrame("Apmokėjimas Forma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ApmokejimasForma(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centruoja langą ekrane
        frame.setVisible(true);
    }

    private void showAsmuoForma() {
        JFrame frame = new JFrame("Asmuo Forma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new AsmuoForma(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centruoja langą ekrane
        frame.setVisible(true);
    }

    private void showKursaiForma() {
        JFrame frame = new JFrame("Kursai Forma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new KursaiForma(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centruoja langą ekrane
        frame.setVisible(true);
    }

    private void showRegistracijaForma() {
        JFrame frame = new JFrame("Registracija Forma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new RegistracijaForma(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centruoja langą ekrane
        frame.setVisible(true);
    }

    private void showSertifikatasForma() {
        JFrame frame = new JFrame("Sertifikatas Forma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new SertifikatasForma(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centruoja langą ekrane
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
