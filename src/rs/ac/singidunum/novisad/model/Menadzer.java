package rs.ac.singidunum.novisad.model;

public class Menadzer extends OdgovornaOsoba {
	private Uloga uloga;

	public Menadzer(String ime, String prezime, double plata, String zvanje, String stepenObrazovanja, Uloga uloga) {
		super(ime, prezime, plata, zvanje, stepenObrazovanja);
		this.uloga = uloga;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "Menadzer [uloga=" + uloga + "]";
	}	
}
