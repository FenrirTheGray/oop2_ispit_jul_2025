package rs.ac.singidunum.novisad.ui.views;

import rs.ac.singidunum.novisad.model.Menadzer;
import rs.ac.singidunum.novisad.model.Prodavac;
import rs.ac.singidunum.novisad.ui.modals.prodavac.DodajProdavcaModal;
import rs.ac.singidunum.novisad.ui.modals.prodavac.IzmeniProdavcaModal;
import rs.ac.singidunum.novisad.ui.tableModels.ProdavacTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.Serial;

public class ProdavacView extends JPanel {

    @Serial
    private static final long serialVersionUID = 4829156743892017456L;

    private ArrayList<Prodavac> prodavci;
    private ArrayList<Menadzer> menadzeri;

    private DefaultListModel<Prodavac> prodavacDefaultListModel;
    private ProdavacTableModel prodavacTableModel;

    private JTable prodavciTable;

    private JButton dodajButton;
    private JButton izmeniButton;
    private JButton ukloniButton;

    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public ProdavacView(ArrayList<Prodavac> prodavci, ArrayList<Menadzer> menadzeri) {
        super(new BorderLayout());

        this.menadzeri = menadzeri;
        this.prodavci = prodavci;

        this.prodavacDefaultListModel = new DefaultListModel<>();
        this.prodavacTableModel = new ProdavacTableModel(prodavci);

        this.prodavciTable = new JTable(prodavacTableModel);
        prodavciTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.dodajButton = new JButton("Dodaj");
        this.izmeniButton = new JButton("Izmeni");
        this.ukloniButton = new JButton("Ukloni");

        this.scrollPane = new JScrollPane(prodavciTable);
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    public void initProdavacView() {
        buttonPanel.add(dodajButton);
        buttonPanel.add(izmeniButton);
        buttonPanel.add(ukloniButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        dodajButton.addActionListener(e -> {
            DodajProdavcaModal dodajProdavcaModal = new DodajProdavcaModal(menadzeri);

            dodajProdavcaModal.getDodajButton().addActionListener(dodajButtonEvent -> {
                String ime = dodajProdavcaModal.getImeInput().getText().trim();
                String prezime = dodajProdavcaModal.getPrezimeInput().getText().trim();
                String zvanje = dodajProdavcaModal.getZvanjeInput().getText().trim();
                String stepenObrazovanja = dodajProdavcaModal.getStepenObrazovanjaInput().getText().trim();
                String radnoMesto = dodajProdavcaModal.getRadnoMestoInput().getText().trim();

                Menadzer selectedMenadzer = (Menadzer) dodajProdavcaModal.getNadredjeniInput().getSelectedItem();

                double plata = ((Number) dodajProdavcaModal.getPlataInput().getValue()).doubleValue();

                if (ime.isEmpty() || prezime.isEmpty() || zvanje.isEmpty() ||
                        stepenObrazovanja.isEmpty() || radnoMesto.isEmpty() || selectedMenadzer == null) {
                    JOptionPane.showMessageDialog(dodajProdavcaModal,
                            "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    Prodavac noviProdavac = new Prodavac(ime, prezime, plata, zvanje, stepenObrazovanja, selectedMenadzer, radnoMesto);
                    prodavacTableModel.dodajProdavca(noviProdavac);
                    dodajProdavcaModal.dispose();
                }
            });

            dodajProdavcaModal.init();
        });

        izmeniButton.addActionListener(e -> {
            int selectedRow = prodavciTable.getSelectedRow();
            if (selectedRow >= 0) {
                Prodavac selectedProdavac = prodavacTableModel.getProdavac(selectedRow);

                IzmeniProdavcaModal izmeniProdavcaModal = new IzmeniProdavcaModal(selectedProdavac, menadzeri);

                izmeniProdavcaModal.getIzmeniButton().addActionListener(izmeniButtonEvent -> {
                    String ime = izmeniProdavcaModal.getImeInput().getText().trim();
                    String prezime = izmeniProdavcaModal.getPrezimeInput().getText().trim();
                    String zvanje = izmeniProdavcaModal.getZvanjeInput().getText().trim();
                    String stepenObrazovanja = izmeniProdavcaModal.getStepenObrazovanjaInput().getText().trim();
                    String radnoMesto = izmeniProdavcaModal.getRadnoMestoInput().getText().trim();

                    Menadzer selectedMenadzer = (Menadzer) izmeniProdavcaModal.getNadredjeniInput().getSelectedItem();

                    double plata = ((Number) izmeniProdavcaModal.getPlataInput().getValue()).doubleValue();

                    if (ime.isEmpty() || prezime.isEmpty() || zvanje.isEmpty() ||
                            stepenObrazovanja.isEmpty() || radnoMesto.isEmpty() || selectedMenadzer == null) {
                        JOptionPane.showMessageDialog(izmeniProdavcaModal,
                                "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedProdavac.setIme(ime);
                        selectedProdavac.setPrezime(prezime);
                        selectedProdavac.setZvanje(zvanje);
                        selectedProdavac.setStepenObrazovanja(stepenObrazovanja);
                        selectedProdavac.setRadnoMesto(radnoMesto);
                        selectedProdavac.setNadredjeni(selectedMenadzer);
                        selectedProdavac.setPlata(plata);

                        prodavacTableModel.fireTableRowsUpdated(selectedRow, selectedRow);

                        izmeniProdavcaModal.dispose();
                    }
                });

                izmeniProdavcaModal.init();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite prodavca za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });

        ukloniButton.addActionListener(e -> {
            int selectedRow = prodavciTable.getSelectedRow();
            if (selectedRow >= 0) {
                Prodavac selectedProdavac = prodavacTableModel.getProdavac(selectedRow);

                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da želite da uklonite prodavca '" +
                                selectedProdavac.getIme() + " " + selectedProdavac.getPrezime() + "'?",
                        "Potvrda brisanja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    prodavacTableModel.ukloniProdavca(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Molimo izaberite prodavca za uklanjanje.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<Prodavac> getProdavci() {
        return prodavci;
    }

    public ArrayList<Menadzer> getMenadzeri() {
        return menadzeri;
    }

    public DefaultListModel<Prodavac> getProdavacDefaultListModel() {
        return prodavacDefaultListModel;
    }

    public ProdavacTableModel getProdavacTableModel() {
        return prodavacTableModel;
    }

    public JTable getProdavciTable() {
        return prodavciTable;
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