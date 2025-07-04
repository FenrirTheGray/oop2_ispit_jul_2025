package rs.ac.singidunum.novisad.ui.tableModels;

import rs.ac.singidunum.novisad.model.KvarljivaRoba;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class KvarljivaRobaTableModel extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = -234801342175803966L;

    private ArrayList<KvarljivaRoba> kvarljivaRoba;

    public KvarljivaRobaTableModel(ArrayList<KvarljivaRoba> kvarljivaRoba) {
        this.kvarljivaRoba = kvarljivaRoba;
    }

    public KvarljivaRoba getKvarljivaRoba(int indeks) {
        return kvarljivaRoba.get(indeks);
    }

    public void dodajKvarljivuRobu(KvarljivaRoba kvarljivaRobaItem) {
        kvarljivaRoba.add(kvarljivaRobaItem);
        fireTableRowsInserted(kvarljivaRoba.size() - 1, kvarljivaRoba.size() - 1);
    }

    public void ukloniKvarljivuRobu(int indeks) {
        kvarljivaRoba.remove(indeks);
        fireTableRowsDeleted(indeks, indeks);
    }

    @Override
    public int getRowCount() {
        return kvarljivaRoba.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KvarljivaRoba kvarljivaRobaItem = kvarljivaRoba.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return kvarljivaRobaItem.getNaziv();
            case 1:
                return kvarljivaRobaItem.getCena();
            case 2:
                return kvarljivaRobaItem.getZemljaPorekla();
            case 3:
                return kvarljivaRobaItem.getDatumProizvodnje() != null ?
                        sdf.format(kvarljivaRobaItem.getDatumProizvodnje()) : "";
            case 4:
                return kvarljivaRobaItem.getModel();
            case 5:
                return kvarljivaRobaItem.getRokTrajanja() != null ?
                        sdf.format(kvarljivaRobaItem.getRokTrajanja()) : "";
            case 6:
                return kvarljivaRobaItem.getTipAmbalaze();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Naziv";
            case 1:
                return "Cena";
            case 2:
                return "Zemlja Porekla";
            case 3:
                return "Datum Proizvodnje";
            case 4:
                return "Model";
            case 5:
                return "Rok Trajanja";
            case 6:
                return "Tip Ambalaze";
            default:
                return "";
        }
    }
}