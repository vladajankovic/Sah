package sahnovi;

import java.awt.Color;

public class Lovac extends Figura {

	public Lovac(Polje polje, Color boja) {
		super(polje, boja, 3, 'b');
	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		boolean prepreka = false;
		int xprom = slovo - this.getPolje().getSlovo();
		int yprom = broj - this.getPolje().getBroj();
		if (Math.abs(xprom) == Math.abs(yprom)) {
			System.out.println(true);
			System.out.println(xprom);
			System.out.println(yprom);
			for (int i = 1; i < Math.abs(xprom); i++) {
				if (t.findPolje((char) (this.getPolje().getSlovo() + (xprom > 0 ? i : -i)),
						(char) (this.getPolje().getBroj() + (yprom > 0 ? i : -i))).getFigura() == null) {
					System.out.println("a1");
					continue;
				}
				prepreka = true;
				System.out.println("a");
			}
			if (prepreka == true)
				return;
			pomeri(slovo, broj, t);
		}
	}

}
