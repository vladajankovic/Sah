package sah;

public class Polje {

	protected int vrsta;
	protected char kolona;

	public Polje(int vrsta, char kolona) {
		this.vrsta = vrsta;
		if(kolona >= 'a')
			kolona = (char)(kolona - 32);
		this.kolona = kolona;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(this.kolona).append(this.vrsta);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Polje other = (Polje) obj;
		if (kolona != other.kolona) {
			return false;
		}
		if (vrsta != other.vrsta) {
			return false;
		}
		return true;
	}

}
