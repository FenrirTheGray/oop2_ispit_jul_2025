package rs.ac.singidunum.novisad.ui.views;

import rs.ac.singidunum.novisad.model.Uloga;
import rs.ac.singidunum.novisad.ui.modals.uloga.DodajUloguModal;
import rs.ac.singidunum.novisad.ui.modals.uloga.IzmeniUloguModal;
import rs.ac.singidunum.novisad.ui.tableModels.UlogaTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.Serial;

public class UlogaView extends JPanel {

    @Serial
    private static final long serialVersionUID = 4829156743892017456L;
    private ArrayList<Uloga> uloge;

    private DefaultListModel<Uloga> ulogaListModel;
    private UlogaTableModel ulogaTableModel;

    private JTable ulogeTable;

    private JButton dodajButton;
    private JButton izmeniButton;
    private JButton ukloniButton;

    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public UlogaView(ArrayList<Uloga> uloge) {
        super(new BorderLayout());

        this.uloge = uloge;

        this.ulogaListModel = new DefaultListModel<>();
        this.ulogaTableModel = new UlogaTableModel(uloge);

        this.ulogeTable = new JTable(ulogaTableModel);
        this.ulogeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.dodajButton = new JButton("Dodaj");
        this.izmeniButton = new JButton("Izmeni");
        this.ukloniButton = new JButton("Ukloni");

        this.scrollPane = new JScrollPane(ulogeTable);
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    public void initUlogaView() {
        buttonPanel.add(dodajButton);
        buttonPanel.add(izmeniButton);
        buttonPanel.add(ukloniButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        dodajButton.addActionListener(e -> {
            DodajUloguModal dodajUloguModal = new DodajUloguModal();

            dodajUloguModal.getDodajButton().addActionListener(dodajButtonEvent -> {
                String imeUloge = dodajUloguModal.getImeUlogeInput().getText().trim();
                String opisUloge = dodajUloguModal.getOpisInput().getText().trim();

                if (imeUloge.isEmpty() || opisUloge.isEmpty()) {
                    JOptionPane.showMessageDialog(dodajUloguModal, "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    Uloga novaUloga = new Uloga(imeUloge, opisUloge);
                    ulogaTableModel.dodajUlogu(novaUloga);
                    dodajUloguModal.dispose();
                }
            });

            dodajUloguModal.init();
        });

        izmeniButton.addActionListener(e -> {
            int selectedRow = ulogeTable.getSelectedRow();
            if (selectedRow >= 0) {
                Uloga selectedUloga = ulogaTableModel.getUloga(selectedRow);
                IzmeniUloguModal izmeniUloguModal = new IzmeniUloguModal(selectedUloga);

                izmeniUloguModal.getIzmeniButton().addActionListener(izmeniButtonEvent -> {
                    String imeUloge = izmeniUloguModal.getImeUlogeInput().getText().trim();
                    String opisUloge = izmeniUloguModal.getOpisInput().getText().trim();

                    if (imeUloge.isEmpty() || opisUloge.isEmpty()) {
                        JOptionPane.showMessageDialog(izmeniUloguModal, "Molimo popunite sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedUloga.setImeUloge(imeUloge);
                        selectedUloga.setOpisUloge(opisUloge);
                        ulogaTableModel.fireTableDataChanged();
                        izmeniUloguModal.dispose();
                    }
                });

                izmeniUloguModal.init();
            } else {
                JOptionPane.showMessageDialog(this, "Molimo izaberite ulogu za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });

        ukloniButton.addActionListener(e -> {
            int red = ulogeTable.getSelectedRow();
            if (red >= 0) {
                Uloga selectedUloga = ulogaTableModel.getUloga(red);

                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da želite da uklonite ulogu '" + selectedUloga.getImeUloge() + "'?",
                        "Potvrda brisanja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    ulogaTableModel.ukloniUlogu(red);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Molimo izaberite ulogu za uklanjanje.", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<Uloga> getUloge() {
        return uloge;
    }

    public DefaultListModel<Uloga> getUlogaListModel() {
        return ulogaListModel;
    }

    public UlogaTableModel getUlogaTableModel() {
        return ulogaTableModel;
    }

    public JTable getUlogeTable() {
        return ulogeTable;
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