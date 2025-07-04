package rs.ac.singidunum.novisad.ui.modals.uloga;

import rs.ac.singidunum.novisad.model.Uloga;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class IzmeniUloguModal extends JDialog {

    @Serial
    private static final long serialVersionUID = 8475629384710583947L;
    private JPanel formaPanel;
    private JLabel imeUlogeLabel;
    private JTextField imeUlogeInput;
    private JLabel opisLabel;
    private JTextField opisInput;

    private JPanel buttonPanel;
    private JButton izmeniButton;
    private JButton odustaniButton;

    private Uloga uloga;

    public IzmeniUloguModal(Uloga uloga) {
        super();
        this.uloga = uloga;
        this.setLayout(new BorderLayout());
        this.setTitle("Izmeni Ulogu");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeUlogeLabel = new JLabel("Ime Uloge:");
        this.imeUlogeInput = new JTextField(uloga.getImeUloge());
        this.opisLabel = new JLabel("Opis Uloge:");
        this.opisInput = new JTextField(uloga.getOpisUloge());

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.izmeniButton = new JButton("Izmeni");
        this.odustaniButton = new JButton("Odustani");
    }

    public void init() {
        this.formaPanel.add(imeUlogeLabel);
        this.formaPanel.add(imeUlogeInput);
        this.formaPanel.add(opisLabel);
        this.formaPanel.add(opisInput);

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

    public JTextField getImeUlogeInput() {
        return imeUlogeInput;
    }

    public JTextField getOpisInput() {
        return opisInput;
    }

    public Uloga getUloga() {
        return uloga;
    }
}