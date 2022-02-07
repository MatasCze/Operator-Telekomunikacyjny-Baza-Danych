package bdbt;

public class Usluga {
	private int nr_uslugi;
	private String nazwa;
	private String opis;
	private String data_od;
	private String data_do;
	private String cena;
	private int nr_punktu_sprzedazy;
	private int nr_klienta;
	
	
	
	
	public Usluga() {
		super();

	}
	
	
	public Usluga(int nr_uslugi, String nazwa, String opis, String data_od, String data_do, String cena,
			int nr_punktu_sprzedazy, int nr_klienta) {
		super();
		this.nr_uslugi = nr_uslugi;
		this.nazwa = nazwa;
		this.opis = opis;
		this.data_od = data_od;
		this.data_do = data_do;
		this.cena = cena;
		this.nr_punktu_sprzedazy = nr_punktu_sprzedazy;
		this.nr_klienta = nr_klienta;
	}
	
	
	public int getNr_uslugi() {
		return nr_uslugi;
	}
	public void setNr_uslugi(int nr_uslugi) {
		this.nr_uslugi = nr_uslugi;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getData_od() {
		return data_od;
	}
	public void setData_od(String data_od) {
		this.data_od = data_od;
	}
	public String getData_do() {
		return data_do;
	}
	public void setData_do(String data_do) {
		this.data_do = data_do;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public int getNr_punktu_sprzedazy() {
		return nr_punktu_sprzedazy;
	}
	public void setNr_punktu_sprzedazy(int nr_punktu_sprzedazy) {
		this.nr_punktu_sprzedazy = nr_punktu_sprzedazy;
	}
	public int getNr_klienta() {
		return nr_klienta;
	}
	public void setNr_klienta(int nr_klienta) {
		this.nr_klienta = nr_klienta;
	}


	@Override
	public String toString() {
		return "Usluga [nr_uslugi=" + nr_uslugi + ", nazwa=" + nazwa + ", opis=" + opis + ", data_od=" + data_od
				+ ", data_do=" + data_do + ", cena=" + cena + ", nr_punktu_sprzedazy=" + nr_punktu_sprzedazy
				+ ", nr_klienta=" + nr_klienta + "]";
	}
	
	

	
}
