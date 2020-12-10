package sahnovi;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

@SuppressWarnings("serial")
public class Tabla extends Panel {

	private Polje[][] matricaPolja;
	private int visina, sirina;
	
	protected boolean whiteturn;
	
	class BeliIgrac{
		private Pijun[] pijuniBeli;
		private Top[] topoviBeli;
		private Konj[] konjiBeli;
		private Lovac[] lovacBeli;
		private Kraljica kraljicaBela;
		private Kralj kraljBeli;
		
		public BeliIgrac() {
			pijuniBeli = new Pijun[sirina];
			for (int i = 0; i < sirina; i++) {
				pijuniBeli[i] = new Pijun(matricaPolja[6][i], Color.WHITE);
				matricaPolja[6][i].setFigura(pijuniBeli[i]);
			}
			topoviBeli = new Top[2];
			for (int i = 0, j = 0; j < 2; i += 7, j++) {
				topoviBeli[j] = new Top(matricaPolja[7][i], Color.WHITE);
				matricaPolja[7][i].setFigura(topoviBeli[j]);
			}
			konjiBeli = new Konj[2];
			for (int i = 1, j = 0; j < 2; i += 5, j++) {
				konjiBeli[j] = new Konj(matricaPolja[7][i], Color.WHITE);
				matricaPolja[7][i].setFigura(konjiBeli[j]);
			}
			lovacBeli = new Lovac[2];
			for (int i = 2, j = 0; j < 2; i += 3, j++) {
				lovacBeli[j] = new Lovac(matricaPolja[7][i], Color.WHITE);
				matricaPolja[7][i].setFigura(lovacBeli[j]);
			}
			kraljicaBela = new Kraljica(matricaPolja[7][3], Color.WHITE);
			matricaPolja[7][3].setFigura(kraljicaBela);
			kraljBeli = new Kralj(matricaPolja[7][4], Color.WHITE);
			matricaPolja[7][4].setFigura(kraljBeli);
		}
	}
	
	class CrniIgrac{
		private Pijun[] pijuniCrni;
		private Top[] topoviCrni;
		private Konj[] konjiCrni;
		private Lovac[] lovacCrni;
		private Kraljica kraljicaCrna;
		private Kralj kraljCrni;
		
		public CrniIgrac() {
			pijuniCrni = new Pijun[sirina];
			for (int i = 0; i < sirina; i++) {
				pijuniCrni[i] = new Pijun(matricaPolja[1][i], Color.BLACK);
				matricaPolja[1][i].setFigura(pijuniCrni[i]);
			}
			topoviCrni = new Top[2];
			for (int i = 0, j = 0; j < 2; i += 7, j++) {
				topoviCrni[j] = new Top(matricaPolja[0][i], Color.BLACK);
				matricaPolja[0][i].setFigura(topoviCrni[j]);
			}
			konjiCrni = new Konj[2];
			for (int i = 1, j = 0; j < 2; i += 5, j++) {
				konjiCrni[j] = new Konj(matricaPolja[0][i], Color.BLACK);
				matricaPolja[0][i].setFigura(konjiCrni[j]);
			}
			lovacCrni = new Lovac[2];
			for (int i = 2, j = 0; j < 2; i += 3, j++) {
				lovacCrni[j] = new Lovac(matricaPolja[0][i], Color.BLACK);
				matricaPolja[0][i].setFigura(lovacCrni[j]);
			}
			kraljicaCrna = new Kraljica(matricaPolja[0][3], Color.BLACK);
			matricaPolja[0][3].setFigura(kraljicaCrna);
			kraljCrni = new Kralj(matricaPolja[0][4], Color.BLACK);
			matricaPolja[0][4].setFigura(kraljCrni);
		}
	}

	protected Figura selektovana;
	protected Polje selektovanopolje;
	
	protected BeliIgrac beliIgrac;
	protected CrniIgrac crniIgrac;

	public Tabla(int visina, int sirina) {
		super();
		setLayout(new GridLayout(visina, sirina));
		this.visina = visina;
		this.sirina = sirina;
		this.matricaPolja = new Polje[visina][sirina];
		for (int i = 0; i < visina; i++) {
			for (int j = 0; j < sirina; j++) {
				matricaPolja[i][j] = new Polje((i + j) % 2 == 0 ? Color.WHITE : Color.GREEN, (char) ('8' - i),
						(char) ('a' + j), this);
				add(matricaPolja[i][j]);
			}
		}
		
		beliIgrac = new BeliIgrac();
		crniIgrac = new CrniIgrac();
		
	}

	public void iscrtaj() {
		for (int i = 0; i < visina; i++)
			for (int j = 0; j < sirina; j++)
				this.matricaPolja[i][j].iscrtaj();
	}

	public Polje[][] getMatricaPolja() {
		return matricaPolja;
	}

	public Polje findPolje(char slovo, char broj) {
		return matricaPolja['8' - broj][slovo - 'h' + 7];
	}

	public Figura getSelektovana() {
		return selektovana;
	}

	public Polje getSelektovanopolje() {
		return selektovanopolje;
	}

	public void setSelektovana(Figura selektovana) {
		this.selektovana = selektovana;
		this.selektovanopolje = selektovana == null? null:selektovana.getPolje();
		if(selektovana != null)
			System.out.println(selektovanopolje.getSlovo() + " " + selektovanopolje.getBroj());
	}

}
