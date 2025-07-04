package rs.ac.singidunum.novisad.ui.modals.uloga;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class DodajUloguModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 5629384710947382847L;

    private JPanel formaPanel;
    private JLabel imeUlogeLabel;
    private JTextField imeUlogeInput;
    private JLabel opisLabel;
    private JTextField opisInput;

    private JPanel buttonPanel;
    private JButton dodajButton;
    private JButton odustaniButton;

    public DodajUloguModal() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Dodaj Novu Ulogu");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.imeUlogeLabel = new JLabel("Ime Uloge:");
        this.imeUlogeInput = new JTextField();
        this.opisLabel = new JLabel("Opis Uloge:");
        this.opisInput = new JTextField();

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.dodajButton = new JButton("Dodaj");
        this.odustaniButton = new JButton("Odustani");
    }

    public void init() {
        this.formaPanel.add(imeUlogeLabel);
        this.formaPanel.add(imeUlogeInput);
        this.formaPanel.add(opisLabel);
        this.formaPanel.add(opisInput);

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

    public JTextField getImeUlogeInput() {
        return imeUlogeInput;
    }

    public JTextField getOpisInput() {
        return opisInput;
    }
}
