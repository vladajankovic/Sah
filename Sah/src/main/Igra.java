package main;

import igrac.Beli;
import igrac.Crni;
import sah.Tabla;

public class Igra {
	
	public Beli beli;
	public Crni crni;
	public Tabla tabla;

	public Igra() {
		beli = new Beli();
		crni = new Crni();
		tabla = new Tabla();
		
		tabla.postaviFiguru(Beli.p1); tabla.postaviFiguru(Beli.p2); tabla.postaviFiguru(Beli.p3); tabla.postaviFiguru(Beli.p4);
		tabla.postaviFiguru(Beli.p5); tabla.postaviFiguru(Beli.p6); tabla.postaviFiguru(Beli.p7); tabla.postaviFiguru(Beli.p8);
		tabla.postaviFiguru(Beli.t1); tabla.postaviFiguru(Beli.t2); tabla.postaviFiguru(Beli.k1); tabla.postaviFiguru(Beli.k2);
		tabla.postaviFiguru(Beli.l1); tabla.postaviFiguru(Beli.l2); tabla.postaviFiguru(Beli.q); tabla.postaviFiguru(Beli.k);
		
		tabla.postaviFiguru(Crni.p1); tabla.postaviFiguru(Crni.p2); tabla.postaviFiguru(Crni.p3); tabla.postaviFiguru(Crni.p4);
		tabla.postaviFiguru(Crni.p5); tabla.postaviFiguru(Crni.p6); tabla.postaviFiguru(Crni.p7); tabla.postaviFiguru(Crni.p8);
		tabla.postaviFiguru(Crni.t1); tabla.postaviFiguru(Crni.t2); tabla.postaviFiguru(Crni.k1); tabla.postaviFiguru(Crni.k2);
		tabla.postaviFiguru(Crni.l1); tabla.postaviFiguru(Crni.l2); tabla.postaviFiguru(Crni.q); tabla.postaviFiguru(Crni.k);
	}

	@Override
	public String toString() {
		return tabla.toString();
	}
	
	

}
