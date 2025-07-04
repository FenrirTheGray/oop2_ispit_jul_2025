package rs.ac.singidunum.novisad.ui.modals.elektricniUredjaj;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class DodajElektricniUredjajModal extends JDialog {
    @Serial
    private static final long serialVersionUID = 7194836529384710627L;

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

    private JLabel duzinaLabel;
    private JSpinner duzinaInput;

    private JLabel sirinaLabel;
    private JSpinner sirinaInput;

    private JLabel visinaLabel;
    private JSpinner visinaInput;

    private JLabel radniNaponLabel;
    private JSpinner radniNaponInput;

    private JLabel nominalnaSnagaLabel;
    private JSpinner nominalnaSnagaInput;

    private JPanel buttonPanel;
    private JButton dodajButton;
    private JButton odustaniButton;

    public DodajElektricniUredjajModal() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Dodaj Novi Električni Uređaj");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.formaPanel = new JPanel(new GridLayout(10, 2, 5, 5));
        this.formaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.nazivLabel = new JLabel("Naziv:");
        this.nazivInput = new JTextField();

        this.cenaLabel = new JLabel("Cena:");
        this.cenaInput = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 100.0));

        this.zemljaPoreklaLabel = new JLabel("Zemlja Porekla:");
        this.zemljaPoreklaInput = new JTextField();

        this.datumProizvodjenLabel = new JLabel("Datum Proizvodnje:");
        this.datumProizvodjenInput = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datumProizvodjenInput, "dd.MM.yyyy");
        this.datumProizvodjenInput.setEditor(dateEditor);

        this.modelLabel = new JLabel("Model:");
        this.modelInput = new JTextField();

        this.duzinaLabel = new JLabel("Dužina (cm):");
        this.duzinaInput = new JSpinner(new SpinnerNumberModel(0.0f, 0.0f, Float.MAX_VALUE, 1.0f));

        this.sirinaLabel = new JLabel("Širina (cm):");
        this.sirinaInput = new JSpinner(new SpinnerNumberModel(0.0f, 0.0f, Float.MAX_VALUE, 1.0f));

        this.visinaLabel = new JLabel("Visina (cm):");
        this.visinaInput = new JSpinner(new SpinnerNumberModel(0.0f, 0.0f, Float.MAX_VALUE, 1.0f));

        this.radniNaponLabel = new JLabel("Radni Napon (V):");
        this.radniNaponInput = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

        this.nominalnaSnagaLabel = new JLabel("Nominalna Snaga (W):");
        this.nominalnaSnagaInput = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.dodajButton = new JButton("Dodaj");
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
        this.formaPanel.add(duzinaLabel);
        this.formaPanel.add(duzinaInput);
        this.formaPanel.add(sirinaLabel);
        this.formaPanel.add(sirinaInput);
        this.formaPanel.add(visinaLabel);
        this.formaPanel.add(visinaInput);
        this.formaPanel.add(radniNaponLabel);
        this.formaPanel.add(radniNaponInput);
        this.formaPanel.add(nominalnaSnagaLabel);
        this.formaPanel.add(nominalnaSnagaInput);

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

    public JSpinner getDuzinaInput() {
        return duzinaInput;
    }

    public JSpinner getSirinaInput() {
        return sirinaInput;
    }

    public JSpinner getVisinaInput() {
        return visinaInput;
    }

    public JSpinner getRadniNaponInput() {
        return radniNaponInput;
    }

    public JSpinner getNominalnaSnagaInput() {
        return nominalnaSnagaInput;
    }
}