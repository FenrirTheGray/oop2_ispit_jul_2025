package rs.ac.singidunum.novisad.ui.views;

import rs.ac.singidunum.novisad.model.ElektricniUredjaj;
import rs.ac.singidunum.novisad.ui.modals.elektricniUredjaj.DodajElektricniUredjajModal;
import rs.ac.singidunum.novisad.ui.modals.elektricniUredjaj.IzmeniElektricniUredjajModal;
import rs.ac.singidunum.novisad.ui.tableModels.ElektricniUredjajTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Date;

public class ElektricniUredjajView extends JPanel {
    @Serial
    private static final long serialVersionUID = 3708749176790722870L;

    private ArrayList<ElektricniUredjaj> elektricniUredjaji;

    private DefaultListModel<ElektricniUredjaj> elektricniUredjajListModel;
    private ElektricniUredjajTableModel elektricniUredjajTableModel;

    private JTable elektricniUredjajiTable;

    private JButton dodajButton;
    private JButton izmeniButton;
    private JButton ukloniButton;

    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public ElektricniUredjajView(ArrayList<ElektricniUredjaj> elektricniUredjaji) {
        super();
        this.elektricniUredjaji = elektricniUredjaji;
        this.setLayout(new BorderLayout());

        this.elektricniUredjajListModel = new DefaultListModel<>();
        this.elektricniUredjajTableModel = new ElektricniUredjajTableModel(elektricniUredjaji);

        this.elektricniUredjajiTable = new JTable(elektricniUredjajTableModel);
        this.elektricniUredjajiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.scrollPane = new JScrollPane(elektricniUredjajiTable);

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.dodajButton = new JButton("Dodaj");
        this.izmeniButton = new JButton("Izmeni");
        this.ukloniButton = new JButton("Ukloni");
    }

