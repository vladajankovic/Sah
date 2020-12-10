package sahnovi;

import java.awt.Color;

public class Konj extends Figura {

	public Konj(Polje polje, Color boja) {
		super(polje, boja, 3, 'n');
	}

	@Override
	public void pomeriFiguruNaPolje(char slovo, char broj, Tabla t) {
		if((slovo-this.getPolje().getSlovo() == 1 && broj-this.getPolje().getBroj() == 2) ||
				(slovo-this.getPolje().getSlovo() == 2 && broj-this.getPolje().getBroj() == 1) ||
				(slovo-this.getPolje().getSlovo() == 2 && broj-this.getPolje().getBroj() == -1) ||
				(slovo-this.getPolje().getSlovo() == 1 && broj-this.getPolje().getBroj() == -2) ||
				(slovo-this.getPolje().getSlovo() == -1 && broj-this.getPolje().getBroj() == -2) ||
				(slovo-this.getPolje().getSlovo() == -2 && broj-this.getPolje().getBroj() == -1) ||
				(slovo-this.getPolje().getSlovo() == -2 && broj-this.getPolje().getBroj() == 1) ||
				(slovo-this.getPolje().getSlovo() == -1 && broj-this.getPolje().getBroj() == 2)) {
			if(t.findPolje(slovo, broj).getFigura() == null ||
					(t.findPolje(slovo, broj).getFigura() != null && 
					t.findPolje(slovo, broj).getFigura().getBoja() == (this.getBoja() == Color.WHITE?Color.BLACK:Color.WHITE))) {
				if(t.findPolje(slovo, broj).getFigura() != null) {
					t.findPolje(slovo, broj).getFigura().uklonuFiguru();
				}
				this.uklonuFiguru();
				this.setPolje(t.findPolje(slovo, broj));
				t.findPolje(slovo, broj).setFigura(this);
			}
			moved = true;
		}

	}

}
