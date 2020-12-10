package sahnovi;

import java.awt.Color;

public class Kraljica extends Figura {

	public Kraljica(Polje polje, Color boja) {
		super(polje, boja, 12, 'q');
	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		boolean prepreka = false;
		int xprom = slovo - this.getPolje().getSlovo();
		int yprom = broj - this.getPolje().getBroj();
		if (this.getPolje().getSlovo() == slovo) {
			int cnt = broj - this.getPolje().getBroj();
			for (int i = 1; i < Math.abs(cnt); i++) {
				if (t.findPolje(slovo, (char) (this.getPolje().getBroj() + (cnt > 0 ? i : -i))).getFigura() == null)
					continue;
				prepreka = true;
			}
		} else if (this.getPolje().getBroj() == broj) {
			int cnt = slovo - this.getPolje().getSlovo();
			for (int i = 1; i < Math.abs(cnt); i++) {
				if (t.findPolje((char) (this.getPolje().getSlovo() + (cnt > 0 ? i : -i)), broj).getFigura() == null)
					continue;
				prepreka = true;
			}
		} else if (Math.abs(xprom) == Math.abs(yprom)) {
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
		} else
			return;

		if (prepreka == true)
			return;
		pomeri(slovo, broj, t);
	}

}
