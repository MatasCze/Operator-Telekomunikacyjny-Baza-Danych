package bdbt;

public class Operatorzy {
	/* Field */
	private int nr_operatora;
	private String nazwa;
	private String data_zalozenia;
	private int nr_adresu;

	/* Constructor for super */

	public Operatorzy() {

	}

	/* Constructor */

	public Operatorzy(int nr_operatora, String nazwa, String data_zalozenia, int nr_adresu) {
		super();
		this.nr_operatora = nr_operatora;
		this.nazwa = nazwa;
		this.data_zalozenia = data_zalozenia;
		this.nr_adresu = nr_adresu;
	}
	
	/* Get and set */
	
	public int getNr_operatora() {
		return nr_operatora;
	}

	public void setNr_operatora(int nr_operatora) {
		this.nr_operatora = nr_operatora;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getData_zalozenia() {
		return data_zalozenia;
	}

	public void setData_zalozenia(String data_zalozenia) {
		this.data_zalozenia = data_zalozenia;
	}

	public int getNr_adresu() {
		return nr_adresu;
	}

	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}
	
	/* toString() */
	
	@Override
	public String toString() {
		return "Operatorzy [nr_operatora=" + nr_operatora + ", nazwa=" + nazwa + ", data_zalozenia=" + data_zalozenia
				+ ", nr_adresu=" + nr_adresu + "]";
	}

	
	
}
