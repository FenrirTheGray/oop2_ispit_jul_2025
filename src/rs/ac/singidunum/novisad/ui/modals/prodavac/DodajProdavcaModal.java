package rs.ac.singidunum.novisad.ui.modals.prodavac;

import rs.ac.singidunum.novisad.model.Menadzer;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DodajProdavcaModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 9174836529384710648L;

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

    private JLabel nadredjeniLabel;
    private JComboBox<Menadzer> nadredjeniInput;

    private JLabel radnoMestoLabel;
    private JTextField radnoMestoInput;

    private JPanel buttonPanel;
    private JButton dodajButton;
    private JButton odustaniButton;

    public DodajProdavcaModal(ArrayList<Menadzer> menadzeri) {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Dodaj Novog Prodavca");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeLabel = new JLabel("Ime:");
        this.imeInput = new JTextField();

        this.prezimeLabel = new JLabel("Prezime:");
        this.prezimeInput = new JTextField();

        this.plataLabel = new JLabel("Plata:");
        this.plataInput = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 100.0));

        this.zvanjeLabel = new JLabel("Zvanje:");
        this.zvanjeInput = new JTextField();

        this.stepenObrazovanjaLabel = new JLabel("Stepen Obrazovanja:");
        this.stepenObrazovanjaInput = new JTextField();

        this.nadredjeniLabel = new JLabel("Nadredjeni:");
        this.nadredjeniInput = new JComboBox<>(menadzeri.toArray(new Menadzer[0]));

        this.radnoMestoLabel = new JLabel("Radno Mesto:");
        this.radnoMestoInput = new JTextField();

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
        this.formaPanel.add(nadredjeniLabel);
        this.formaPanel.add(nadredjeniInput);
        this.formaPanel.add(radnoMestoLabel);
        this.formaPanel.add(radnoMestoInput);

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

    public JButton getOdustaniButton() {
        return odustaniButton;
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

    public JComboBox<Menadzer> getNadredjeniInput() {
        return nadredjeniInput;
    }

    public JTextField getRadnoMestoInput() {
        return radnoMestoInput;
    }
}