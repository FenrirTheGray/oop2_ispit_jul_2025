package rs.ac.singidunum.novisad.model;

import java.util.Date;

public class Roba {
	
	private String naziv;
	private double cena;
	private String zemljaPorekla;
	private Date datumProizvodnje;
	private String model;
	
	public Roba(String naziv, double cena, String zemljaPorekla, Date datumProizvodnje, String model) {
		super();
		this.naziv = naziv;
		this.cena = cena;
		this.zemljaPorekla = zemljaPorekla;
		this.datumProizvodnje = datumProizvodnje;
		this.model = model;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getZemljaPorekla() {
		return zemljaPorekla;
	}
	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}
	public Date getDatumProizvodnje() {
		return datumProizvodnje;
	}
	public void setDatumProizvodnje(Date datumProizvodnje) {
		this.datumProizvodnje = datumProizvodnje;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Roba [naziv=" + naziv + ", cena=" + cena + ", zemljaPorekla=" + zemljaPorekla + ", datumProizvodnje="
				+ datumProizvodnje + ", model=" + model + "]";
	}
	
}
