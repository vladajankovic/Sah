package sah;

public class Pijun extends Figura {

	public Pijun(Polje p, Boja b) {
		super(p, b);
	}

	@Override
	boolean mozePomeriti(Polje p, Tabla t) {

		if (this.boja == Boja.BELA) {
			if (this.polje.equals(p))
				return false;
			if (this.polje.vrsta - p.vrsta != -1)
				return false;
			if (Math.abs(this.polje.kolona - p.kolona) > 1)
				return false;
			int v = this.polje.vrsta + 1;
			char kl = (char) (this.polje.kolona - 1);
			char ks = this.polje.kolona;
			char kd = (char) (this.polje.kolona + 1);
			Polje pl = new Polje(v, kl);
			Polje ps = new Polje(v, ks);
			Polje pd = new Polje(v, kd);
			if (p.equals(pl) && (pl.kolona >= 'A') && (t.dohvatiFiguru(pl) != null)
					&& (t.dohvatiFiguru(pl).boja != this.boja))
				return true;
			if (p.equals(ps)) {
				if (t.dohvatiFiguru(ps) == null)
					return true;
				else
					return false;
			}
			if (p.equals(pd) && (pd.kolona <= 'H') && (t.dohvatiFiguru(pd) != null)
					&& (t.dohvatiFiguru(pl).boja != this.boja))
				return true;
			return false;

		} else {
			if (this.polje.equals(p))
				return false;
			if (this.polje.vrsta - p.vrsta != 1)
				return false;
			if (Math.abs(this.polje.kolona - p.kolona) > 1)
				return false;
			int v = this.polje.vrsta - 1;
			char kl = (char) (this.polje.kolona - 1);
			char ks = this.polje.kolona;
			char kd = (char) (this.polje.kolona + 1);
			Polje pl = new Polje(v, kl);
			Polje ps = new Polje(v, ks);
			Polje pd = new Polje(v, kd);
			if (p.equals(pl) && (pl.kolona >= 'A') && (t.dohvatiFiguru(pl) != null)
					&& (t.dohvatiFiguru(pl).boja != this.boja))
				return true;
			if (p.equals(ps)) {
				if (t.dohvatiFiguru(ps) == null)
					return true;
				else
					return false;
			}
			if (p.equals(pd) && (pd.kolona <= 'H') && (t.dohvatiFiguru(pd) != null)
					&& (t.dohvatiFiguru(pl).boja != this.boja))
				return true;
			return false;
		}
	}

	@Override
	int igrajFigura(int v, char k, Tabla t) {
		if (this.pojedena == true)
			return 1;
		Polje novopolje = new Polje(v, k);
		if (this.boja == Boja.BELA) {
			if (this.mozePomeriti(novopolje, t)) {
				if (t.dohvatiFiguru(novopolje) != null)
					t.dohvatiFiguru(novopolje).pojedena = true;
				if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
					System.out.println("Kraj igre!");
					System.exit(0);
				}
				t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
				t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
				this.polje = novopolje;
			} else {
				return 1;
			}
		} else {
			if (this.mozePomeriti(novopolje, t)) {
				if (t.dohvatiFiguru(novopolje) != null)
					t.dohvatiFiguru(novopolje).pojedena = true;
				if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
					System.out.println("Kraj igre!");
					System.exit(0);
				}
				t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
				t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
				this.polje = novopolje;
			} else {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String oznaka() {
		return this.boja == Boja.BELA ? "P" : "p";
	}

}
