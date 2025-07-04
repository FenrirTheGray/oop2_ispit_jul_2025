package rs.ac.singidunum.novisad.ui;

import rs.ac.singidunum.novisad.model.*;
import rs.ac.singidunum.novisad.ui.views.*;
import rs.ac.singidunum.novisad.util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

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
        this.setSize(1000, 1200);
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

        tabbedPane.addTab("Menadzeri", menadzerIkona, menadzerView, "Lista svih menadzera");
        tabbedPane.addTab("Prodavci", prodavacIkona, prodavacView, "Lista svih prodavaca");
        tabbedPane.addTab("Elektricni Uređaji", elektricniUredjajIkona, elektricniUredjajView, "List svih elektricnih uređaja");
        tabbedPane.addTab("Kvarljiva Roba", kvarljivUredjajIkona, kvarljivaRobaView, "List sve kvarljive robe");
        tabbedPane.addTab("Uloge", ulogaIkona, ulogaView, "Lista svih uloga");

        this.getContentPane().add(tabbedPane);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save All");
        JMenuItem loadItem = new JMenuItem("Load All");

        saveItem.addActionListener(e -> saveAllObjects());
        loadItem.addActionListener(e -> loadAllObjects());

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);

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
                JOptionPane.showMessageDialog(this, "Objects saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving objects: " + ex.getMessage());
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
                JOptionPane.showMessageDialog(this, "Objects loaded successfully!");
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(this, "Error loading objects: " + ex.getMessage());
            }
        }
    }

    private void refreshAllViews() {
        tabbedPane.removeAll();
        initTabs();
    }
}