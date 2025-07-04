package rs.ac.singidunum.novisad.ui.tableModels;

import rs.ac.singidunum.novisad.model.Prodavac;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;
import java.util.ArrayList;

public class ProdavacTableModel extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = 5611491760102176692L;

    private ArrayList<Prodavac> prodavci;

    public ProdavacTableModel(ArrayList<Prodavac> prodavci) {
        super();
        this.prodavci = prodavci;
    }

    public Prodavac getProdavac(int indeks) {
        return this.prodavci.get(indeks);
    }

    public void dodajProdavca(Prodavac prodavac) {
        this.prodavci.add(prodavac);
        this.fireTableRowsInserted(this.prodavci.size() - 1, this.prodavci.size() - 1);
    }

    public void ukloniProdavca(int indeks) {
        this.prodavci.remove(indeks);
        this.fireTableRowsDeleted(indeks, indeks);
    }

    @Override
    public int getRowCount() {
        return prodavci.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return this.prodavci.get(rowIndex).getIme();
        }

        if (columnIndex == 1) {
            return this.prodavci.get(rowIndex).getPrezime();
        }

        if (columnIndex == 2) {
            return this.prodavci.get(rowIndex).getPlata();
        }

        if (columnIndex == 3) {
            return this.prodavci.get(rowIndex).getZvanje();
        }

        if (columnIndex == 4) {
            return this.prodavci.get(rowIndex).getStepenObrazovanja();
        }

        if (columnIndex == 5) {
            return this.prodavci.get(rowIndex).getNadredjeni();
        }

        if (columnIndex == 6) {
            return this.prodavci.get(rowIndex).getRadnoMesto();
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
            case 5 -> "Nadređeni";
            case 6 -> "Radno Mesto";
            default -> null;
        };
    }
}
