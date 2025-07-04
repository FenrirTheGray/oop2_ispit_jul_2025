package rs.ac.singidunum.novisad.util;

import rs.ac.singidunum.novisad.model.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileManager {
    private static final String SEPARATOR = "|";
    private static final String GROUP_SEPARATOR = "$";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void sacuvajSveObjekte(String filename,
                                         ArrayList<ElektricniUredjaj> elektricniUredjaji,
                                         ArrayList<KvarljivaRoba> kvarljivaRoba,
                                         ArrayList<Menadzer> menadzeri,
                                         ArrayList<Prodavac> prodavci,
                                         ArrayList<Uloga> uloge) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (ElektricniUredjaj uredjaj : elektricniUredjaji) {
                writer.write(prevediObjekatUString(uredjaj));
                writer.newLine();
            }
            writer.write(GROUP_SEPARATOR);
            writer.newLine();

            for (KvarljivaRoba roba : kvarljivaRoba) {
                writer.write(prevediObjekatUString(roba));
                writer.newLine();
            }
            writer.write(GROUP_SEPARATOR);
            writer.newLine();

            for (Menadzer menadzer : menadzeri) {
                writer.write(prevediObjekatUString(menadzer));
                writer.newLine();
            }
            writer.write(GROUP_SEPARATOR);
            writer.newLine();

            for (Prodavac prodavac : prodavci) {
                writer.write(prevediObjekatUString(prodavac));
                writer.newLine();
            }
            writer.write(GROUP_SEPARATOR);
            writer.newLine();

            for (Uloga uloga : uloge) {
                writer.write(prevediObjekatUString(uloga));
                writer.newLine();
            }
        }
    }

    private static String prevediObjekatUString(Object obj) {
        if (obj instanceof ElektricniUredjaj) {
            ElektricniUredjaj e = (ElektricniUredjaj) obj;
            return String.join(SEPARATOR,
                    e.getNaziv(),
                    String.valueOf(e.getCena()),
                    e.getZemljaPorekla(),
                    dateFormat.format(e.getDatumProizvodnje()),
                    e.getModel(),
                    String.valueOf(e.getDuzina()),
                    String.valueOf(e.getSirina()),
                    String.valueOf(e.getVisina()),
                    String.valueOf(e.getRadniNapon()),
                    String.valueOf(e.getNominalnaSnaga())
            );
        } else if (obj instanceof KvarljivaRoba) {
            KvarljivaRoba k = (KvarljivaRoba) obj;
            return String.join(SEPARATOR,
                    k.getNaziv(),
                    String.valueOf(k.getCena()),
                    k.getZemljaPorekla(),
                    dateFormat.format(k.getDatumProizvodnje()),
                    k.getModel(),
                    dateFormat.format(k.getRokTrajanja()),
                    k.getTipAmbalaze()
            );
        } else if (obj instanceof Menadzer) {
            Menadzer m = (Menadzer) obj;
            return String.join(SEPARATOR,
                    m.getIme(),
                    m.getPrezime(),
                    String.valueOf(m.getPlata()),
                    m.getZvanje(),
                    m.getStepenObrazovanja(),
                    m.getUloga().getImeUloge(),
                    m.getUloga().getOpisUloge()
            );
        } else if (obj instanceof Prodavac) {
            Prodavac p = (Prodavac) obj;
            return String.join(SEPARATOR,
                    p.getIme(),
                    p.getPrezime(),
                    String.valueOf(p.getPlata()),
                    p.getZvanje(),
                    p.getStepenObrazovanja(),
                    p.getNadredjeni().getIme(),
                    p.getNadredjeni().getPrezime(),
                    p.getRadnoMesto()
            );
        } else if (obj instanceof Uloga) {
            Uloga u = (Uloga) obj;
            return String.join(SEPARATOR,
                    u.getImeUloge(),
                    u.getOpisUloge()
            );
        }
        return "";
    }

    public static void ucitajSveObjekte(String filename,
                                        ArrayList<ElektricniUredjaj> elektricniUredjaji,
                                        ArrayList<KvarljivaRoba> kvarljivaRoba,
                                        ArrayList<Menadzer> menadzeri,
                                        ArrayList<Prodavac> prodavci,
                                        ArrayList<Uloga> uloge) throws IOException, ParseException {

        elektricniUredjaji.clear();
        kvarljivaRoba.clear();
        menadzeri.clear();
        prodavci.clear();
        uloge.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int currentGroup = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(GROUP_SEPARATOR)) {
                    currentGroup++;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEPARATOR);

                switch (currentGroup) {
                    case 0:
                        if (parts.length >= 10) {
                            ElektricniUredjaj uredjaj = new ElektricniUredjaj(
                                    parts[0],
                                    Double.parseDouble(parts[1]),
                                    parts[2],
                                    dateFormat.parse(parts[3]),
                                    parts[4],
                                    Float.parseFloat(parts[5]),
                                    Float.parseFloat(parts[6]),
                                    Float.parseFloat(parts[7]),
                                    Integer.parseInt(parts[8]),
                                    Integer.parseInt(parts[9])
                            );
                            elektricniUredjaji.add(uredjaj);
                        }
                        break;

                    case 1:
                        if (parts.length >= 7) {
                            KvarljivaRoba roba = new KvarljivaRoba(
                                    parts[0],
                                    Double.parseDouble(parts[1]),
                                    parts[2],
                                    dateFormat.parse(parts[3]),
                                    parts[4],
                                    dateFormat.parse(parts[5]),
                                    parts[6]
                            );
                            kvarljivaRoba.add(roba);
                        }
                        break;

                    case 2:
                        if (parts.length >= 7) {
                            Uloga uloga = nadjiUlogu(parts[5], parts[6], uloge);

                            Menadzer menadzer = new Menadzer(
                                    parts[0],
                                    parts[1],
                                    Double.parseDouble(parts[2]),
                                    parts[3],
                                    parts[4],
                                    uloga
                            );
                            menadzeri.add(menadzer);
                        }
                        break;

                    case 3:
                        if (parts.length >= 8) {
                            Menadzer nadredjeni = nadjiMenadzeraPoImenu(parts[5], parts[6], menadzeri);

                            if (nadredjeni != null) {
                                Prodavac prodavac = new Prodavac(
                                        parts[0],
                                        parts[1],
                                        Double.parseDouble(parts[2]),
                                        parts[3],
                                        parts[4],
                                        nadredjeni,
                                        parts[7]
                                );
                                prodavci.add(prodavac);
                            }
                        }
                        break;

                    case 4:
                        if (parts.length >= 2) {
                            boolean exists = uloge.stream()
                                    .anyMatch(u -> u.getImeUloge().equals(parts[0]));

                            if (!exists) {
                                Uloga uloga = new Uloga(
                                        parts[0],
                                        parts[1]
                                );
                                uloge.add(uloga);
                            }
                        }
                        break;
                }
            }
        }
    }

    private static Uloga nadjiUlogu(String imeUloge, String opisUloge, ArrayList<Uloga> uloge) {
        for (Uloga u : uloge) {
            if (u.getImeUloge().equals(imeUloge)) {
                return u;
            }
        }

        Uloga newUloga = new Uloga(imeUloge, opisUloge);
        uloge.add(newUloga);
        return newUloga;
    }

    private static Menadzer nadjiMenadzeraPoImenu(String ime, String prezime, ArrayList<Menadzer> menadzeri) {
        for (Menadzer m : menadzeri) {
            if (m.getIme().equals(ime) && m.getPrezime().equals(prezime)) {
                return m;
            }
        }
        return null;
    }
}