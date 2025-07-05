package rs.ac.singidunum.novisad.search;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import rs.ac.singidunum.novisad.model.*;

public class SearchWindow extends JFrame {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    private SearchManager searchManager;
    private JTabbedPane tabbedPane;
    private JTextArea resultsArea;

    
    private JTextField euNazivField, euZemljaField, euModelField;
    private JTextField euMinCenaField, euMaxCenaField;
    private JTextField euDatumOdField, euDatumDoField;
    private JTextField euMinDuzinaField, euMaxDuzinaField;
    private JTextField euMinSirinaField, euMaxSirinaField;
    private JTextField euMinVisinaField, euMaxVisinaField;
    private JTextField euMinNaponField, euMaxNaponField;
    private JTextField euMinSnagaField, euMaxSnagaField;

    
    private JTextField krNazivField, krZemljaField, krModelField, krTipAmbalaze;
    private JTextField krMinCenaField, krMaxCenaField;
    private JTextField krDatumProizvodnjeOdField, krDatumProizvodnjeDo;
    private JTextField krRokTrajanjaOdField, krRokTrajanjaDo;

    
    private JTextField mImeField, mPrezimeField, mZvanjeField, mStepenField;
    private JTextField mMinPlataField, mMaxPlataField;
    private JTextField mImeUlogeField, mOpisUlogeField;

    
    private JTextField pImeField, pPrezimeField, pZvanjeField, pStepenField;
    private JTextField pMinPlataField, pMaxPlataField, pRadnoMestoField;
    private JTextField pImeNadredjenog, pPrezimeNadredjenog;

    
    private JTextField uImeField, uOpisField;

    public SearchWindow(List<ElektricniUredjaj> elektricniUredjaji,
                        List<KvarljivaRoba> kvarljivaRoba,
                        List<Menadzer> menadzeri,
                        List<Prodavac> prodavci,
                        List<Uloga> uloge) {
        this.searchManager = new SearchManager(elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge);
        initComponents();
    }

