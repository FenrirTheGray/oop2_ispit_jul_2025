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

        uloge.add(new Uloga("Generalni direktor", "Upravlja celim preduzecem"));
        uloge.add(new Uloga("Menadzer prodaje", "Odgovoran za prodaju"));
        uloge.add(new Uloga("Finansijski direktor", "Upravlja finansijama"));
        uloge.add(new Uloga("HR menadzer", "Upravlja ljudskim resursima"));
        uloge.add(new Uloga("IT menadzer", "Upravlja IT infrastrukturom"));
        uloge.add(new Uloga("Marketing menadzer", "Odgovoran za marketing"));
        uloge.add(new Uloga("Operativni menadzer", "Upravlja operacijama"));
        uloge.add(new Uloga("Kvalitet menadzer", "Kontrola kvaliteta"));
        uloge.add(new Uloga("Bezbednosni menadzer", "Odgovoran za bezbednost"));
        uloge.add(new Uloga("Logistički menadzer", "Upravlja logistikom"));

        menadzeri.add(new Menadzer("Marko", "Petrović", 120000.0, "Generalni direktor", "Magistar", uloge.get(0)));
        menadzeri.add(new Menadzer("Ana", "Nikolić", 95000.0, "Menadzer prodaje", "Diplomirani Menadzer", uloge.get(1)));
        menadzeri.add(new Menadzer("Miloš", "Jovanović", 110000.0, "Finansijski direktor", "Magistar", uloge.get(2)));
        menadzeri.add(new Menadzer("Jelena", "Stojanović", 88000.0, "HR menadzer", "Diplomirani Menadzer", uloge.get(3)));
        menadzeri.add(new Menadzer("Stefan", "Milić", 100000.0, "IT menadzer", "Magistar", uloge.get(4)));
        menadzeri.add(new Menadzer("Milica", "Đorđević", 85000.0, "Marketing menadzer", "Diplomirani Menadzer", uloge.get(5)));
        menadzeri.add(new Menadzer("Nikola", "Marković", 92000.0, "Operativni menadzer", "Diplomirani Menadzer", uloge.get(6)));
        menadzeri.add(new Menadzer("Tamara", "Popović", 90000.0, "Kvalitet menadzer", "Magistar", uloge.get(7)));
        menadzeri.add(new Menadzer("Vladimir", "Stanković", 87000.0, "Bezbednosni menadzer", "Diplomirani Menadzer", uloge.get(8)));
        menadzeri.add(new Menadzer("Jovana", "Radić", 93000.0, "Logistički menadzer", "Diplomirani Menadzer", uloge.get(9)));

        prodavci.add(new Prodavac("Petar", "Milenković", 55000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 1"));
        prodavci.add(new Prodavac("Marija", "Savić", 48000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 2"));
        prodavci.add(new Prodavac("Aleksandar", "Ilić", 52000.0, "Stariji prodavac", "Više", menadzeri.get(1), "Prodavnica 1"));
        prodavci.add(new Prodavac("Katarina", "Vasić", 47000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 3"));
        prodavci.add(new Prodavac("Milan", "Ristić", 58000.0, "Vodja smene", "Više", menadzeri.get(1), "Prodavnica 2"));
        prodavci.add(new Prodavac("Teodora", "Mitrović", 45000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 4"));
        prodavci.add(new Prodavac("Nemanja", "Stojanović", 51000.0, "Prodavac", "Više", menadzeri.get(1), "Prodavnica 1"));
        prodavci.add(new Prodavac("Danijela", "Živković", 49000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 3"));
        prodavci.add(new Prodavac("Uroš", "Petković", 56000.0, "Stariji prodavac", "Više", menadzeri.get(1), "Prodavnica 2"));
        prodavci.add(new Prodavac("Milena", "Nikolić", 46000.0, "Prodavac", "Srednje", menadzeri.get(1), "Prodavnica 4"));

        Calendar cal = Calendar.getInstance();

        cal.set(2023, Calendar.JANUARY, 15);
        elektricniUredjaji.add(new ElektricniUredjaj("Frižider Samsung", 85000.0, "Južna Koreja", cal.getTime(), "RB34T675FSA", 60.0f, 70.0f, 185.0f, 220, 200));

        cal.set(2023, Calendar.FEBRUARY, 10);
        elektricniUredjaji.add(new ElektricniUredjaj("Veš mašina LG", 65000.0, "Južna Koreja", cal.getTime(), "F4WV512S0E", 60.0f, 56.0f, 85.0f, 220, 1400));

        cal.set(2023, Calendar.MARCH, 5);
        elektricniUredjaji.add(new ElektricniUredjaj("Šporet Bosch", 75000.0, "Nemačka", cal.getTime(), "HKR390050", 60.0f, 60.0f, 85.0f, 220, 3000));

        cal.set(2023, Calendar.APRIL, 20);
        elektricniUredjaji.add(new ElektricniUredjaj("Mikrotalasna Panasonic", 25000.0, "Japan", cal.getTime(), "NN-ST45KW", 51.0f, 40.0f, 31.0f, 220, 1000));

        cal.set(2023, Calendar.MAY, 12);
        elektricniUredjaji.add(new ElektricniUredjaj("Usisivač Dyson", 45000.0, "Velika Britanija", cal.getTime(), "V11 Absolute", 25.0f, 25.0f, 126.0f, 220, 545));

        cal.set(2023, Calendar.JUNE, 8);
        elektricniUredjaji.add(new ElektricniUredjaj("Klima Daikin", 120000.0, "Japan", cal.getTime(), "FTXM50R", 80.0f, 29.0f, 22.0f, 220, 1800));

        cal.set(2023, Calendar.JULY, 25);
        elektricniUredjaji.add(new ElektricniUredjaj("TV Sony", 95000.0, "Japan", cal.getTime(), "KD-55X80K", 123.0f, 71.0f, 8.0f, 220, 150));

        cal.set(2023, Calendar.AUGUST, 14);
        elektricniUredjaji.add(new ElektricniUredjaj("Sudoomašina Siemens", 72000.0, "Nemačka", cal.getTime(), "SN23HI60CE", 60.0f, 55.0f, 81.5f, 220, 2400));

        cal.set(2023, Calendar.SEPTEMBER, 3);
        elektricniUredjaji.add(new ElektricniUredjaj("Aspirator Gorenje", 18000.0, "Slovenija", cal.getTime(), "WHT623E6XBG", 60.0f, 47.0f, 15.0f, 220, 280));

        cal.set(2023, Calendar.OCTOBER, 18);
        elektricniUredjaji.add(new ElektricniUredjaj("Mašina za kafu DeLonghi", 35000.0, "Italija", cal.getTime(), "ECAM22.110.B", 24.0f, 43.0f, 35.0f, 220, 1450));

        cal.set(2024, Calendar.JANUARY, 10);
        Date proizvodnja1 = cal.getTime();
        cal.set(2024, Calendar.MARCH, 10);
        Date rokTrajanja1 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Mleko", 150.0, "Srbija", proizvodnja1, "Dukat 3.2%", rokTrajanja1, "Tetrapack"));

        cal.set(2024, Calendar.JANUARY, 15);
        Date proizvodnja2 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 15);
        Date rokTrajanja2 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Jogurt", 120.0, "Srbija", proizvodnja2, "Imlek prirodni", rokTrajanja2, "Plastična čaša"));

        cal.set(2024, Calendar.FEBRUARY, 1);
        Date proizvodnja3 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 20);
        Date rokTrajanja3 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Svež sir", 250.0, "Srbija", proizvodnja3, "Zlatiborski", rokTrajanja3, "Vakuum"));

        cal.set(2024, Calendar.JANUARY, 20);
        Date proizvodnja4 = cal.getTime();
        cal.set(2024, Calendar.APRIL, 20);
        Date rokTrajanja4 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Kačkavalj", 800.0, "Srbija", proizvodnja4, "Sombor", rokTrajanja4, "Vakuum"));

        cal.set(2024, Calendar.FEBRUARY, 5);
        Date proizvodnja5 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 12);
        Date rokTrajanja5 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Piletina", 450.0, "Srbija", proizvodnja5, "Perutnina Ptuj", rokTrajanja5, "Plastična kesa"));

        cal.set(2024, Calendar.JANUARY, 25);
        Date proizvodnja6 = cal.getTime();
        cal.set(2024, Calendar.MARCH, 25);
        Date rokTrajanja6 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Viršle", 320.0, "Srbija", proizvodnja6, "Matijević", rokTrajanja6, "Vakuum"));

        cal.set(2024, Calendar.FEBRUARY, 2);
        Date proizvodnja7 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 9);
        Date rokTrajanja7 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Sveže voće", 200.0, "Srbija", proizvodnja7, "Jabuke Greni", rokTrajanja7, "Plastična kesa"));

        cal.set(2024, Calendar.JANUARY, 12);
        Date proizvodnja8 = cal.getTime();
        cal.set(2024, Calendar.JANUARY, 19);
        Date rokTrajanja8 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Kruh", 80.0, "Srbija", proizvodnja8, "Hleb i kifle", rokTrajanja8, "Plastična kesa"));

        cal.set(2024, Calendar.FEBRUARY, 8);
        Date proizvodnja9 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 22);
        Date rokTrajanja9 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Jaja", 300.0, "Srbija", proizvodnja9, "Zdravo jaje", rokTrajanja9, "Kartonska kutija"));

        cal.set(2024, Calendar.JANUARY, 30);
        Date proizvodnja10 = cal.getTime();
        cal.set(2024, Calendar.MARCH, 30);
        Date rokTrajanja10 = cal.getTime();
        kvarljivaRoba.add(new KvarljivaRoba("Margarin", 180.0, "Srbija", proizvodnja10, "Vital", rokTrajanja10, "Plastična kutija"));

        MainWindow mw = new MainWindow(elektricniUredjaji, kvarljivaRoba, menadzeri, prodavci, uloge);
        mw.init();
    }
}