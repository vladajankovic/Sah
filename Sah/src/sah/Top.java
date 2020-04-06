package sah;

public class Top extends Figura {

	public Top(Polje p, Boja b) {
		super(p, b);
	}

	@Override
	int igrajFigura(int v, char k, Tabla t) {
		if (this.pojedena == true)
			return 1;
		Polje novopolje = new Polje(v, k);
		if (this.mozePomeriti(novopolje, t)) {
			if (this.polje.vrsta == novopolje.vrsta) {
				int brojk = novopolje.kolona - this.polje.kolona;
				if (brojk > 0) {
					int vnext = this.polje.vrsta;
					char knext = (char) (this.polje.kolona + 1);
					Polje next = new Polje(vnext, knext);
					int i = 0;
					for (; i < brojk - 1; i++) {
						if (t.dohvatiFiguru(next) != null)
							break;
						next.kolona++;
					}
					if (i == brojk - 1) {
						if (t.dohvatiFiguru(novopolje) != null)
							t.dohvatiFiguru(novopolje).pojedena = true;
						if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
							System.out.println("Kraj igre!");
							System.exit(0);
						}
						t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
						t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
						this.polje = novopolje;
					}
				} else {
					brojk = -brojk;
					int vnext = this.polje.vrsta;
					char knext = (char) (this.polje.kolona - 1);
					Polje next = new Polje(vnext, knext);
					int i = 0;
					for (; i < brojk - 1; i++) {
						if (t.dohvatiFiguru(next) != null)
							break;
						next.kolona--;
					}
					if (i == brojk - 1) {
						if (t.dohvatiFiguru(novopolje) != null)
							t.dohvatiFiguru(novopolje).pojedena = true;
						if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
							System.out.println("Kraj igre!");
							System.exit(0);
						}
						t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
						t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
						this.polje = novopolje;
					}
				}
			}
			if (this.polje.kolona == novopolje.kolona) {
				int brojv = novopolje.vrsta - this.polje.vrsta;
				if (brojv > 0) {
					int vnext = this.polje.vrsta + 1;
					char knext = this.polje.kolona;
					Polje next = new Polje(vnext, knext);
					int i = 0;
					for (; i < brojv - 1; i++) {
						if (t.dohvatiFiguru(next) != null)
							break;
						next.vrsta++;
					}
					if (i == brojv - 1) {
						if (t.dohvatiFiguru(novopolje) != null)
							t.dohvatiFiguru(novopolje).pojedena = true;
						if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
							System.out.println("Kraj igre!");
							System.exit(0);
						}
						t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
						t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
						this.polje = novopolje;
					}
				} else {
					brojv = -brojv;
					int vnext = this.polje.vrsta - 1;
					char knext = this.polje.kolona;
					Polje next = new Polje(vnext, knext);
					int i = 0;
					for (; i < brojv - 1; i++) {
						if (t.dohvatiFiguru(next) != null)
							break;
						next.vrsta--;
					}
					if (i == brojv - 1) {
						if (t.dohvatiFiguru(novopolje) != null)
							t.dohvatiFiguru(novopolje).pojedena = true;
						if(t.dohvatiFiguru(novopolje) != null && t.dohvatiFiguru(novopolje).pojedena == true && t.dohvatiFiguru(novopolje).id == 1) {
							System.out.println("Kraj igre!");
							System.exit(0);
						}
						t.tabla[novopolje.vrsta - 1][novopolje.kolona - 'A'] = this;
						t.tabla[this.polje.vrsta - 1][this.polje.kolona - 'A'] = null;
						this.polje = novopolje;
					}
				}
			}
		}
		return 0;
	}

	@Override
	public String oznaka() {
		return this.boja == Boja.BELA ? "T" : "t";
	}

}