    private void initComponents() {
        setTitle("Pretraga");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        
        tabbedPane.addTab("Električni Uređaji", createElektricniUredjajSearchPanel());
        tabbedPane.addTab("Kvarljiva Roba", createKvarljivaRobaSearchPanel());
        tabbedPane.addTab("Menadžeri", createMenadzerSearchPanel());
        tabbedPane.addTab("Prodavci", createProdavacSearchPanel());
        tabbedPane.addTab("Uloge", createUlogaSearchPanel());

        
        resultsArea = new JTextArea(15, 50);
        resultsArea.setEditable(false);
        resultsArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBorder(new TitledBorder("Rezultati Pretrage"));

        
        JButton clearAllButton = new JButton("Očisti Rezlutate Pretrage");
        clearAllButton.addActionListener(e -> {
            searchManager.clearAllCriteria();
            resultsArea.setText("");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearAllButton);

        
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        remove(scrollPane);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createElektricniUredjajSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Naziv:"), gbc);
        gbc.gridx = 1;
        euNazivField = new JTextField(15);
        panel.add(euNazivField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Zemlja porekla:"), gbc);
        gbc.gridx = 3;
        euZemljaField = new JTextField(15);
        panel.add(euZemljaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        euModelField = new JTextField(15);
        panel.add(euModelField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Min cena:"), gbc);
        gbc.gridx = 1;
        euMinCenaField = new JTextField(15);
        panel.add(euMinCenaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max cena:"), gbc);
        gbc.gridx = 3;
        euMaxCenaField = new JTextField(15);
        panel.add(euMaxCenaField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Datum od (dd-MM-yyyy):"), gbc);
        gbc.gridx = 1;
        euDatumOdField = new JTextField(15);
        panel.add(euDatumOdField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Datum do (dd-MM-yyyy):"), gbc);
        gbc.gridx = 3;
        euDatumDoField = new JTextField(15);
        panel.add(euDatumDoField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Min dužina:"), gbc);
        gbc.gridx = 1;
        euMinDuzinaField = new JTextField(15);
        panel.add(euMinDuzinaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max dužina:"), gbc);
        gbc.gridx = 3;
        euMaxDuzinaField = new JTextField(15);
        panel.add(euMaxDuzinaField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Min širina:"), gbc);
        gbc.gridx = 1;
        euMinSirinaField = new JTextField(15);
        panel.add(euMinSirinaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max širina:"), gbc);
        gbc.gridx = 3;
        euMaxSirinaField = new JTextField(15);
        panel.add(euMaxSirinaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Min visina:"), gbc);
        gbc.gridx = 1;
        euMinVisinaField = new JTextField(15);
        panel.add(euMinVisinaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max visina:"), gbc);
        gbc.gridx = 3;
        euMaxVisinaField = new JTextField(15);
        panel.add(euMaxVisinaField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Min napon:"), gbc);
        gbc.gridx = 1;
        euMinNaponField = new JTextField(15);
        panel.add(euMinNaponField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max napon:"), gbc);
        gbc.gridx = 3;
        euMaxNaponField = new JTextField(15);
        panel.add(euMaxNaponField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Min snaga:"), gbc);
        gbc.gridx = 1;
        euMinSnagaField = new JTextField(15);
        panel.add(euMinSnagaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max snaga:"), gbc);
        gbc.gridx = 3;
        euMaxSnagaField = new JTextField(15);
        panel.add(euMaxSnagaField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Pretraži Električne Uređaje");
        searchButton.addActionListener(new ElektricniUredjajSearchListener());
        panel.add(searchButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        JButton clearButton = new JButton("Očisti Filtere");
        clearButton.addActionListener(e -> clearElektricniUredjajFields());
        panel.add(clearButton, gbc);

        return panel;
    }

    private JPanel createKvarljivaRobaSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Naziv:"), gbc);
        gbc.gridx = 1;
        krNazivField = new JTextField(15);
        panel.add(krNazivField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Zemlja porekla:"), gbc);
        gbc.gridx = 3;
        krZemljaField = new JTextField(15);
        panel.add(krZemljaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        krModelField = new JTextField(15);
        panel.add(krModelField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Tip ambalže:"), gbc);
        gbc.gridx = 3;
        krTipAmbalaze = new JTextField(15);
        panel.add(krTipAmbalaze, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Min cena:"), gbc);
        gbc.gridx = 1;
        krMinCenaField = new JTextField(15);
        panel.add(krMinCenaField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max cena:"), gbc);
        gbc.gridx = 3;
        krMaxCenaField = new JTextField(15);
        panel.add(krMaxCenaField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Datum proizvodnje od:"), gbc);
        gbc.gridx = 1;
        krDatumProizvodnjeOdField = new JTextField(15);
        panel.add(krDatumProizvodnjeOdField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Datum proizvodnje do:"), gbc);
        gbc.gridx = 3;
        krDatumProizvodnjeDo = new JTextField(15);
        panel.add(krDatumProizvodnjeDo, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Rok trajanja od:"), gbc);
        gbc.gridx = 1;
        krRokTrajanjaOdField = new JTextField(15);
        panel.add(krRokTrajanjaOdField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Rok trajanja do:"), gbc);
        gbc.gridx = 3;
        krRokTrajanjaDo = new JTextField(15);
        panel.add(krRokTrajanjaDo, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Pretraži Kvarljivu Robu");
        searchButton.addActionListener(new KvarljivaRobaSearchListener());
        panel.add(searchButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        JButton clearButton = new JButton("Očisti Filtere");
        clearButton.addActionListener(e -> clearKvarljivaRobaFields());
        panel.add(clearButton, gbc);

        return panel;
    }

    private JPanel createMenadzerSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Ime:"), gbc);
        gbc.gridx = 1;
        mImeField = new JTextField(15);
        panel.add(mImeField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Prezime:"), gbc);
        gbc.gridx = 3;
        mPrezimeField = new JTextField(15);
        panel.add(mPrezimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Zvanje:"), gbc);
        gbc.gridx = 1;
        mZvanjeField = new JTextField(15);
        panel.add(mZvanjeField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Stepen obrazovanja:"), gbc);
        gbc.gridx = 3;
        mStepenField = new JTextField(15);
        panel.add(mStepenField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Min plata:"), gbc);
        gbc.gridx = 1;
        mMinPlataField = new JTextField(15);
        panel.add(mMinPlataField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max plata:"), gbc);
        gbc.gridx = 3;
        mMaxPlataField = new JTextField(15);
        panel.add(mMaxPlataField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Ime uloge:"), gbc);
        gbc.gridx = 1;
        mImeUlogeField = new JTextField(15);
        panel.add(mImeUlogeField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Opis uloge:"), gbc);
        gbc.gridx = 3;
        mOpisUlogeField = new JTextField(15);
        panel.add(mOpisUlogeField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Pretraži Menadžere");
        searchButton.addActionListener(new MenadzerSearchListener());
        panel.add(searchButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        JButton clearButton = new JButton("Očisti Filtere");
        clearButton.addActionListener(e -> clearMenadzerFields());
        panel.add(clearButton, gbc);

        return panel;
    }

    private JPanel createProdavacSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Ime:"), gbc);
        gbc.gridx = 1;
        pImeField = new JTextField(15);
        panel.add(pImeField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Prezime:"), gbc);
        gbc.gridx = 3;
        pPrezimeField = new JTextField(15);
        panel.add(pPrezimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Zvanje:"), gbc);
        gbc.gridx = 1;
        pZvanjeField = new JTextField(15);
        panel.add(pZvanjeField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Stepen obrazovanja:"), gbc);
        gbc.gridx = 3;
        pStepenField = new JTextField(15);
        panel.add(pStepenField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Min plata:"), gbc);
        gbc.gridx = 1;
        pMinPlataField = new JTextField(15);
        panel.add(pMinPlataField, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Max plata:"), gbc);
        gbc.gridx = 3;
        pMaxPlataField = new JTextField(15);
        panel.add(pMaxPlataField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Radno mesto:"), gbc);
        gbc.gridx = 1;
        pRadnoMestoField = new JTextField(15);
        panel.add(pRadnoMestoField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Ime nadređenog:"), gbc);
        gbc.gridx = 1;
        pImeNadredjenog = new JTextField(15);
        panel.add(pImeNadredjenog, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Prezime nadređenog:"), gbc);
        gbc.gridx = 3;
        pPrezimeNadredjenog = new JTextField(15);
        panel.add(pPrezimeNadredjenog, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Pretraži Prodavce");
        searchButton.addActionListener(new ProdavacSearchListener());
        panel.add(searchButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        JButton clearButton = new JButton("Očisti Filtere");
        clearButton.addActionListener(e -> clearProdavacFields());
        panel.add(clearButton, gbc);

        return panel;
    }

    private JPanel createUlogaSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Ime uloge:"), gbc);
        gbc.gridx = 1;
        uImeField = new JTextField(20);
        panel.add(uImeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Opis uloge:"), gbc);
        gbc.gridx = 1;
        uOpisField = new JTextField(20);
        panel.add(uOpisField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JButton searchButton = new JButton("Pretraži Uloge");
        searchButton.addActionListener(new UlogaSearchListener());
        panel.add(searchButton, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton clearButton = new JButton("Očisti Filtere");
        clearButton.addActionListener(e -> clearUlogaFields());
        panel.add(clearButton, gbc);

        return panel;
    }

    
    private void clearElektricniUredjajFields() {
        euNazivField.setText("");
        euZemljaField.setText("");
        euModelField.setText("");
        euMinCenaField.setText("");
        euMaxCenaField.setText("");
        euDatumOdField.setText("");
        euDatumDoField.setText("");
        euMinDuzinaField.setText("");
        euMaxDuzinaField.setText("");
        euMinSirinaField.setText("");
        euMaxSirinaField.setText("");
        euMinVisinaField.setText("");
        euMaxVisinaField.setText("");
        euMinNaponField.setText("");
        euMaxNaponField.setText("");
        euMinSnagaField.setText("");
        euMaxSnagaField.setText("");
    }

    private void clearKvarljivaRobaFields() {
        krNazivField.setText("");
        krZemljaField.setText("");
        krModelField.setText("");
        krTipAmbalaze.setText("");
        krMinCenaField.setText("");
        krMaxCenaField.setText("");
        krDatumProizvodnjeOdField.setText("");
        krDatumProizvodnjeDo.setText("");
        krRokTrajanjaOdField.setText("");
        krRokTrajanjaDo.setText("");
    }

    private void clearMenadzerFields() {
        mImeField.setText("");
        mPrezimeField.setText("");
        mZvanjeField.setText("");
        mStepenField.setText("");
        mMinPlataField.setText("");
        mMaxPlataField.setText("");
        mImeUlogeField.setText("");
        mOpisUlogeField.setText("");
    }

    private void clearProdavacFields() {
        pImeField.setText("");
        pPrezimeField.setText("");
        pZvanjeField.setText("");
        pStepenField.setText("");
        pMinPlataField.setText("");
        pMaxPlataField.setText("");
        pRadnoMestoField.setText("");
        pImeNadredjenog.setText("");
        pPrezimeNadredjenog.setText("");
    }

    private void clearUlogaFields() {
        uImeField.setText("");
        uOpisField.setText("");
    }

    
    private Double parseDouble(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseInt(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Date parseDate(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        try {
            return DATE_FORMAT.parse(text.trim());
        } catch (ParseException e) {
            return null;
        }
    }

    private void displayResults(String entityType, List<?> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Rezultati pretrage za ").append(entityType).append(" ===\n");
        sb.append("Nađeno ").append(results.size()).append(" rezultata:\n\n");

        for (Object result : results) {
            sb.append(result.toString()).append("\n\n");
        }

        resultsArea.setText(sb.toString());
        resultsArea.setCaretPosition(0);
    }

    
    private class ElektricniUredjajSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<ElektricniUredjaj> results = searchManager.searchElektricniUredjaji(
                    euNazivField.getText(),
                    euZemljaField.getText(),
                    euModelField.getText(),
                    parseDouble(euMinCenaField.getText()),
                    parseDouble(euMaxCenaField.getText()),
                    parseDate(euDatumOdField.getText()),
                    parseDate(euDatumDoField.getText()),
                    parseDouble(euMinDuzinaField.getText()),
                    parseDouble(euMaxDuzinaField.getText()),
                    parseDouble(euMinSirinaField.getText()),
                    parseDouble(euMaxSirinaField.getText()),
                    parseDouble(euMinVisinaField.getText()),
                    parseDouble(euMaxVisinaField.getText()),
                    parseInt(euMinNaponField.getText()),
                    parseInt(euMaxNaponField.getText()),
                    parseInt(euMinSnagaField.getText()),
                    parseInt(euMaxSnagaField.getText())
            );

            displayResults("Električni Uređaji", results);
        }
    }

    private class KvarljivaRobaSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<KvarljivaRoba> results = searchManager.searchKvarljivaRoba(
                    krNazivField.getText(),
                    krZemljaField.getText(),
                    krModelField.getText(),
                    krTipAmbalaze.getText(),
                    parseDouble(krMinCenaField.getText()),
                    parseDouble(krMaxCenaField.getText()),
                    parseDate(krDatumProizvodnjeOdField.getText()),
                    parseDate(krDatumProizvodnjeDo.getText()),
                    parseDate(krRokTrajanjaOdField.getText()),
                    parseDate(krRokTrajanjaDo.getText())
            );

            displayResults("Kvarljiva Roba", results);
        }
    }

    private class MenadzerSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Menadzer> results = searchManager.searchMenadzeri(
                    mImeField.getText(),
                    mPrezimeField.getText(),
                    mZvanjeField.getText(),
                    mStepenField.getText(),
                    parseDouble(mMinPlataField.getText()),
                    parseDouble(mMaxPlataField.getText()),
                    mImeUlogeField.getText(),
                    mOpisUlogeField.getText()
            );

            displayResults("Menadžeri", results);
        }
    }

    private class ProdavacSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Prodavac> results = searchManager.searchProdavci(
                    pImeField.getText(),
                    pPrezimeField.getText(),
                    pZvanjeField.getText(),
                    pStepenField.getText(),
                    parseDouble(pMinPlataField.getText()),
                    parseDouble(pMaxPlataField.getText()),
                    pRadnoMestoField.getText(),
                    pImeNadredjenog.getText(),
                    pPrezimeNadredjenog.getText()
            );

            displayResults("Prodavci", results);
        }
    }

    private class UlogaSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Uloga> results = searchManager.searchUloge(
                    uImeField.getText(),
                    uOpisField.getText()
            );

            displayResults("Uloge", results);
        }
    }
}