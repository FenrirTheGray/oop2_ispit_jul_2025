package rs.ac.singidunum.novisad.model;

public class OdgovornaOsoba {

	private String ime;
	private String prezime;
	private double plata;
	private String zvanje;
	private String stepenObrazovanja;
	
	public OdgovornaOsoba(String ime, String prezime, double plata, String zvanje, String stepenObrazovanja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.plata = plata;
		this.zvanje = zvanje;
		this.stepenObrazovanja = stepenObrazovanja;
	}

	public OdgovornaOsoba() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public String getStepenObrazovanja() {
		return stepenObrazovanja;
	}

	public void setStepenObrazovanja(String stepenObrazovanja) {
		this.stepenObrazovanja = stepenObrazovanja;
	}

	@Override
	public String toString() {
		return "OdgovornaOsoba [ime=" + ime + ", prezime=" + prezime + ", plata=" + plata + ", zvanje=" + zvanje
				+ ", stepenObrazovanja=" + stepenObrazovanja + "]";
	}
	
}
