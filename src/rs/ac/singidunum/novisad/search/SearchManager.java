package rs.ac.singidunum.novisad.search;

import java.util.Date;
import java.util.List;
import rs.ac.singidunum.novisad.model.*;

public class SearchManager {
    
    private static final String FIELD_NAZIV = "naziv";
    private static final String FIELD_ZEMLJA_POREKLA = "zemljaPorekla";
    private static final String FIELD_MODEL = "model";
    private static final String FIELD_CENA = "cena";
    private static final String FIELD_DATUM_PROIZVODNJE = "datumProizvodnje";
    private static final String FIELD_DUZINA = "duzina";
    private static final String FIELD_SIRINA = "sirina";
    private static final String FIELD_VISINA = "visina";
    private static final String FIELD_RADNI_NAPON = "radniNapon";
    private static final String FIELD_NOMINALNA_SNAGA = "nominalnaSnaga";
    private static final String FIELD_TIP_AMBALAZE = "tipAmbalaze";
    private static final String FIELD_ROK_TRAJANJA = "rokTrajanja";
    private static final String FIELD_IME = "ime";
    private static final String FIELD_PREZIME = "prezime";
    private static final String FIELD_ZVANJE = "zvanje";
    private static final String FIELD_STEPEN_OBRAZOVANJA = "stepenObrazovanja";
    private static final String FIELD_PLATA = "plata";
    private static final String FIELD_RADNO_MESTO = "radnoMesto";
    private static final String FIELD_IME_ULOGE = "imeUloge";
    private static final String FIELD_OPIS_ULOGE = "opisUloge";

    private SearchService<ElektricniUredjaj> elektricniUredjajSearchService;
    private SearchService<KvarljivaRoba> kvarljivaRobaSearchService;
    private SearchService<Menadzer> menadzerSearchService;
    private SearchService<Prodavac> prodavacSearchService;
    private SearchService<Uloga> ulogaSearchService;

