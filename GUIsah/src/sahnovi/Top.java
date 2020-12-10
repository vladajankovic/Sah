package sahnovi;

import java.awt.Color;

public class Top extends Figura {

	public Top(Polje polje, Color boja) {
		super(polje, boja, 6, 'r');
	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		boolean prepreka = false;
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
		} else
			return;

		if (prepreka == true)
			return;
		pomeri(slovo, broj, t);

	}

}
