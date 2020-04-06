package igrac;

import sah.Konj;
import sah.Kralj;
import sah.Kraljica;
import sah.Lovac;
import sah.Pijun;
import sah.Polje;
import sah.Top;
import sah.Figura.Boja;

public class Crni {
	
	public static Pijun p1;
	public static Pijun p2;
	public static Pijun p3;
	public static Pijun p4;
	public static Pijun p5;
	public static Pijun p6;
	public static Pijun p7;
	public static Pijun p8;
	public static Top t1, t2;
	public static Konj k1, k2;
	public static Lovac l1, l2;
	public static Kraljica q;
	public static Kralj k;

	public Crni() {
		p1 = new Pijun(new Polje(7, 'A'), Boja.CRNA);  p2 = new Pijun(new Polje(7, 'B'), Boja.CRNA);
		p3 = new Pijun(new Polje(7, 'C'), Boja.CRNA);  p4 = new Pijun(new Polje(7, 'D'), Boja.CRNA);
		p5 = new Pijun(new Polje(7, 'E'), Boja.CRNA);  p6 = new Pijun(new Polje(7, 'F'), Boja.CRNA);
		p7 = new Pijun(new Polje(7, 'G'), Boja.CRNA);  p8 = new Pijun(new Polje(7, 'H'), Boja.CRNA);
		
		t1 = new Top(new Polje(8, 'A'), Boja.CRNA);  t2 = new Top(new Polje(8, 'H'), Boja.CRNA);
		
		k1 = new Konj(new Polje(8, 'B'), Boja.CRNA);  k2 = new Konj(new Polje(8, 'G'), Boja.CRNA);
		
		l1 = new Lovac(new Polje(8, 'C'), Boja.CRNA);  l2 = new Lovac(new Polje(8, 'F'), Boja.CRNA);
		
		q = new Kraljica(new Polje(8, 'D'), Boja.CRNA);  k = new Kralj(new Polje(8, 'E'), Boja.CRNA);
	}

}