    public SearchManager(List<ElektricniUredjaj> elektricniUredjaji,
                         List<KvarljivaRoba> kvarljivaRoba,
                         List<Menadzer> menadzeri,
                         List<Prodavac> prodavci,
                         List<Uloga> uloge) {
        this.elektricniUredjajSearchService = new SearchService<>(elektricniUredjaji);
        this.kvarljivaRobaSearchService = new SearchService<>(kvarljivaRoba);
        this.menadzerSearchService = new SearchService<>(menadzeri);
        this.prodavacSearchService = new SearchService<>(prodavci);
        this.ulogaSearchService = new SearchService<>(uloge);
    }

    
    public List<ElektricniUredjaj> searchElektricniUredjaji(String naziv, String zemljaPorekla, String model,
                                                            Double minCena, Double maxCena,
                                                            Date datumOd, Date datumDo,
                                                            Double minDuzina, Double maxDuzina,
                                                            Double minSirina, Double maxSirina,
                                                            Double minVisina, Double maxVisina,
                                                            Integer minNapon, Integer maxNapon,
                                                            Integer minSnaga, Integer maxSnaga) {
        elektricniUredjajSearchService.clearCriteria();

        if (naziv != null && !naziv.trim().isEmpty()) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_NAZIV, naziv.trim(), false));
        }

        if (zemljaPorekla != null && !zemljaPorekla.trim().isEmpty()) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_ZEMLJA_POREKLA, zemljaPorekla.trim(), false));
        }

        if (model != null && !model.trim().isEmpty()) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_MODEL, model.trim(), false));
        }

        if (minCena != null || maxCena != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_CENA, minCena, maxCena));
        }

        if (datumOd != null || datumDo != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createDateRangeSearch(FIELD_DATUM_PROIZVODNJE, datumOd, datumDo));
        }

        if (minDuzina != null || maxDuzina != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_DUZINA, minDuzina, maxDuzina));
        }

        if (minSirina != null || maxSirina != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_SIRINA, minSirina, maxSirina));
        }

        if (minVisina != null || maxVisina != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_VISINA, minVisina, maxVisina));
        }

        if (minNapon != null || maxNapon != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_RADNI_NAPON,
                            minNapon != null ? minNapon.doubleValue() : null,
                            maxNapon != null ? maxNapon.doubleValue() : null));
        }

        if (minSnaga != null || maxSnaga != null) {
            elektricniUredjajSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_NOMINALNA_SNAGA,
                            minSnaga != null ? minSnaga.doubleValue() : null,
                            maxSnaga != null ? maxSnaga.doubleValue() : null));
        }

        return elektricniUredjajSearchService.search();
    }

    
    public List<KvarljivaRoba> searchKvarljivaRoba(String naziv, String zemljaPorekla, String model, String tipAmbalaze,
                                                   Double minCena, Double maxCena,
                                                   Date datumProizvodnjeOd, Date datumProizvodnjeDo,
                                                   Date rokTrajanjaOd, Date rokTrajanjaDo) {
        kvarljivaRobaSearchService.clearCriteria();

        if (naziv != null && !naziv.trim().isEmpty()) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_NAZIV, naziv.trim(), false));
        }

        if (zemljaPorekla != null && !zemljaPorekla.trim().isEmpty()) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_ZEMLJA_POREKLA, zemljaPorekla.trim(), false));
        }

        if (model != null && !model.trim().isEmpty()) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_MODEL, model.trim(), false));
        }

        if (tipAmbalaze != null && !tipAmbalaze.trim().isEmpty()) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_TIP_AMBALAZE, tipAmbalaze.trim(), false));
        }

        if (minCena != null || maxCena != null) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_CENA, minCena, maxCena));
        }

        if (datumProizvodnjeOd != null || datumProizvodnjeDo != null) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createDateRangeSearch(FIELD_DATUM_PROIZVODNJE, datumProizvodnjeOd, datumProizvodnjeDo));
        }

        if (rokTrajanjaOd != null || rokTrajanjaDo != null) {
            kvarljivaRobaSearchService.addCriteria(
                    SearchCriteriaFactory.createDateRangeSearch(FIELD_ROK_TRAJANJA, rokTrajanjaOd, rokTrajanjaDo));
        }

        return kvarljivaRobaSearchService.search();
    }

    
    public List<Menadzer> searchMenadzeri(String ime, String prezime, String zvanje, String stepenObrazovanja,
                                          Double minPlata, Double maxPlata, String imeUloge, String opisUloge) {
        menadzerSearchService.clearCriteria();

        if (ime != null && !ime.trim().isEmpty()) {
            menadzerSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_IME, ime.trim(), false));
        }

        if (prezime != null && !prezime.trim().isEmpty()) {
            menadzerSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_PREZIME, prezime.trim(), false));
        }

        if (zvanje != null && !zvanje.trim().isEmpty()) {
            menadzerSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_ZVANJE, zvanje.trim(), false));
        }

        if (stepenObrazovanja != null && !stepenObrazovanja.trim().isEmpty()) {
            menadzerSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_STEPEN_OBRAZOVANJA, stepenObrazovanja.trim(), false));
        }

        if (minPlata != null || maxPlata != null) {
            menadzerSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_PLATA, minPlata, maxPlata));
        }

        if (imeUloge != null && !imeUloge.trim().isEmpty()) {
            menadzerSearchService.addCriteria(new UlogaImeSearchCriteria(imeUloge.trim()));
        }

        if (opisUloge != null && !opisUloge.trim().isEmpty()) {
            menadzerSearchService.addCriteria(new UlogaOpisSearchCriteria(opisUloge.trim()));
        }

        return menadzerSearchService.search();
    }

    public List<Prodavac> searchProdavci(String ime, String prezime, String zvanje, String stepenObrazovanja,
                                         Double minPlata, Double maxPlata, String radnoMesto,
                                         String imeNadredjenog, String prezimeNadredjenog) {
        prodavacSearchService.clearCriteria();

        if (ime != null && !ime.trim().isEmpty()) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_IME, ime.trim(), false));
        }

        if (prezime != null && !prezime.trim().isEmpty()) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_PREZIME, prezime.trim(), false));
        }

        if (zvanje != null && !zvanje.trim().isEmpty()) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_ZVANJE, zvanje.trim(), false));
        }

        if (stepenObrazovanja != null && !stepenObrazovanja.trim().isEmpty()) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_STEPEN_OBRAZOVANJA, stepenObrazovanja.trim(), false));
        }

        if (minPlata != null || maxPlata != null) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createNumericRangeSearch(FIELD_PLATA, minPlata, maxPlata));
        }

        if (radnoMesto != null && !radnoMesto.trim().isEmpty()) {
            prodavacSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_RADNO_MESTO, radnoMesto.trim(), false));
        }

        if (imeNadredjenog != null && !imeNadredjenog.trim().isEmpty()) {
            prodavacSearchService.addCriteria(new NadredjeniImeSearchCriteria(imeNadredjenog.trim()));
        }

        if (prezimeNadredjenog != null && !prezimeNadredjenog.trim().isEmpty()) {
            prodavacSearchService.addCriteria(new NadredjeniPrezimeSearchCriteria(prezimeNadredjenog.trim()));
        }

        return prodavacSearchService.search();
    }

    
    public List<Uloga> searchUloge(String ime, String opis) {
        ulogaSearchService.clearCriteria();

        if (ime != null && !ime.trim().isEmpty()) {
            ulogaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_IME_ULOGE, ime.trim(), false));
        }

        if (opis != null && !opis.trim().isEmpty()) {
            ulogaSearchService.addCriteria(
                    SearchCriteriaFactory.createStringSearch(FIELD_OPIS_ULOGE, opis.trim(), false));
        }

        return ulogaSearchService.search();
    }

    public void clearAllCriteria() {
        if (elektricniUredjajSearchService != null) {
            elektricniUredjajSearchService.clearCriteria();
        }
        if (kvarljivaRobaSearchService != null) {
            kvarljivaRobaSearchService.clearCriteria();
        }
        if (menadzerSearchService != null) {
            menadzerSearchService.clearCriteria();
        }
        if (prodavacSearchService != null) {
            prodavacSearchService.clearCriteria();
        }
        if (ulogaSearchService != null) {
            ulogaSearchService.clearCriteria();
        }
    }

    
    private static class UlogaImeSearchCriteria implements SearchCriteria<Object> {
        private final String searchValue;

        public UlogaImeSearchCriteria(String searchValue) {
            this.searchValue = searchValue.toLowerCase();
        }

        @Override
        public boolean matches(Object object) {
            if (object instanceof Menadzer) {
                Menadzer menadzer = (Menadzer) object;
                return menadzer.getUloga() != null &&
                        menadzer.getUloga().getImeUloge() != null &&
                        menadzer.getUloga().getImeUloge().toLowerCase().contains(searchValue);
            }
            return false;
        }
    }

    private static class UlogaOpisSearchCriteria implements SearchCriteria<Object> {
        private final String searchValue;

        public UlogaOpisSearchCriteria(String searchValue) {
            this.searchValue = searchValue.toLowerCase();
        }

        @Override
        public boolean matches(Object object) {
            if (object instanceof Menadzer) {
                Menadzer menadzer = (Menadzer) object;
                return menadzer.getUloga() != null &&
                        menadzer.getUloga().getOpisUloge() != null &&
                        menadzer.getUloga().getOpisUloge().toLowerCase().contains(searchValue);
            }
            return false;
        }
    }

    private static class NadredjeniImeSearchCriteria implements SearchCriteria<Object> {
        private final String searchValue;

        public NadredjeniImeSearchCriteria(String searchValue) {
            this.searchValue = searchValue.toLowerCase();
        }

        @Override
        public boolean matches(Object object) {
            if (object instanceof Prodavac) {
                Prodavac prodavac = (Prodavac) object;
                return prodavac.getNadredjeni() != null &&
                        prodavac.getNadredjeni().getIme() != null &&
                        prodavac.getNadredjeni().getIme().toLowerCase().contains(searchValue);
            }
            return false;
        }
    }

    private static class NadredjeniPrezimeSearchCriteria implements SearchCriteria<Object> {
        private final String searchValue;

        public NadredjeniPrezimeSearchCriteria(String searchValue) {
            this.searchValue = searchValue.toLowerCase();
        }

        @Override
        public boolean matches(Object object) {
            if (object instanceof Prodavac) {
                Prodavac prodavac = (Prodavac) object;
                return prodavac.getNadredjeni() != null &&
                        prodavac.getNadredjeni().getPrezime() != null &&
                        prodavac.getNadredjeni().getPrezime().toLowerCase().contains(searchValue);
            }
            return false;
        }
    }
}