    public void init() {
        buttonPanel.add(dodajButton);
        buttonPanel.add(izmeniButton);
        buttonPanel.add(ukloniButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        dodajButton.addActionListener(e -> {
            DodajElektricniUredjajModal dodajElektricniUredjajModal = new DodajElektricniUredjajModal();

            dodajElektricniUredjajModal.getDodajButton().addActionListener(dodajButtonEvent -> {
                String naziv = dodajElektricniUredjajModal.getNazivInput().getText().trim();
                String zemljaPorekla = dodajElektricniUredjajModal.getZemljaPoreklaInput().getText().trim();
                String model = dodajElektricniUredjajModal.getModelInput().getText().trim();

                double cena = ((Number) dodajElektricniUredjajModal.getCenaInput().getValue()).doubleValue();
                Date datumProizvodnje = (Date) dodajElektricniUredjajModal.getDatumProizvodjenInput().getValue();
                float duzina = ((Number) dodajElektricniUredjajModal.getDuzinaInput().getValue()).floatValue();
                float sirina = ((Number) dodajElektricniUredjajModal.getSirinaInput().getValue()).floatValue();
                float visina = ((Number) dodajElektricniUredjajModal.getVisinaInput().getValue()).floatValue();
                int radniNapon = ((Number) dodajElektricniUredjajModal.getRadniNaponInput().getValue()).intValue();
                int nominalnaSnaga = ((Number) dodajElektricniUredjajModal.getNominalnaSnagaInput().getValue()).intValue();

                if (naziv.isEmpty() || zemljaPorekla.isEmpty() || model.isEmpty() || datumProizvodnje == null) {
                    JOptionPane.showMessageDialog(dodajElektricniUredjajModal,
                            "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    ElektricniUredjaj noviElektricniUredjaj = new ElektricniUredjaj(naziv, cena, zemljaPorekla,
                            datumProizvodnje, model, duzina, sirina, visina, radniNapon, nominalnaSnaga);
                    elektricniUredjajTableModel.dodajElektricniUredjaj(noviElektricniUredjaj);
                    dodajElektricniUredjajModal.dispose();
                }
            });

            dodajElektricniUredjajModal.init();
        });

        izmeniButton.addActionListener(e -> {
            int selectedRow = elektricniUredjajiTable.getSelectedRow();
            if (selectedRow >= 0) {
                ElektricniUredjaj selectedElektricniUredjaj = elektricniUredjajTableModel.getElektricniUredjaj(selectedRow);

                IzmeniElektricniUredjajModal izmeniElektricniUredjajModal = new IzmeniElektricniUredjajModal(selectedElektricniUredjaj);

                izmeniElektricniUredjajModal.getIzmeniButton().addActionListener(izmeniButtonEvent -> {
                    String naziv = izmeniElektricniUredjajModal.getNazivInput().getText().trim();
                    String zemljaPorekla = izmeniElektricniUredjajModal.getZemljaPoreklaInput().getText().trim();
                    String model = izmeniElektricniUredjajModal.getModelInput().getText().trim();

                    double cena = ((Number) izmeniElektricniUredjajModal.getCenaInput().getValue()).doubleValue();
                    Date datumProizvodnje = (Date) izmeniElektricniUredjajModal.getDatumProizvodjenInput().getValue();
                    float duzina = ((Number) izmeniElektricniUredjajModal.getDuzinaInput().getValue()).floatValue();
                    float sirina = ((Number) izmeniElektricniUredjajModal.getSirinaInput().getValue()).floatValue();
                    float visina = ((Number) izmeniElektricniUredjajModal.getVisinaInput().getValue()).floatValue();
                    int radniNapon = ((Number) izmeniElektricniUredjajModal.getRadniNaponInput().getValue()).intValue();
                    int nominalnaSnaga = ((Number) izmeniElektricniUredjajModal.getNominalnaSnagaInput().getValue()).intValue();

                    if (naziv.isEmpty() || zemljaPorekla.isEmpty() || model.isEmpty() || datumProizvodnje == null) {
                        JOptionPane.showMessageDialog(izmeniElektricniUredjajModal,
                                "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedElektricniUredjaj.setNaziv(naziv);
                        selectedElektricniUredjaj.setCena(cena);
                        selectedElektricniUredjaj.setZemljaPorekla(zemljaPorekla);
                        selectedElektricniUredjaj.setDatumProizvodnje(datumProizvodnje);
                        selectedElektricniUredjaj.setModel(model);
                        selectedElektricniUredjaj.setDuzina(duzina);
                        selectedElektricniUredjaj.setSirina(sirina);
                        selectedElektricniUredjaj.setVisina(visina);
                        selectedElektricniUredjaj.setRadniNapon(radniNapon);
                        selectedElektricniUredjaj.setNominalnaSnaga(nominalnaSnaga);

                        elektricniUredjajTableModel.fireTableRowsUpdated(selectedRow, selectedRow);

                        izmeniElektricniUredjajModal.dispose();
                    }
                });

                izmeniElektricniUredjajModal.init();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite električni uređaj za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });

        ukloniButton.addActionListener(e -> {
            int selectedRow = elektricniUredjajiTable.getSelectedRow();
            if (selectedRow >= 0) {
                ElektricniUredjaj selectedElektricniUredjaj = elektricniUredjajTableModel.getElektricniUredjaj(selectedRow);

                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da želite da uklonite električni uređaj '" +
                                selectedElektricniUredjaj.getNaziv() + "'?",
                        "Potvrda brisanja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    elektricniUredjajTableModel.ukloniElektricniUredjaj(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite električni uređaj za uklanjanje.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<ElektricniUredjaj> getElektricniUredjaji() {
        return elektricniUredjaji;
    }

    public DefaultListModel<ElektricniUredjaj> getElektricniUredjajListModel() {
        return elektricniUredjajListModel;
    }

    public ElektricniUredjajTableModel getElektricniUredjajTableModel() {
        return elektricniUredjajTableModel;
    }

    public JTable getElektricniUredjajiTable() {
        return elektricniUredjajiTable;
    }

    public JButton getDodajButton() {
        return dodajButton;
    }

    public JButton getIzmeniButton() {
        return izmeniButton;
    }

    public JButton getUkloniButton() {
        return ukloniButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}