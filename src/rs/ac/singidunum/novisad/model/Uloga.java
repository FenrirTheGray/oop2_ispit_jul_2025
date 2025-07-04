package rs.ac.singidunum.novisad.model;

public class Uloga {
	private String imeUloge;
	private String opisUloge;
	
	public Uloga(String imeUloge, String opisUloge) {
		super();
		this.imeUloge = imeUloge;
		this.opisUloge = opisUloge;
	}

	public String getImeUloge() {
		return imeUloge;
	}

	public void setImeUloge(String imeUloge) {
		this.imeUloge = imeUloge;
	}

	public String getOpisUloge() {
		return opisUloge;
	}

	public void setOpisUloge(String opisUloge) {
		this.opisUloge = opisUloge;
	}

	@Override
	public String toString() {
		return "Uloga [imeUloge=" + imeUloge + ", opisUloge=" + opisUloge + "]";
	}
	
}
