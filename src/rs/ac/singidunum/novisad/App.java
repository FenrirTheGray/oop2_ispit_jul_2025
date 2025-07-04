package rs.ac.singidunum.novisad;

import rs.ac.singidunum.novisad.model.*;
import rs.ac.singidunum.novisad.ui.MainWindow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        ArrayList<ElektricniUredjaj> elektricniUredjaji = new ArrayList<>();
        ArrayList<KvarljivaRoba> kvarljivaRoba = new ArrayList<>();
        ArrayList<Menadzer> menadzeri = new ArrayList<>();
        ArrayList<Prodavac> prodavci = new ArrayList<>();
        ArrayList<Uloga> uloge = new ArrayList<>();

        dodajPodatke(elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge);

        MainWindow mw = new MainWindow(elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge);
        mw.init();
    }

    private static void dodajPodatke(ArrayList<ElektricniUredjaj> elektricniUredjaji, ArrayList<KvarljivaRoba> kvarljivaRoba, ArrayList<Menadzer> menadzeri, ArrayList<Prodavac> prodavci, ArrayList<Uloga> uloge) {
        // 1. Generate Uloga instances first
        uloge.add(new Uloga("Direktor", "Upravljanje celokupnim poslovanjem kompanije"));
        uloge.add(new Uloga("Menadzer prodaje", "Upravljanje prodajnim timom i procesima"));
        uloge.add(new Uloga("Finansijski menadzer", "Upravljanje finansijskim operacijama"));
        uloge.add(new Uloga("HR menadzer", "Upravljanje ljudskim resursima"));
        uloge.add(new Uloga("Operativni menadzer", "Upravljanje dnevnim operacijama"));
        uloge.add(new Uloga("Marketing menadzer", "Upravljanje marketinskim kampanjama"));
        uloge.add(new Uloga("IT menadzer", "Upravljanje informacionim sistemima"));
        uloge.add(new Uloga("Menadzer kvaliteta", "Upravljanje kontrolom kvaliteta"));
        uloge.add(new Uloga("Logisticki menadzer", "Upravljanje logistikom i skladistenjem"));
        uloge.add(new Uloga("Menadzer razvoja", "Upravljanje razvojnim projektima"));

        // 2. Generate Menadzer instances based on those Uloga instances
        menadzeri.add(new Menadzer("Marko", "Petrovic", 120000.0, "Direktor", "Visoka", uloge.get(0)));
        menadzeri.add(new Menadzer("Ana", "Nikolic", 95000.0, "Menadzer", "Visoka", uloge.get(1)));
        menadzeri.add(new Menadzer("Stefan", "Milic", 100000.0, "Menadzer", "Visoka", uloge.get(2)));
        menadzeri.add(new Menadzer("Milica", "Jovanovic", 90000.0, "Menadzer", "Visoka", uloge.get(3)));
        menadzeri.add(new Menadzer("Nikola", "Stojanovic", 85000.0, "Menadzer", "Visoka", uloge.get(4)));
        menadzeri.add(new Menadzer("Jelena", "Milosevic", 88000.0, "Menadzer", "Visoka", uloge.get(5)));
        menadzeri.add(new Menadzer("Aleksandar", "Radovic", 105000.0, "Menadzer", "Visoka", uloge.get(6)));
        menadzeri.add(new Menadzer("Tamara", "Vasic", 92000.0, "Menadzer", "Visoka", uloge.get(7)));
        menadzeri.add(new Menadzer("Uros", "Popovic", 87000.0, "Menadzer", "Visoka", uloge.get(8)));
        menadzeri.add(new Menadzer("Marija", "Stankovic", 93000.0, "Menadzer", "Visoka", uloge.get(9)));

        // 3. Generate Prodavac instances based on Menadzer instances
        prodavci.add(new Prodavac("Petar", "Mitrovic", 60000.0, "Prodavac", "Srednja", menadzeri.get(1), "Prodajna sala"));
        prodavci.add(new Prodavac("Jovana", "Radic", 55000.0, "Prodavac", "Srednja", menadzeri.get(1), "Prodajna sala"));
        prodavci.add(new Prodavac("Milos", "Antic", 58000.0, "Prodavac", "Srednja", menadzeri.get(1), "Kasa"));
        prodavci.add(new Prodavac("Sandra", "Pavlovic", 62000.0, "Prodavac", "Visoka", menadzeri.get(4), "Prodajna sala"));
        prodavci.add(new Prodavac("Dejan", "Lazic", 57000.0, "Prodavac", "Srednja", menadzeri.get(4), "Skladiste"));
        prodavci.add(new Prodavac("Milena", "Djordjevic", 59000.0, "Prodavac", "Srednja", menadzeri.get(1), "Prodajna sala"));
        prodavci.add(new Prodavac("Vladimir", "Kostic", 56000.0, "Prodavac", "Srednja", menadzeri.get(8), "Skladiste"));
        prodavci.add(new Prodavac("Teodora", "Maksimovic", 61000.0, "Prodavac", "Visoka", menadzeri.get(1), "Kasa"));
        prodavci.add(new Prodavac("Nemanja", "Zivkovic", 54000.0, "Prodavac", "Srednja", menadzeri.get(4), "Prodajna sala"));
        prodavci.add(new Prodavac("Katarina", "Bogdanovic", 63000.0, "Prodavac", "Visoka", menadzeri.get(1), "Prodajna sala"));

        // Generate ElektricniUredjaj instances
        Calendar cal = Calendar.getInstance();

        cal.set(2023, 5, 15);
        elektricniUredjaji.add(new ElektricniUredjaj("Samsung TV", 85000.0, "Juzna Koreja", cal.getTime(), "UE55AU7100", 123.0f, 70.5f, 7.8f, 220, 150));

        cal.set(2023, 8, 10);
        elektricniUredjaji.add(new ElektricniUredjaj("LG Frizider", 120000.0, "Juzna Koreja", cal.getTime(), "GBB92STAXP", 59.5f, 68.4f, 201.0f, 220, 300));

        cal.set(2023, 3, 20);
        elektricniUredjaji.add(new ElektricniUredjaj("Bosch Ves masina", 95000.0, "Nemacka", cal.getTime(), "WAT28461BY", 59.8f, 55.0f, 84.8f, 220, 2000));

        cal.set(2023, 7, 5);
        elektricniUredjaji.add(new ElektricniUredjaj("Philips Usisivac", 25000.0, "Holandija", cal.getTime(), "FC9334/09", 41.0f, 28.0f, 25.0f, 220, 750));

        cal.set(2023, 11, 1);
        elektricniUredjaji.add(new ElektricniUredjaj("Gorenje Sporet", 75000.0, "Slovenija", cal.getTime(), "EC5341WG", 50.0f, 60.0f, 85.0f, 220, 3500));

        cal.set(2023, 4, 25);
        elektricniUredjaji.add(new ElektricniUredjaj("Xiaomi Mobilni", 35000.0, "Kina", cal.getTime(), "Redmi Note 12", 16.5f, 7.6f, 0.8f, 5, 33));

        cal.set(2023, 9, 12);
        elektricniUredjaji.add(new ElektricniUredjaj("Sony PlayStation", 65000.0, "Japan", cal.getTime(), "PS5", 39.0f, 26.0f, 10.4f, 220, 200));

        cal.set(2023, 2, 8);
        elektricniUredjaji.add(new ElektricniUredjaj("Dell Laptop", 120000.0, "SAD", cal.getTime(), "Inspiron 15", 35.8f, 23.6f, 1.8f, 220, 65));

        cal.set(2023, 6, 30);
        elektricniUredjaji.add(new ElektricniUredjaj("Whirlpool Mikrotalasna", 45000.0, "SAD", cal.getTime(), "MWP 253 W", 48.1f, 37.6f, 28.0f, 220, 900));

        cal.set(2023, 10, 18);
        elektricniUredjaji.add(new ElektricniUredjaj("Electrolux Klimа", 80000.0, "Svedska", cal.getTime(), "EACS-12HAT", 79.0f, 54.8f, 30.0f, 220, 1200));

        // Generate KvarljivaRoba instances
        cal.set(2024, 11, 15);
        Date rok1 = cal.getTime();
        cal.set(2024, 1, 10);
        kvarljivaRoba.add(new KvarljivaRoba("Mleko", 150.0, "Srbija", cal.getTime(), "Imlek 2.8%", rok1, "Tetrapak"));

        cal.set(2024, 11, 20);
        Date rok2 = cal.getTime();
        cal.set(2024, 1, 15);
        kvarljivaRoba.add(new KvarljivaRoba("Jogurt", 120.0, "Srbija", cal.getTime(), "Danone Natural", rok2, "Plasticna casa"));

        cal.set(2024, 11, 25);
        Date rok3 = cal.getTime();
        cal.set(2024, 1, 20);
        kvarljivaRoba.add(new KvarljivaRoba("Sir", 800.0, "Srbija", cal.getTime(), "Zlatar Gouda", rok3, "Vakuum"));

        cal.set(2024, 11, 12);
        Date rok4 = cal.getTime();
        cal.set(2024, 1, 5);
        kvarljivaRoba.add(new KvarljivaRoba("Hleb", 80.0, "Srbija", cal.getTime(), "Hleb i Pecivo", rok4, "Najlon kesica"));

        cal.set(2024, 11, 30);
        Date rok5 = cal.getTime();
        cal.set(2024, 1, 25);
        kvarljivaRoba.add(new KvarljivaRoba("Jaja", 350.0, "Srbija", cal.getTime(), "Farma Jaja M", rok5, "Kartonska kutija"));

        cal.set(2024, 11, 18);
        Date rok6 = cal.getTime();
        cal.set(2024, 1, 8);
        kvarljivaRoba.add(new KvarljivaRoba("Meso", 1200.0, "Srbija", cal.getTime(), "Pikant Svinjetina", rok6, "Vakuum"));

        cal.set(2024, 11, 22);
        Date rok7 = cal.getTime();
        cal.set(2024, 1, 12);
        kvarljivaRoba.add(new KvarljivaRoba("Riba", 900.0, "Norveska", cal.getTime(), "Losos File", rok7, "Plasticna folija"));

        cal.set(2024, 11, 28);
        Date rok8 = cal.getTime();
        cal.set(2024, 1, 18);
        kvarljivaRoba.add(new KvarljivaRoba("Voce", 250.0, "Srbija", cal.getTime(), "Jabuke Idared", rok8, "Plasticna kesica"));

        cal.set(2024, 11, 14);
        Date rok9 = cal.getTime();
        cal.set(2024, 1, 3);
        kvarljivaRoba.add(new KvarljivaRoba("Povrce", 180.0, "Srbija", cal.getTime(), "Paradajz", rok9, "Plasticna kesica"));

        cal.set(2024, 11, 26);
        Date rok10 = cal.getTime();
        cal.set(2024, 1, 16);
        kvarljivaRoba.add(new KvarljivaRoba("Smrznut", 450.0, "Srbija", cal.getTime(), "Pingvin Sladoled", rok10, "Kartonska kutija"));
    }
}