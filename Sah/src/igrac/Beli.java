package igrac;

import sah.Konj;
import sah.Kralj;
import sah.Kraljica;
import sah.Lovac;
import sah.Pijun;
import sah.Polje;
import sah.Top;
import sah.Figura.Boja;

public class Beli {

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
	
	public Beli() {
		p1 = new Pijun(new Polje(2, 'A'), Boja.BELA);  p2 = new Pijun(new Polje(2, 'B'), Boja.BELA);
		p3 = new Pijun(new Polje(2, 'C'), Boja.BELA);  p4 = new Pijun(new Polje(2, 'D'), Boja.BELA);
		p5 = new Pijun(new Polje(2, 'E'), Boja.BELA);  p6 = new Pijun(new Polje(2, 'F'), Boja.BELA);
		p7 = new Pijun(new Polje(2, 'G'), Boja.BELA);  p8 = new Pijun(new Polje(2, 'H'), Boja.BELA);
		
		t1 = new Top(new Polje(1, 'A'), Boja.BELA);  t2 = new Top(new Polje(1, 'H'), Boja.BELA);
		
		k1 = new Konj(new Polje(1, 'B'), Boja.BELA);  k2 = new Konj(new Polje(1, 'G'), Boja.BELA);
		
		l1 = new Lovac(new Polje(1, 'C'), Boja.BELA);  l2 = new Lovac(new Polje(1, 'F'), Boja.BELA);
		
		q = new Kraljica(new Polje(1, 'D'), Boja.BELA);  k = new Kralj(new Polje(1, 'E'), Boja.BELA);
	}

}
