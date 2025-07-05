package rs.ac.singidunum.novisad.ui;

import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import rs.ac.singidunum.novisad.model.*;
import rs.ac.singidunum.novisad.search.SearchWindow;
import rs.ac.singidunum.novisad.ui.views.*;
import rs.ac.singidunum.novisad.util.FileManager;

public class MainWindow extends JFrame {

    @Serial
    private static final long serialVersionUID = 4626677206642819502L;

    private JTabbedPane tabbedPane;
    private ArrayList<ElektricniUredjaj> elektricniUredjaji;
    private ArrayList<KvarljivaRoba> kvarljivaRoba;
    private ArrayList<Menadzer> menadzeri;
    private ArrayList<Prodavac> prodavci;
    private ArrayList<Uloga> uloge;

    private MenadzerView menadzerView;
    private ProdavacView prodavacView;
    private ElektricniUredjajView elektricniUredjajView;
    private KvarljivaRobaView kvarljivaRobaView;
    private UlogaView ulogaView;

    public MainWindow(ArrayList<ElektricniUredjaj> elektricniUredjaji, ArrayList<KvarljivaRoba> kvarljivaRoba, ArrayList<Menadzer> menadzeri, ArrayList<Prodavac> prodavci, ArrayList<Uloga> uloge) {
        super();
        this.tabbedPane = new JTabbedPane();
        this.elektricniUredjaji = elektricniUredjaji;
        this.kvarljivaRoba = kvarljivaRoba;
        this.menadzeri = menadzeri;
        this.prodavci = prodavci;
        this.uloge = uloge;
    }

    public void init() {
        this.setTitle("Main Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);

        this.initMenuBar();
        this.initTabs();
        this.setVisible(true);
    }

    private void initTabs() {
        ImageIcon menadzerIkona = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/menadzer.png")));
        ImageIcon prodavacIkona = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/prodavac.png")));
        ImageIcon elektricniUredjajIkona = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/elektricniUredjaj.png")));
        ImageIcon kvarljivUredjajIkona = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/kvarljivaRoba.png")));
        ImageIcon ulogaIkona = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/uloga.png")));

        menadzerView = new MenadzerView(menadzeri, uloge);
        menadzerView.initMenadzerView();

        prodavacView = new ProdavacView(prodavci, menadzeri);
        prodavacView.initProdavacView();

        elektricniUredjajView = new ElektricniUredjajView(elektricniUredjaji);
        elektricniUredjajView.init();

        kvarljivaRobaView = new KvarljivaRobaView(kvarljivaRoba);
        kvarljivaRobaView.init();

        ulogaView = new UlogaView(uloge);
        ulogaView.initUlogaView();

        tabbedPane.addTab("Menadžeri", menadzerIkona, menadzerView, "Lista svih menadzera");
        tabbedPane.addTab("Prodavci", prodavacIkona, prodavacView, "Lista svih prodavaca");
        tabbedPane.addTab("Električni Uređaji", elektricniUredjajIkona, elektricniUredjajView, "Lista svih elektricnih uređaja");
        tabbedPane.addTab("Kvarljiva Roba", kvarljivUredjajIkona, kvarljivaRobaView, "Lista sve kvarljive robe");
        tabbedPane.addTab("Uloge", ulogaIkona, ulogaView, "Lista svih uloga");

        this.getContentPane().add(tabbedPane);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Export Podataka");
        JMenuItem loadItem = new JMenuItem("Import Podataka");

        saveItem.addActionListener(e -> saveAllObjects());
        loadItem.addActionListener(e -> loadAllObjects());

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        
        JMenu searchMenu = new JMenu("Pretraga");
        JMenuItem searchAllItem = new JMenuItem("Napredna Pretraga");
        JMenuItem quickSearchItem = new JMenuItem("Brza Pretraga");

        searchAllItem.addActionListener(e -> openSearchWindow());
        quickSearchItem.addActionListener(e -> openQuickSearchDialog());

        searchMenu.add(searchAllItem);
        searchMenu.add(quickSearchItem);

        menuBar.add(fileMenu);
        menuBar.add(searchMenu);

        this.setJMenuBar(menuBar);
    }

    private void saveAllObjects() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileManager.sacuvajSveObjekte(
                        fileChooser.getSelectedFile().getAbsolutePath(),
                        elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge
                );
                JOptionPane.showMessageDialog(this, "Podaci uspešno sačuvani!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Greška pri čuvanju: " + ex.getMessage());
            }
        }
    }

    private void loadAllObjects() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileManager.ucitajSveObjekte(
                        fileChooser.getSelectedFile().getAbsolutePath(),
                        elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge
                );
                refreshAllViews();
                JOptionPane.showMessageDialog(this, "Podaci uspešno učitani!");
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(this, "Greška pri učitavanju: " + ex.getMessage());
            }
        }
    }

    private void refreshAllViews() {
        tabbedPane.removeAll();
        initTabs();
    }

    private void openSearchWindow() {
        SearchWindow searchWindow = new SearchWindow(elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge);
        searchWindow.setVisible(true);
    }

    private void openQuickSearchDialog() {
        String searchTerm = JOptionPane.showInputDialog(this,
                "Unesi termin za pretragu:",
                "Brza Pretraga",
                JOptionPane.QUESTION_MESSAGE);

        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            performQuickSearch(searchTerm.trim());
        }
    }

    private void performQuickSearch(String searchTerm) {
        StringBuilder results = new StringBuilder();
        results.append("Brza Pretraga - Rezultati za: \"").append(searchTerm).append("\"\n\n");

        
        results.append("=== Električni Uređaji ===\n");
        for (ElektricniUredjaj eu : elektricniUredjaji) {
            if (eu.getNaziv().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    eu.getModel().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    eu.getZemljaPorekla().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.append("- ").append(eu.getNaziv()).append(" (").append(eu.getModel()).append(")\n");
            }
        }

        
        results.append("\n=== Kvarljiva Roba ===\n");
        for (KvarljivaRoba kr : kvarljivaRoba) {
            if (kr.getNaziv().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    kr.getModel().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    kr.getZemljaPorekla().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.append("- ").append(kr.getNaziv()).append(" (").append(kr.getModel()).append(")\n");
            }
        }

        
        results.append("\n=== Menadžeri ===\n");
        for (Menadzer m : menadzeri) {
            if (m.getIme().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    m.getPrezime().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    m.getZvanje().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.append("- ").append(m.getIme()).append(" ").append(m.getPrezime()).append(" (").append(m.getZvanje()).append(")\n");
            }
        }

        
        results.append("\n=== Prodavci ===\n");
        for (Prodavac p : prodavci) {
            if (p.getIme().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    p.getPrezime().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    p.getZvanje().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    p.getRadnoMesto().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.append("- ").append(p.getIme()).append(" ").append(p.getPrezime()).append(" (").append(p.getRadnoMesto()).append(")\n");
            }
        }

        
        results.append("\n=== Uloge ===\n");
        for (Uloga u : uloge) {
            if (u.getImeUloge().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    u.getOpisUloge().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.append("- ").append(u.getImeUloge()).append("\n");
            }
        }

        
        JTextArea resultArea = new JTextArea(results.toString());
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Brza Pretraga - Rezultati", JOptionPane.INFORMATION_MESSAGE);
    }
}