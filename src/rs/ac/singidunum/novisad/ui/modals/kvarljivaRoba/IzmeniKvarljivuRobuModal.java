package rs.ac.singidunum.novisad.ui.modals.kvarljivaRoba;

import rs.ac.singidunum.novisad.model.KvarljivaRoba;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class IzmeniKvarljivuRobuModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 2938471650293847516L;

    private JPanel formaPanel;

    private JLabel nazivLabel;
    private JTextField nazivInput;

    private JLabel cenaLabel;
    private JSpinner cenaInput;

    private JLabel zemljaPoreklaLabel;
    private JTextField zemljaPoreklaInput;

    private JLabel datumProizvodjenLabel;
    private JSpinner datumProizvodjenInput;

    private JLabel modelLabel;
    private JTextField modelInput;

    private JLabel rokTrajanjaLabel;
    private JSpinner rokTrajanjaInput;

    private JLabel tipAmbalazeLabel;
    private JTextField tipAmbalazeInput;

    private JPanel buttonPanel;
    private JButton izmeniButton;
    private JButton odustaniButton;

    private KvarljivaRoba kvarljivaRoba;

    public IzmeniKvarljivuRobuModal(KvarljivaRoba kvarljivaRoba) {
        super();
        this.kvarljivaRoba = kvarljivaRoba;
        this.setLayout(new BorderLayout());
        this.setTitle("Izmeni Kvarljivu Robu");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.nazivLabel = new JLabel("Naziv:");
        this.nazivInput = new JTextField(kvarljivaRoba.getNaziv());

        this.cenaLabel = new JLabel("Cena:");
        this.cenaInput = new JSpinner(new SpinnerNumberModel(kvarljivaRoba.getCena(), 0.0, Double.MAX_VALUE, 100.0));

        this.zemljaPoreklaLabel = new JLabel("Zemlja Porekla:");
        this.zemljaPoreklaInput = new JTextField(kvarljivaRoba.getZemljaPorekla());

        this.datumProizvodjenLabel = new JLabel("Datum Proizvodnje:");
        this.datumProizvodjenInput = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datumProizvodjenInput, "dd.MM.yyyy");
        this.datumProizvodjenInput.setEditor(dateEditor);
        this.datumProizvodjenInput.setValue(kvarljivaRoba.getDatumProizvodnje());

        this.modelLabel = new JLabel("Model:");
        this.modelInput = new JTextField(kvarljivaRoba.getModel());

        this.rokTrajanjaLabel = new JLabel("Rok Trajanja:");
        this.rokTrajanjaInput = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor rokTrajanjaDateEditor = new JSpinner.DateEditor(rokTrajanjaInput, "dd.MM.yyyy");
        this.rokTrajanjaInput.setEditor(rokTrajanjaDateEditor);
        this.rokTrajanjaInput.setValue(kvarljivaRoba.getRokTrajanja());

        this.tipAmbalazeLabel = new JLabel("Tip Ambalaze:");
        this.tipAmbalazeInput = new JTextField(kvarljivaRoba.getTipAmbalaze());

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.izmeniButton = new JButton("Izmeni");
        this.odustaniButton = new JButton("Odustani");
    }

    public void init() {
        this.formaPanel.add(nazivLabel);
        this.formaPanel.add(nazivInput);
        this.formaPanel.add(cenaLabel);
        this.formaPanel.add(cenaInput);
        this.formaPanel.add(zemljaPoreklaLabel);
        this.formaPanel.add(zemljaPoreklaInput);
        this.formaPanel.add(datumProizvodjenLabel);
        this.formaPanel.add(datumProizvodjenInput);
        this.formaPanel.add(modelLabel);
        this.formaPanel.add(modelInput);
        this.formaPanel.add(rokTrajanjaLabel);
        this.formaPanel.add(rokTrajanjaInput);
        this.formaPanel.add(tipAmbalazeLabel);
        this.formaPanel.add(tipAmbalazeInput);

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

    public JTextField getNazivInput() {
        return nazivInput;
    }

    public JSpinner getCenaInput() {
        return cenaInput;
    }

    public JTextField getZemljaPoreklaInput() {
        return zemljaPoreklaInput;
    }

    public JSpinner getDatumProizvodjenInput() {
        return datumProizvodjenInput;
    }

    public JTextField getModelInput() {
        return modelInput;
    }

    public JSpinner getRokTrajanjaInput() {
        return rokTrajanjaInput;
    }

    public JTextField getTipAmbalazeInput() {
        return tipAmbalazeInput;
    }

    public KvarljivaRoba getKvarljivaRoba() {
        return kvarljivaRoba;
    }
}