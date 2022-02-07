package bdbt;

public class Klient {
	private int nr_klienta;
	private String imie;
	private String nazwisko;
	private String data_urodzenia;
	private String plec;
	private String pesel;
	private String nr_telefonu;
	private int nr_operatora;
	private int nr_adresu;
	
	
	
	public Klient() {

	}



	public Klient(int nr_klienta, String imie, String nazwisko, String data_urodzenia, String plec, String pesel,
			String nr_telefonu, int nr_operatora, int nr_adresu) {
		super();
		this.nr_klienta = nr_klienta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.pesel = pesel;
		this.nr_telefonu = nr_telefonu;
		this.nr_operatora = nr_operatora;
		this.nr_adresu = nr_adresu;
	}



	public int getNr_klienta() {
		return nr_klienta;
	}



	public void setNr_klienta(int nr_klienta) {
		this.nr_klienta = nr_klienta;
	}



	public String getImie() {
		return imie;
	}



	public void setImie(String imie) {
		this.imie = imie;
	}



	public String getNazwisko() {
		return nazwisko;
	}



	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}



	public String getData_urodzenia() {
		return data_urodzenia;
	}



	public void setData_urodzenia(String data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}



	public String getPlec() {
		return plec;
	}



	public void setPlec(String plec) {
		this.plec = plec;
	}



	public String getPesel() {
		return pesel;
	}



	public void setPesel(String pesel) {
		this.pesel = pesel;
	}



	public String getNr_telefonu() {
		return nr_telefonu;
	}



	public void setNr_telefonu(String nr_telefonu) {
		this.nr_telefonu = nr_telefonu;
	}



	public int getNr_operatora() {
		return nr_operatora;
	}



	public void setNr_operatora(int nr_operatora) {
		this.nr_operatora = nr_operatora;
	}



	public int getNr_adresu() {
		return nr_adresu;
	}



	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}



	@Override
	public String toString() {
		return "Klient [nr_klienta=" + nr_klienta + ", imie=" + imie + ", nazwisko=" + nazwisko + ", data_urodzenia="
				+ data_urodzenia + ", plec=" + plec + ", pesel=" + pesel + ", nr_telefonu=" + nr_telefonu
				+ ", nr_operatora=" + nr_operatora + ", nr_adresu=" + nr_adresu + "]";
	}



	
	
	
	
}
