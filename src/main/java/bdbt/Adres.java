package bdbt;

public class Adres {
	private int nr_adresu;
	private String miasto;
	private String ulica;
	private int nr_lokalu;
	private String kod_pocztowy;
	private String poczta;
	public Adres() {
		
		
		super();

	}
	public Adres(int nr_adresu, String miasto, String ulica, int nr_lokalu, String kod_pocztowy, String poczta) {
		super();
		this.nr_adresu = nr_adresu;
		this.miasto = miasto;
		this.ulica = ulica;
		this.nr_lokalu = nr_lokalu;
		this.kod_pocztowy = kod_pocztowy;
		this.poczta = poczta;
	}
	public int getNr_adresu() {
		return nr_adresu;
	}
	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getNr_lokalu() {
		return nr_lokalu;
	}
	public void setNr_lokalu(int nr_lokalu) {
		this.nr_lokalu = nr_lokalu;
	}
	public String getKod_pocztowy() {
		return kod_pocztowy;
	}
	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}
	public String getPoczta() {
		return poczta;
	}
	public void setPoczta(String poczta) {
		this.poczta = poczta;
	}
	@Override
	public String toString() {
		return "Adres [nr_adresu=" + nr_adresu + ", miasto=" + miasto + ", ulica=" + ulica + ", nr_lokalu=" + nr_lokalu
				+ ", kod_pocztowy=" + kod_pocztowy + ", poczta=" + poczta + "]";
	}
	
	
	
}
