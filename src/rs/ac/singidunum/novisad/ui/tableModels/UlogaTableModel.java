package rs.ac.singidunum.novisad.ui.tableModels;

import rs.ac.singidunum.novisad.model.Uloga;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;
import java.util.ArrayList;

public class UlogaTableModel extends AbstractTableModel {

    @Serial
    private static final long serialVersionUID = -2023872659616800610L;

    private ArrayList<Uloga> uloge;

    public UlogaTableModel(ArrayList<Uloga> uloge) {
        super();
        this.uloge = uloge;
    }

    public Uloga getUloga(int indeks) {
        return this.uloge.get(indeks);
    }

    public void dodajUlogu(Uloga uloga) {
        this.uloge.add(uloga);
        this.fireTableRowsInserted(this.uloge.size() - 1, this.uloge.size() - 1);
    }

    public void ukloniUlogu(int indeks) {
        this.uloge.remove(indeks);
        this.fireTableRowsDeleted(indeks, indeks);
    }

    @Override
    public int getRowCount() {
        return uloge.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return this.uloge.get(rowIndex).getImeUloge();
        }

        if (columnIndex == 1) {
            return this.uloge.get(rowIndex).getOpisUloge();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Ime uloge";
            case 1 -> "Opis uloge";
            default -> null;
        };
    }
}