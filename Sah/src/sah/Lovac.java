package sah;

public class Lovac extends Figura {

	public Lovac(Polje p, Boja b) {
		super(p, b);
	}

	@Override
	public String oznaka() {
		return this.boja == Boja.BELA ? "B" : "b";
	}

	@Override
	int igrajFigura(int v, char k, Tabla t) {
		if (this.pojedena == true)
			return 1;
		Polje novopolje = new Polje(v, k);
		if (!this.mozePomeriti(novopolje, t))
			return 1;
		int brojv = novopolje.vrsta - this.polje.vrsta;
		int brojk = novopolje.kolona - this.polje.kolona;
		if (Math.abs(brojk) != Math.abs(brojv))
			return 1;
		if (brojk > 0) {
			if (brojv > 0) {
				int vnext = this.polje.vrsta + 1;
				char knext = (char) (this.polje.kolona + 1);
				Polje next = new Polje(vnext, knext);
				int i = 0;
				for (; i < brojv - 1; i++) {
					if(t.dohvatiFiguru(next) != null)
						break;
					next.kolona++;
					next.vrsta++;
				}
				if(i == brojv - 1) {
					if(t.dohvatiFiguru(novopolje) != null)
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
			else {
				brojv = -brojv;
				int vnext = this.polje.vrsta - 1;
				char knext = (char) (this.polje.kolona + 1);
				Polje next = new Polje(vnext, knext);
				int i = 0;
				for (; i < brojv - 1; i++) {
					if(t.dohvatiFiguru(next) != null)
						break;
					next.kolona++;
					next.vrsta--;
				}
				if(i == brojv - 1) {
					if(t.dohvatiFiguru(novopolje) != null)
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
		else {
			if (brojv > 0) {
				int vnext = this.polje.vrsta + 1;
				char knext = (char) (this.polje.kolona - 1);
				Polje next = new Polje(vnext, knext);
				int i = 0;
				for (; i < brojv - 1; i++) {
					if(t.dohvatiFiguru(next) != null)
						break;
					next.kolona--;
					next.vrsta++;
				}
				if(i == brojv - 1) {
					if(t.dohvatiFiguru(novopolje) != null)
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
			else {
				brojv = -brojv;
				int vnext = this.polje.vrsta - 1;
				char knext = (char) (this.polje.kolona - 1);
				Polje next = new Polje(vnext, knext);
				int i = 0;
				for (; i < brojv - 1; i++) {
					if(t.dohvatiFiguru(next) != null)
						break;
					next.kolona--;
					next.vrsta--;
				}
				if(i == brojv - 1) {
					if(t.dohvatiFiguru(novopolje) != null)
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
		return 0;
	}

}
