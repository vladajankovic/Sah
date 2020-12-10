package sahnovi;

import java.awt.Color;

public class Kralj extends Figura {

	public Kralj(Polje polje, Color boja) {
		super(polje, boja, 0, 'k');
	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		if (Math.abs(slovo - this.getPolje().getSlovo()) > 1 || Math.abs(broj - this.getPolje().getBroj()) > 1)
			return;
		// provera u linijama
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() + 1); i <= 'h'; i++) {
			if (t.findPolje(i, broj).getFigura() == null)
				continue;
			if (t.findPolje(i, broj).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, broj).getFigura().getOznaka();
			if (oznaka == 'r' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() - 1); i >= 'a'; i--) {
			if (t.findPolje(i, broj).getFigura() == null)
				continue;
			if (t.findPolje(i, broj).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, broj).getFigura().getOznaka();
			if (oznaka == 'r' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getBroj() + 1); i <= '8'; i++) {
			if (t.findPolje(slovo, i).getFigura() == null)
				continue;
			if (t.findPolje(slovo, i).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(slovo, i).getFigura().getOznaka();
			if (oznaka == 'r' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getBroj() - 1); i >= '1'; i--) {
			if (t.findPolje(slovo, i).getFigura() == null)
				continue;
			if (t.findPolje(slovo, i).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(slovo, i).getFigura().getOznaka();
			if (oznaka == 'r' || oznaka == 'q')
				return;
			else
				break;
		}
		System.out.println("prosla provera linija");
		// provera dijagonala
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() + 1), j = (char) (t.findPolje(slovo, broj).getBroj()
				+ 1); i <= 'h' && j <= '8'; i++, j++) {
			if (t.findPolje(i, j).getFigura() == null)
				continue;
			if (t.findPolje(i, j).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, j).getFigura().getOznaka();
			if (oznaka == 'b' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() + 1), j = (char) (t.findPolje(slovo, broj).getBroj()
				- 1); i <= 'h' && j >= '1'; i++, j--) {
			if (t.findPolje(i, j).getFigura() == null)
				continue;
			if (t.findPolje(i, j).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, j).getFigura().getOznaka();
			if (oznaka == 'b' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() - 1), j = (char) (t.findPolje(slovo, broj).getBroj()
				- 1); i >= 'a' && j >= '1'; i--, j--) {
			if (t.findPolje(i, j).getFigura() == null)
				continue;
			if (t.findPolje(i, j).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, j).getFigura().getOznaka();
			if (oznaka == 'b' || oznaka == 'q')
				return;
			else
				break;
		}
		for (char i = (char) (t.findPolje(slovo, broj).getSlovo() - 1), j = (char) (t.findPolje(slovo, broj).getBroj()
				+ 1); i >= 'a' && j <= '8'; i--, j++) {
			if (t.findPolje(i, j).getFigura() == null)
				continue;
			if (t.findPolje(i, j).getFigura().getBoja() == this.getBoja())
				break;
			char oznaka = t.findPolje(i, j).getFigura().getOznaka();
			if (oznaka == 'b' || oznaka == 'q')
				return;
			else
				break;
		}
		System.out.println("prosla provera dijagonala");
		// provera za konja
		int[] niz1 = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] niz2 = { 2, 1, -1, -2, -2, -1, 1, 2 };
		for (int i = 0; i < 8; i++) {
			char tst1 = (char) (slovo + niz1[i]);
			char tst2 = (char) (broj + niz2[i]);
			if (tst1 < 'a' || tst1 > 'h' || tst2 < '1' || tst2 > '8')
				continue;
			if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura() != null) {
				if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura().getBoja() == this
						.getBoja())
					continue;
				if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura().getOznaka() == 'n')
					return;
			}
		}
		System.out.println("prosla provera konja");
		// provera za kralja
		niz1 = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
		niz2 = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };
		for (int i = 0; i < 8; i++) {
			char tst1 = (char) (slovo + niz1[i]);
			char tst2 = (char) (broj + niz2[i]);
			if (tst1 < 'a' || tst1 > 'h' || tst2 < '1' || tst2 > '8')
				continue;
			if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura() != null) {
				if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura().getBoja() == this
						.getBoja())
					continue;
				if (t.findPolje((char) (slovo + niz1[i]), (char) (broj + niz2[i])).getFigura().getOznaka() == 'k')
					return;
			}
		}
		System.out.println("prosla provera kraljeva");
		// provera za pijune
		if (this.getBoja() == Color.WHITE) {
			char slovo1 = (char) (slovo - 1), broj1 = (char) (broj + 1);
			char slovo3 = (char) (slovo + 1);
			if (broj1 <= '8') {
				if (slovo1 >= 'a') {
					if (t.findPolje(slovo1, broj1).getFigura() != null
							&& t.findPolje(slovo1, broj1).getFigura().getBoja() == Color.BLACK
							&& t.findPolje(slovo1, broj1).getFigura().getOznaka() == 'p')
						return;
				}

				if (slovo3 <= 'h') {
					if (t.findPolje(slovo3, broj1).getFigura() != null
							&& t.findPolje(slovo3, broj1).getFigura().getBoja() == Color.BLACK
							&& t.findPolje(slovo3, broj1).getFigura().getOznaka() == 'p')
						return;
				}
			}

		} else {
			char slovo1 = (char) (slovo - 1), broj1 = (char) (broj - 1);
			char slovo3 = (char) (slovo + 1);
			if (broj1 >= '1') {
				if (slovo1 >= 'a') {
					if (t.findPolje(slovo1, broj1).getFigura() != null
							&& t.findPolje(slovo1, broj1).getFigura().getBoja() == Color.WHITE
							&& t.findPolje(slovo1, broj1).getFigura().getOznaka() == 'p')
						return;
				}

				if (slovo3 <= 'h') {
					if (t.findPolje(slovo3, broj1).getFigura() != null
							&& t.findPolje(slovo3, broj1).getFigura().getBoja() == Color.WHITE
							&& t.findPolje(slovo3, broj1).getFigura().getOznaka() == 'p')
						return;
				}
			}
		}
		System.out.println("prosla provera pijuna");

		System.out.println(true);
		pomeri(slovo, broj, t);

	}

}
