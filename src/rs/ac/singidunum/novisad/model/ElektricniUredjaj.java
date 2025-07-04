package rs.ac.singidunum.novisad.model;

import java.util.Date;

public class ElektricniUredjaj extends Roba {
	private float duzina;
	private float sirina;
	private float visina;
	private int radniNapon;
	private int nominalnaSnaga;
	
	public ElektricniUredjaj(String naziv, double cena, String zemljaPorekla, Date datumProizvodnje, String model,
			float duzina, float sirina, float visina, int radniNapon, int nominalnaSnaga) {
		super(naziv, cena, zemljaPorekla, datumProizvodnje, model);
		this.duzina = duzina;
		this.sirina = sirina;
		this.visina = visina;
		this.radniNapon = radniNapon;
		this.nominalnaSnaga = nominalnaSnaga;
	}
	
	public float getDuzina() {
		return duzina;
	}
	public void setDuzina(float duzina) {
		this.duzina = duzina;
	}
	public float getSirina() {
		return sirina;
	}
	public void setSirina(float sirina) {
		this.sirina = sirina;
	}
	public float getVisina() {
		return visina;
	}
	public void setVisina(float visina) {
		this.visina = visina;
	}
	public int getRadniNapon() {
		return radniNapon;
	}
	public void setRadniNapon(int radniNapon) {
		this.radniNapon = radniNapon;
	}
	public int getNominalnaSnaga() {
		return nominalnaSnaga;
	}
	public void setNominalnaSnaga(int nominalnaSnaga) {
		this.nominalnaSnaga = nominalnaSnaga;
	}

	@Override
	public String toString() {
		return "ElektricniUredjaj [duzina=" + duzina + ", sirina=" + sirina + ", visina=" + visina + ", radniNapon="
				+ radniNapon + ", nominalnaSnaga=" + nominalnaSnaga + "]";
	}
}
