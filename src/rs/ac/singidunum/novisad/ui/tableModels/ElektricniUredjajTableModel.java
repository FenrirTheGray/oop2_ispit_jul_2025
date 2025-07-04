package rs.ac.singidunum.novisad.ui.tableModels;

import rs.ac.singidunum.novisad.model.ElektricniUredjaj;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ElektricniUredjajTableModel extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = -234801342175803966L;

    private ArrayList<ElektricniUredjaj> elektricniUredjaji;

    public ElektricniUredjajTableModel(ArrayList<ElektricniUredjaj> elektricniUredjaji) {
        this.elektricniUredjaji = elektricniUredjaji;
    }

    public ElektricniUredjaj getElektricniUredjaj(int indeks) {
        return elektricniUredjaji.get(indeks);
    }

    public void dodajElektricniUredjaj(ElektricniUredjaj elektricniUredjaj) {
        elektricniUredjaji.add(elektricniUredjaj);
        fireTableRowsInserted(elektricniUredjaji.size() - 1, elektricniUredjaji.size() - 1);
    }

    public void ukloniElektricniUredjaj(int indeks) {
        elektricniUredjaji.remove(indeks);
        fireTableRowsDeleted(indeks, indeks);
    }

    @Override
    public int getRowCount() {
        return elektricniUredjaji.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ElektricniUredjaj elektricniUredjaj = elektricniUredjaji.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return elektricniUredjaj.getNaziv();
            case 1:
                return elektricniUredjaj.getCena();
            case 2:
                return elektricniUredjaj.getZemljaPorekla();
            case 3:
                return elektricniUredjaj.getDatumProizvodnje() != null ?
                        sdf.format(elektricniUredjaj.getDatumProizvodnje()) : "";
            case 4:
                return elektricniUredjaj.getModel();
            case 5:
                return elektricniUredjaj.getDuzina();
            case 6:
                return elektricniUredjaj.getSirina();
            case 7:
                return elektricniUredjaj.getVisina();
            case 8:
                return elektricniUredjaj.getRadniNapon();
            case 9:
                return elektricniUredjaj.getNominalnaSnaga();
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
                return "Dužina (cm)";
            case 6:
                return "Širina (cm)";
            case 7:
                return "Visina (cm)";
            case 8:
                return "Radni Napon (V)";
            case 9:
                return "Nominalna Snaga (W)";
            default:
                return "";
        }
    }
}