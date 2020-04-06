package sah;

public class Kralj extends Figura {

	public Kralj(Polje p, Boja b) {
		super(p, b);
		this.id = 1;
	}

	@Override
	public String oznaka() {
		return this.boja == Boja.BELA ? "K" : "k";
	}

	@Override
	int igrajFigura(int v, char k, Tabla t) {
		Polje p = new Polje(v, k);
		if(Math.abs(this.polje.vrsta - p.vrsta)<=1 && Math.abs(this.polje.kolona - p.kolona)<=1
				&& this.mozePomeriti(p, t)) {
			if (t.dohvatiFiguru(p) != null)
				t.dohvatiFiguru(p).pojedena = true;
			if(t.dohvatiFiguru(p) != null && t.dohvatiFiguru(p).pojedena == true && t.dohvatiFiguru(p).id == 1) {
				System.out.println("Kraj igre!");
				System.exit(0);
			}
			t.tabla[p.vrsta - 1][p.kolona - 'A'] = this;
			t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
			this.polje = p;
			return 0;
		}
		else return 1;
	}

}

