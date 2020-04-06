package sah;

public class Konj extends Figura {
	
	

	public Konj(Polje p, Boja b) {
		super(p, b);
	}

	@Override
	public String oznaka() {
		return this.boja == Boja.BELA ? "N" : "n";
	}

	@Override
	int igrajFigura(int v, char k, Tabla t) {
		if (this.pojedena == true)
			return 1;
		Polje novopolje = new Polje(v, k);
		int v1 = this.polje.vrsta + 1; char k1 = (char)(this.polje.kolona - 2); 
		int v2 = this.polje.vrsta + 2; char k2 = (char)(this.polje.kolona - 1); 
		int v3 = this.polje.vrsta + 2; char k3 = (char)(this.polje.kolona + 1); 
		int v4 = this.polje.vrsta + 1; char k4 = (char)(this.polje.kolona + 2); 
		int v5 = this.polje.vrsta - 1; char k5 = (char)(this.polje.kolona + 2); 
		int v6 = this.polje.vrsta - 2; char k6 = (char)(this.polje.kolona + 1); 
		int v7 = this.polje.vrsta - 2; char k7 = (char)(this.polje.kolona - 1); 
		int v8 = this.polje.vrsta - 1; char k8 = (char)(this.polje.kolona - 2); 
		Polje p1 = new Polje(v1, k1); Polje p2 = new Polje(v2, k2);
		Polje p3 = new Polje(v3, k3); Polje p4 = new Polje(v4, k4);
		Polje p5 = new Polje(v5, k5); Polje p6 = new Polje(v6, k6);
		Polje p7 = new Polje(v7, k7); Polje p8 = new Polje(v8, k8);
		
		if(novopolje.equals(p1) || novopolje.equals(p2) || novopolje.equals(p3) || novopolje.equals(p4) || 
				novopolje.equals(p5) || novopolje.equals(p6) || novopolje.equals(p7) || novopolje.equals(p8)) {
			if(this.mozePomeriti(novopolje, t)) {
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
		return 0;
	}

}
