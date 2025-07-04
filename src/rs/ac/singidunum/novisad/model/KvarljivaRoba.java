package rs.ac.singidunum.novisad.model;

import java.util.Date;

public class KvarljivaRoba extends Roba {
	private Date rokTrajanja;
	private String tipAmbalaze;
	
	public KvarljivaRoba(String naziv, double cena, String zemljaPorekla, Date datumProizvodnje, String model,
			Date rokTrajanja, String tipAmbalaze) {
		super(naziv, cena, zemljaPorekla, datumProizvodnje, model);
		this.rokTrajanja = rokTrajanja;
		this.tipAmbalaze = tipAmbalaze;
	}
	
	public Date getRokTrajanja() {
		return rokTrajanja;
	}
	public void setRokTrajanja(Date rokTrajanja) {
		this.rokTrajanja = rokTrajanja;
	}
	public String getTipAmbalaze() {
		return tipAmbalaze;
	}
	public void setTipAmbalaze(String tipAmbalaze) {
		this.tipAmbalaze = tipAmbalaze;
	}

	@Override
	public String toString() {
		return "KvarljivaRoba [rokTrajanja=" + rokTrajanja + ", tipAmbalaze=" + tipAmbalaze + "]";
	}
	
	
}
