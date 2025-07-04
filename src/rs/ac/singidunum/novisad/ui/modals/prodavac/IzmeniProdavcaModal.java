package rs.ac.singidunum.novisad.ui.modals.prodavac;

import rs.ac.singidunum.novisad.model.Menadzer;
import rs.ac.singidunum.novisad.model.Prodavac;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class IzmeniProdavcaModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 2748391650293847519L;

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
    private JButton izmeniButton;
    private JButton odustaniButton;

    private Prodavac prodavac;
    private ArrayList<Menadzer> menadzeri;

    public IzmeniProdavcaModal(Prodavac prodavac, ArrayList<Menadzer> menadzeri) {
        super();
        this.prodavac = prodavac;
        this.menadzeri = menadzeri;
        this.setLayout(new BorderLayout());
        this.setTitle("Izmeni Prodavca");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeLabel = new JLabel("Ime:");
        this.imeInput = new JTextField(prodavac.getIme());

        this.prezimeLabel = new JLabel("Prezime:");
        this.prezimeInput = new JTextField(prodavac.getPrezime());

        this.plataLabel = new JLabel("Plata:");
        this.plataInput = new JSpinner(new SpinnerNumberModel(prodavac.getPlata(), 0.0, Double.MAX_VALUE, 100.0));

        this.zvanjeLabel = new JLabel("Zvanje:");
        this.zvanjeInput = new JTextField(prodavac.getZvanje());

        this.stepenObrazovanjaLabel = new JLabel("Stepen Obrazovanja:");
        this.stepenObrazovanjaInput = new JTextField(prodavac.getStepenObrazovanja());

        this.nadredjeniLabel = new JLabel("Nadredjeni:");
        this.nadredjeniInput = new JComboBox<>(menadzeri.toArray(new Menadzer[0]));
        this.nadredjeniInput.setSelectedItem(prodavac.getNadredjeni());

        this.radnoMestoLabel = new JLabel("Radno Mesto:");
        this.radnoMestoInput = new JTextField(prodavac.getRadnoMesto());

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.izmeniButton = new JButton("Izmeni");
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

        this.buttonPanel.add(izmeniButton);
        this.buttonPanel.add(odustaniButton);

        this.odustaniButton.addActionListener(e -> this.dispose());

        this.add(formaPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public JButton getIzmeniButton() {
        return izmeniButton;
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

    public Prodavac getProdavac() {
        return prodavac;
    }
}