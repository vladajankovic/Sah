package sah;

public abstract class Figura {

	protected Polje polje;
	protected Boja boja;
	protected boolean pojedena = false;
	int id = 0;

	public enum Boja {
		CRNA, BELA
	}

	public Figura(Polje p, Boja b) {
		this.polje = p;
		this.boja = b;
	}

	public abstract String oznaka();

	@Override
	public String toString() {
		return this.oznaka();
	}

	boolean mozePomeriti(Polje p, Tabla t) {
		if (this.polje.equals(p))
			return false;
		if (t.dohvatiFiguru(p) == null || t.dohvatiFiguru(p).boja != boja)
			return true;
		return false;

	}

	abstract int igrajFigura(int v, char k, Tabla t);

}
