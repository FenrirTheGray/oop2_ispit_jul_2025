package rs.ac.singidunum.novisad.ui.views;

import rs.ac.singidunum.novisad.model.Menadzer;
import rs.ac.singidunum.novisad.model.Uloga;
import rs.ac.singidunum.novisad.ui.modals.menadzer.DodajMenadzeraModal;
import rs.ac.singidunum.novisad.ui.modals.menadzer.IzmeniMenadzeraModal;
import rs.ac.singidunum.novisad.ui.tableModels.MenadzerTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class MenadzerView extends JPanel {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 3708749176790722870L;

    private ArrayList<Menadzer> menadzeri;
    private ArrayList<Uloga> uloge;

    private DefaultListModel<Menadzer> menadzerListModel;
    private MenadzerTableModel menadzerTableModel;

    private JTable menadzeriTable;

    private JButton dodajButton;
    private JButton izmeniButton;
    private JButton ukloniButton;

    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public MenadzerView(ArrayList<Menadzer> menadzeri, ArrayList<Uloga> uloge) {
        super(new BorderLayout());

        this.menadzeri = menadzeri;
        this.uloge = uloge;

        this.menadzerListModel = new DefaultListModel<>();
        this.menadzerTableModel = new MenadzerTableModel(menadzeri);
        this.menadzeriTable = new JTable(menadzerTableModel);
        menadzeriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.dodajButton = new JButton("Dodaj Menadzera");
        this.izmeniButton = new JButton("Izmeni Menadzera");
        this.ukloniButton = new JButton("Ukloni Menadzera");

        this.scrollPane = new JScrollPane(menadzeriTable);
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    public void initMenadzerView() {
        buttonPanel.add(dodajButton);
        buttonPanel.add(izmeniButton);
        buttonPanel.add(ukloniButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        dodajButton.addActionListener(e -> {
            DodajMenadzeraModal dodajMenadzeraModal = new DodajMenadzeraModal(uloge);

            dodajMenadzeraModal.getDodajButton().addActionListener(dodajButtonEvent -> {
                String ime = dodajMenadzeraModal.getImeInput().getText().trim();
                String prezime = dodajMenadzeraModal.getPrezimeInput().getText().trim();
                String zvanje = dodajMenadzeraModal.getZvanjeInput().getText().trim();
                String stepenObrazovanja = dodajMenadzeraModal.getStepenObrazovanjaInput().getText().trim();

                Uloga selectedUloga = (Uloga) dodajMenadzeraModal.getUlogaInput().getSelectedItem();

                double plata = ((Number) dodajMenadzeraModal.getPlataInput().getValue()).doubleValue();

                if (ime.isEmpty() || prezime.isEmpty() || zvanje.isEmpty() ||
                        stepenObrazovanja.isEmpty() || selectedUloga == null) {
                    JOptionPane.showMessageDialog(dodajMenadzeraModal,
                            "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    Menadzer noviMenadzer = new Menadzer(ime, prezime, plata, zvanje, stepenObrazovanja, selectedUloga);
                    menadzerTableModel.dodajMenadzera(noviMenadzer);
                    dodajMenadzeraModal.dispose();
                }
            });

            dodajMenadzeraModal.init();
        });

        izmeniButton.addActionListener(e -> {
            int selectedRow = menadzeriTable.getSelectedRow();
            if (selectedRow >= 0) {
                Menadzer selectedMenadzer = menadzerTableModel.getMenadzer(selectedRow);

                IzmeniMenadzeraModal izmeniMenadzeraModal = new IzmeniMenadzeraModal(selectedMenadzer, uloge);

                izmeniMenadzeraModal.getIzmeniButton().addActionListener(izmeniButtonEvent -> {
                    String ime = izmeniMenadzeraModal.getImeInput().getText().trim();
                    String prezime = izmeniMenadzeraModal.getPrezimeInput().getText().trim();
                    String zvanje = izmeniMenadzeraModal.getZvanjeInput().getText().trim();
                    String stepenObrazovanja = izmeniMenadzeraModal.getStepenObrazovanjaInput().getText().trim();

                    Uloga selectedUloga = (Uloga) izmeniMenadzeraModal.getUlogaInput().getSelectedItem();

                    double plata = ((Number) izmeniMenadzeraModal.getPlataInput().getValue()).doubleValue();

                    if (ime.isEmpty() || prezime.isEmpty() || zvanje.isEmpty() ||
                            stepenObrazovanja.isEmpty() || selectedUloga == null) {
                        JOptionPane.showMessageDialog(izmeniMenadzeraModal,
                                "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedMenadzer.setIme(ime);
                        selectedMenadzer.setPrezime(prezime);
                        selectedMenadzer.setZvanje(zvanje);
                        selectedMenadzer.setStepenObrazovanja(stepenObrazovanja);
                        selectedMenadzer.setUloga(selectedUloga);
                        selectedMenadzer.setPlata(plata);

                        menadzerTableModel.fireTableRowsUpdated(selectedRow, selectedRow);

                        izmeniMenadzeraModal.dispose();
                    }
                });

                izmeniMenadzeraModal.init();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite menadzera za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });

        ukloniButton.addActionListener(e -> {
            int selectedRow = menadzeriTable.getSelectedRow();
            if (selectedRow >= 0) {
                Menadzer selectedMenadzer = menadzerTableModel.getMenadzer(selectedRow);

                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da želite da uklonite menadzera '" +
                                selectedMenadzer.getIme() + " " + selectedMenadzer.getPrezime() + "'?",
                        "Potvrda brisanja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    menadzerTableModel.ukoloniMenadzera(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite menadzera za uklanjanje.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<Menadzer> getMenadzeri() {
        return menadzeri;
    }

    public ArrayList<Uloga> getUloge() {
        return uloge;
    }

    public DefaultListModel<Menadzer> getMenadzerListModel() {
        return menadzerListModel;
    }

    public MenadzerTableModel getMenadzerTableModel() {
        return menadzerTableModel;
    }

    public JTable getMenadzeriTable() {
        return menadzeriTable;
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