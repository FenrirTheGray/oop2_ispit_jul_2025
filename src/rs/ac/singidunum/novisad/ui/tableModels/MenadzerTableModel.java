package rs.ac.singidunum.novisad.ui.tableModels;

import java.io.Serial;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import rs.ac.singidunum.novisad.model.Menadzer;

public class MenadzerTableModel extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = -234801342175803966L;

    private ArrayList<Menadzer> menadzeri;

    public MenadzerTableModel(ArrayList<Menadzer> menadzeri) {
        super();
        this.menadzeri = menadzeri;
    }

    public Menadzer getMenadzer(int indeks) {
        return this.menadzeri.get(indeks);
    }

    public void dodajMenadzera(Menadzer menadzer) {
        this.menadzeri.add(menadzer);
        this.fireTableRowsInserted(this.menadzeri.size() - 1, this.menadzeri.size() - 1);
    }

    public void ukoloniMenadzera(int indeks) {
        this.menadzeri.remove(indeks);
        this.fireTableRowsDeleted(indeks, indeks);
    }

    @Override
    public int getRowCount() {
        return menadzeri.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return this.menadzeri.get(rowIndex).getIme();
        }

        if (columnIndex == 1) {
            return this.menadzeri.get(rowIndex).getPrezime();
        }

        if (columnIndex == 2) {
            return this.menadzeri.get(rowIndex).getPlata();
        }

        if (columnIndex == 3) {
            return this.menadzeri.get(rowIndex).getZvanje();
        }

        if (columnIndex == 4) {
            return this.menadzeri.get(rowIndex).getStepenObrazovanja();
        }

        if (columnIndex == 5) {
            return this.menadzeri.get(rowIndex).getUloga();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Ime";
            case 1 -> "Prezime";
            case 2 -> "Plata";
            case 3 -> "Zvanje";
            case 4 -> "Stepen Obrazovanja";
            case 5 -> "Uloga";
            default -> null;
        };
    }
}