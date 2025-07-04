package rs.ac.singidunum.novisad.ui.modals.menadzer;

import rs.ac.singidunum.novisad.model.Uloga;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DodajMenadzeraModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 6283947510293847152L;

    private JPanel formaPanel;

    private JLabel imeLabel;
    private JTextField imeInput;

    private JLabel prezimeLabel;
    private JTextField prezimeInput;

    private JLabel plataLabel;
    private JSpinner plataInput;

    private JLabel zvanjeLabel;
    private JTextField zvanjeInput;

    private JLabel stepenObrazovanjaLabel;
    private JTextField stepenObrazovanjaInput;

    private JLabel ulogaLabel;
    private JComboBox ulogaInput;

    private JPanel buttonPanel;
    private JButton dodajButton;
    private JButton odustaniButton;

    public DodajMenadzeraModal(ArrayList<Uloga> uloge) {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Dodaj Novog Menadzerau");
        this.setSize(500, 800);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeLabel = new JLabel("Ime:");
        this.imeInput = new JTextField();

        this.prezimeLabel = new JLabel("Prezime:");
        this.prezimeInput = new JTextField();

        this.plataLabel = new JLabel("Plata:");
        this.plataInput = new JSpinner();

        this.zvanjeLabel = new JLabel("Zvanje:");
        this.zvanjeInput = new JTextField();

        this.stepenObrazovanjaLabel = new JLabel("Stepen Obrazovanja:");
        this.stepenObrazovanjaInput = new JTextField();

        this.ulogaLabel = new JLabel("Uloga:");
        this.ulogaInput = new JComboBox();

        for (Uloga uloga : uloge) {
            this.ulogaInput.addItem(uloga);
        }

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.dodajButton = new JButton("Dodaj");
        this.odustaniButton = new JButton("Odustani");
    }

    public void init() {
        this.formaPanel.add(imeLabel);
        this.formaPanel.add(imeInput);
        this.formaPanel.add(prezimeLabel);
        this.formaPanel.add(prezimeInput);
        this.formaPanel.add(plataLabel);
        this.formaPanel.add(plataInput);
        this.formaPanel.add(zvanjeLabel);
        this.formaPanel.add(zvanjeInput);
        this.formaPanel.add(stepenObrazovanjaLabel);
        this.formaPanel.add(stepenObrazovanjaInput);
        this.formaPanel.add(ulogaLabel);
        this.formaPanel.add(ulogaInput);

        this.buttonPanel.add(dodajButton);
        this.buttonPanel.add(odustaniButton);

        this.odustaniButton.addActionListener(e -> this.dispose());

        this.add(formaPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public JButton getDodajButton() {
        return dodajButton;
    }

    public JTextField getImeInput() {
        return imeInput;
    }

    public JTextField getPrezimeInput() {
        return prezimeInput;
    }

    public JSpinner getPlataInput() {
        return plataInput;
    }

    public JTextField getZvanjeInput() {
        return zvanjeInput;
    }

    public JTextField getStepenObrazovanjaInput() {
        return stepenObrazovanjaInput;
    }

    public JComboBox<Uloga> getUlogaInput() {
        return ulogaInput;
    }
}