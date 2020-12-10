package sahnovi;

import java.awt.Color;

public abstract class Figura {

	private Polje polje;
	private Color bojaFigure;
	private int verdnost;
	private char oznaka;
	private String utf;
	private int move = 0;
	private boolean enpasant = false;
	protected boolean moved = false;

	public Figura(Polje polje, Color boja, int verdnost, char oznaka) {
		super();
		this.polje = polje;
		this.bojaFigure = boja;
		this.verdnost = verdnost;
		this.oznaka = oznaka;
		setUtf();
	}

	public String getUtf() {
		return utf;
	}

	private void setUtf() {
		switch (oznaka) {
		case 'p': {
			utf = bojaFigure == Color.WHITE ? "\u2659" : "\u265F";
			break;
		}
		case 'r': {
			utf = bojaFigure == Color.WHITE ? "\u2656" : "\u265C";
			break;
		}
		case 'n': {
			utf = bojaFigure == Color.WHITE ? "\u2658" : "\u265E";
			break;
		}
		case 'b': {
			utf = bojaFigure == Color.WHITE ? "\u2657" : "\u265D";
			break;
		}
		case 'q': {
			utf = bojaFigure == Color.WHITE ? "\u2655" : "\u265B";
			break;
		}
		case 'k': {
			utf = bojaFigure == Color.WHITE ? "\u2654" : "\u265A";
			break;
		}
		}
	}

	public Polje getPolje() {
		return polje;
	}

	public void setPolje(Polje polje) {
		this.polje = polje;
	}

	public Color getBoja() {
		return bojaFigure;
	}

	public int getVerdnost() {
		return verdnost;
	}

	public void setVerdnost(int verdnost) {
		this.verdnost = verdnost;
	}

	public char getOznaka() {
		return oznaka;
	}

	public void setOznaka(char oznaka) {
		this.oznaka = oznaka;
	}

	public abstract void pomeriFiguruNaPolje(char slovo, char broj, Tabla t);

	public void pomeri(char slovo, char broj, Tabla t) {
		if (t.findPolje(slovo, broj).getFigura() == null
				|| (t.findPolje(slovo, broj).getFigura() != null && t.findPolje(slovo, broj).getFigura()
						.getBoja() == (this.getBoja() == Color.WHITE ? Color.BLACK : Color.WHITE))) {
			if (t.findPolje(slovo, broj).getFigura() != null) {
				t.findPolje(slovo, broj).getFigura().uklonuFiguru();
			}
			this.uklonuFiguru();
			this.setPolje(t.findPolje(slovo, broj));
			t.findPolje(slovo, broj).setFigura(this);
			
		}
	}

	public void uklonuFiguru() {
		this.polje.setFigura(null);
		this.polje = null;
	}

	public int getMove() {
		return move;
	}

	public void incMove() {
		move++;
	}

	public boolean isEnpasant() {
		return enpasant;
	}

	public void setEnpasant(boolean enpasant) {
		this.enpasant = enpasant;
	}

}
