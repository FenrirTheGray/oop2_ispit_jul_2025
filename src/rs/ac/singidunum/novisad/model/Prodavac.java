package rs.ac.singidunum.novisad.model;

public class Prodavac extends OdgovornaOsoba {
	private Menadzer nadredjeni;
	private String radnoMesto;
	
	public Prodavac(String ime, String prezime, double plata, String zvanje, String stepenObrazovanja,
			Menadzer nadredjeni, String radnoMesto) {
		super(ime, prezime, plata, zvanje, stepenObrazovanja);
		this.nadredjeni = nadredjeni;
		this.radnoMesto = radnoMesto;
	}
	public Menadzer getNadredjeni() {
		return nadredjeni;
	}
	public void setNadredjeni(Menadzer nadredjeni) {
		this.nadredjeni = nadredjeni;
	}
	public String getRadnoMesto() {
		return radnoMesto;
	}
	public void setRadnoMesto(String radnoMesto) {
		this.radnoMesto = radnoMesto;
	}
	@Override
	public String toString() {
		return "Prodavac [nadredjeni=" + nadredjeni + ", radnoMesto=" + radnoMesto + "]";
	}
	
}
