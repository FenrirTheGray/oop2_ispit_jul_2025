package rs.ac.singidunum.novisad.ui.modals.menadzer;

import rs.ac.singidunum.novisad.model.Menadzer;
import rs.ac.singidunum.novisad.model.Uloga;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class IzmeniMenadzeraModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 3847291650384719263L;

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
    private JComboBox<Uloga> ulogaInput;

    private JPanel buttonPanel;
    private JButton izmeniButton;
    private JButton odustaniButton;

    private Menadzer menadzer;
    private ArrayList<Uloga> uloge;

    public IzmeniMenadzeraModal(Menadzer menadzer, ArrayList<Uloga> uloge) {
        super();
        this.menadzer = menadzer;
        this.uloge = uloge;
        this.setLayout(new BorderLayout());
        this.setTitle("Izmeni Menadzera");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeLabel = new JLabel("Ime:");
        this.imeInput = new JTextField(menadzer.getIme());

        this.prezimeLabel = new JLabel("Prezime:");
        this.prezimeInput = new JTextField(menadzer.getPrezime());

        this.plataLabel = new JLabel("Plata:");
        this.plataInput = new JSpinner(new SpinnerNumberModel(menadzer.getPlata(), 0.0, Double.MAX_VALUE, 100.0));

        this.zvanjeLabel = new JLabel("Zvanje:");
        this.zvanjeInput = new JTextField(menadzer.getZvanje());

        this.stepenObrazovanjaLabel = new JLabel("Stepen Obrazovanja:");
        this.stepenObrazovanjaInput = new JTextField(menadzer.getStepenObrazovanja());

        this.ulogaLabel = new JLabel("Uloga:");
        this.ulogaInput = new JComboBox<>(uloge.toArray(new Uloga[0]));
        this.ulogaInput.setSelectedItem(menadzer.getUloga());

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
        this.formaPanel.add(ulogaLabel);
        this.formaPanel.add(ulogaInput);

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

    public JComboBox<Uloga> getUlogaInput() {
        return ulogaInput;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }
}