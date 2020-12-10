package sahnovi;

import java.awt.Color;

public class Pijun extends Figura {

	private boolean doublestep = false;

	public Pijun(Polje polje, Color boja) {
		super(polje, boja, 1, 'p');

	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		if (slovo < 'a' || slovo > 'h' || broj < '1' || broj > '8')
			return;
		incMove();
		if (this.getBoja() == Color.WHITE) {
			if (broj - this.getPolje().getBroj() == 1 && // korak napred
					slovo - this.getPolje().getSlovo() == 0 && t.findPolje(slovo, broj).getFigura() == null) {
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
				System.out.println("korak napred");
			}
			if (broj - this.getPolje().getBroj() == 2 && // dupli korak napred
					slovo - this.getPolje().getSlovo() == 0 && t.findPolje(slovo, broj).getFigura() == null
					&& getMove() == 1) {
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
				doublestep = true;
				System.out.println("dupli korak");
			}
			if (broj - this.getPolje().getBroj() == 1 && // jedenje ulevo
					slovo - this.getPolje().getSlovo() == -1 && t.findPolje(slovo, broj).getFigura() != null
					&& t.findPolje(slovo, broj).getFigura().getBoja() == Color.BLACK) {
				System.out.println("Pojeo Ulevo");
				t.findPolje(slovo, broj).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == 1 && // enpasant ulevo
					slovo - this.getPolje().getSlovo() == -1 && t.findPolje(slovo, broj).getFigura() == null
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura() != null
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().getBoja() == Color.BLACK
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().getOznaka() == 'p'
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().isEnpasant()) {
				System.out.println("enpasant");
				t.findPolje(slovo, (char) (broj - 1)).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == 1 && // jedenje udesno
					slovo - this.getPolje().getSlovo() == 1 && t.findPolje(slovo, broj).getFigura() != null
					&& t.findPolje(slovo, broj).getFigura().getBoja() == Color.BLACK) {
				System.out.println("pojeo desno");
				t.findPolje(slovo, broj).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == 1 && // enpasant udesno
					slovo - this.getPolje().getSlovo() == 1 && t.findPolje(slovo, broj).getFigura() == null
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura() != null
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().getBoja() == Color.BLACK
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().getOznaka() == 'p'
					&& t.findPolje(slovo, (char) (broj - 1)).getFigura().isEnpasant()) {
				System.out.println("enpasant");
				t.findPolje(slovo, (char) (broj - 1)).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
		} else {
			if (broj - this.getPolje().getBroj() == -1 && // korak unapred
					slovo - this.getPolje().getSlovo() == 0 && t.findPolje(slovo, broj).getFigura() == null) {
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
				System.out.println("korak napred");
			}
			if (broj - this.getPolje().getBroj() == -2 && // dupli korak unapred
					slovo - this.getPolje().getSlovo() == 0 && t.findPolje(slovo, broj).getFigura() == null
					&& getMove() == 1) {
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
				doublestep = true;
				System.out.println("dupli korak");
			}
			if (broj - this.getPolje().getBroj() == -1 && // jedenje ulevo
					slovo - this.getPolje().getSlovo() == -1 && t.findPolje(slovo, broj).getFigura() != null
					&& t.findPolje(slovo, broj).getFigura().getBoja() == Color.WHITE) {
				System.out.println("pojeo levo");
				t.findPolje(slovo, broj).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == -1 && // enpasant ulevo
					slovo - this.getPolje().getSlovo() == -1 && t.findPolje(slovo, broj).getFigura() == null
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura() != null
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().getBoja() == Color.WHITE
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().getOznaka() == 'p'
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().isEnpasant()) {
				System.out.println("enpasant");
				t.findPolje(slovo, (char) (broj + 1)).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == -1 && // jedenje udesno
					slovo - this.getPolje().getSlovo() == 1 && t.findPolje(slovo, broj).getFigura() != null
					&& t.findPolje(slovo, broj).getFigura().getBoja() == Color.WHITE) {
				System.out.println("pojeo desno");
				t.findPolje(slovo, broj).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			if (broj - this.getPolje().getBroj() == -1 && // enpasant udesno
					slovo - this.getPolje().getSlovo() == 1 && t.findPolje(slovo, broj).getFigura() == null
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura() != null
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().getBoja() == Color.WHITE
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().getOznaka() == 'p'
					&& t.findPolje(slovo, (char) (broj + 1)).getFigura().isEnpasant()) {
				System.out.println("enpasant");
				t.findPolje(slovo, (char) (broj + 1)).getFigura().uklonuFiguru();
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
		}
		if (getMove() == 1 && doublestep == true) {
			setEnpasant(true);
		} else {
			setEnpasant(false);
		}
		moved = true;
	}

}
