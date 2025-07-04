package rs.ac.singidunum.novisad.ui.views;

import rs.ac.singidunum.novisad.model.KvarljivaRoba;
import rs.ac.singidunum.novisad.ui.modals.kvarljivaRoba.DodajKvarljivuRobuModal;
import rs.ac.singidunum.novisad.ui.modals.kvarljivaRoba.IzmeniKvarljivuRobuModal;
import rs.ac.singidunum.novisad.ui.tableModels.KvarljivaRobaTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Date;

public class KvarljivaRobaView extends JPanel {
    @Serial
    private static final long serialVersionUID = 3708749176790722870L;

    private ArrayList<KvarljivaRoba> kvarljivaRoba;

    private DefaultListModel<KvarljivaRoba> kvarljivaRobaListModel;
    private KvarljivaRobaTableModel kvarljivaRobaTableModel;

    private JTable kvarljivaRobaTable;

    private JButton dodajButton;
    private JButton izmeniButton;
    private JButton ukloniButton;

    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public KvarljivaRobaView(ArrayList<KvarljivaRoba> kvarljivaRoba) {
        super();
        this.kvarljivaRoba = kvarljivaRoba;
        this.setLayout(new BorderLayout());

        this.kvarljivaRobaListModel = new DefaultListModel<>();
        this.kvarljivaRobaTableModel = new KvarljivaRobaTableModel(kvarljivaRoba);

        this.kvarljivaRobaTable = new JTable(kvarljivaRobaTableModel);
        this.kvarljivaRobaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.scrollPane = new JScrollPane(kvarljivaRobaTable);

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
            DodajKvarljivuRobuModal dodajKvarljivuRobuModal = new DodajKvarljivuRobuModal();

            dodajKvarljivuRobuModal.getDodajButton().addActionListener(dodajButtonEvent -> {
                String naziv = dodajKvarljivuRobuModal.getNazivInput().getText().trim();
                String zemljaPorekla = dodajKvarljivuRobuModal.getZemljaPoreklaInput().getText().trim();
                String model = dodajKvarljivuRobuModal.getModelInput().getText().trim();
                String tipAmbalaze = dodajKvarljivuRobuModal.getTipAmbalazeInput().getText().trim();

                double cena = ((Number) dodajKvarljivuRobuModal.getCenaInput().getValue()).doubleValue();
                Date datumProizvodnje = (Date) dodajKvarljivuRobuModal.getDatumProizvodjenInput().getValue();
                Date rokTrajanja = (Date) dodajKvarljivuRobuModal.getRokTrajanjaInput().getValue();

                if (naziv.isEmpty() || zemljaPorekla.isEmpty() || model.isEmpty() || tipAmbalaze.isEmpty() ||
                        datumProizvodnje == null || rokTrajanja == null) {
                    JOptionPane.showMessageDialog(dodajKvarljivuRobuModal,
                            "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    KvarljivaRoba novaKvarljivaRoba = new KvarljivaRoba(naziv, cena, zemljaPorekla,
                            datumProizvodnje, model, rokTrajanja, tipAmbalaze);
                    kvarljivaRobaTableModel.dodajKvarljivuRobu(novaKvarljivaRoba);
                    dodajKvarljivuRobuModal.dispose();
                }
            });

            dodajKvarljivuRobuModal.init();
        });

        izmeniButton.addActionListener(e -> {
            int selectedRow = kvarljivaRobaTable.getSelectedRow();
            if (selectedRow >= 0) {
                KvarljivaRoba selectedKvarljivaRoba = kvarljivaRobaTableModel.getKvarljivaRoba(selectedRow);

                IzmeniKvarljivuRobuModal izmeniKvarljivuRobuModal = new IzmeniKvarljivuRobuModal(selectedKvarljivaRoba);

                izmeniKvarljivuRobuModal.getIzmeniButton().addActionListener(izmeniButtonEvent -> {
                    String naziv = izmeniKvarljivuRobuModal.getNazivInput().getText().trim();
                    String zemljaPorekla = izmeniKvarljivuRobuModal.getZemljaPoreklaInput().getText().trim();
                    String model = izmeniKvarljivuRobuModal.getModelInput().getText().trim();
                    String tipAmbalaze = izmeniKvarljivuRobuModal.getTipAmbalazeInput().getText().trim();

                    double cena = ((Number) izmeniKvarljivuRobuModal.getCenaInput().getValue()).doubleValue();
                    Date datumProizvodnje = (Date) izmeniKvarljivuRobuModal.getDatumProizvodjenInput().getValue();
                    Date rokTrajanja = (Date) izmeniKvarljivuRobuModal.getRokTrajanjaInput().getValue();

                    if (naziv.isEmpty() || zemljaPorekla.isEmpty() || model.isEmpty() || tipAmbalaze.isEmpty() ||
                            datumProizvodnje == null || rokTrajanja == null) {
                        JOptionPane.showMessageDialog(izmeniKvarljivuRobuModal,
                                "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedKvarljivaRoba.setNaziv(naziv);
                        selectedKvarljivaRoba.setCena(cena);
                        selectedKvarljivaRoba.setZemljaPorekla(zemljaPorekla);
                        selectedKvarljivaRoba.setDatumProizvodnje(datumProizvodnje);
                        selectedKvarljivaRoba.setModel(model);
                        selectedKvarljivaRoba.setRokTrajanja(rokTrajanja);
                        selectedKvarljivaRoba.setTipAmbalaze(tipAmbalaze);

                        kvarljivaRobaTableModel.fireTableRowsUpdated(selectedRow, selectedRow);

                        izmeniKvarljivuRobuModal.dispose();
                    }
                });

                izmeniKvarljivuRobuModal.init();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite kvarljivu robu za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });

        ukloniButton.addActionListener(e -> {
            int selectedRow = kvarljivaRobaTable.getSelectedRow();
            if (selectedRow >= 0) {
                KvarljivaRoba selectedKvarljivaRoba = kvarljivaRobaTableModel.getKvarljivaRoba(selectedRow);

                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da želite da uklonite kvarljivu robu '" +
                                selectedKvarljivaRoba.getNaziv() + "'?",
                        "Potvrda brisanja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    kvarljivaRobaTableModel.ukloniKvarljivuRobu(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite kvarljivu robu za uklanjanje.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<KvarljivaRoba> getKvarljivaRoba() {
        return kvarljivaRoba;
    }

    public DefaultListModel<KvarljivaRoba> getKvarljivaRobaListModel() {
        return kvarljivaRobaListModel;
    }

    public KvarljivaRobaTableModel getKvarljivaRobaTableModel() {
        return kvarljivaRobaTableModel;
    }

    public JTable getKvarljivaRobaTable() {
        return kvarljivaRobaTable;
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