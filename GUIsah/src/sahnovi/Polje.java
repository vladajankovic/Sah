package sahnovi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Polje extends Panel {

	private Figura figura;
	private Color bojaPolja;
	private char broj, slovo;
	private JLabel l = new JLabel();
	private Tabla tabla;

	public Polje(Color bojaPolja, char broj, char slovo, Tabla t) {
		super();
		this.bojaPolja = bojaPolja;
		this.broj = broj;
		this.slovo = slovo;
		this.tabla = t;
		setBackground(this.bojaPolja);
		add(l);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (tabla.getSelektovana() == null) {
					
					if (figura == null)
						return;
					
					if (tabla.whiteturn == true && figura.getBoja() == Color.BLACK)
						return;
					if (tabla.whiteturn == false && figura.getBoja() == Color.WHITE)
						return;
					 
					setBackground(Color.RED);
					tabla.setSelektovana(figura);
					System.out.println("select");
					
				} 
				else {
					
					tabla.getSelektovana().pomeriFiguruNaPolje(slovo, broj, t);
					if(!istopolje(slovo, broj)) {
						if(tabla.whiteturn == true) {
							tabla.whiteturn = false;
						}
						else
							tabla.whiteturn = true;
					}
					tabla.setSelektovana(null);
					tabla.iscrtaj();
					System.out.println("moved");
					
				}
			}

		});
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
		iscrtaj();
	}

	public Color getBojaPolja() {
		return bojaPolja;
	}

	public char getBroj() {
		return broj;
	}

	public char getSlovo() {
		return slovo;
	}

	public String getOznaka() {
		StringBuilder sb = new StringBuilder();
		sb.append(slovo).append(broj);
		return sb.toString();
	}

	public void iscrtaj() {
		setBackground(bojaPolja);
		if (figura == null) {
			l.setText("");
			return;
		}
		l.setText(this.figura.getUtf());
		l.setFont(new Font("a", Font.BOLD, 40));
	}
	
	private boolean istopolje(char slovo, char broj) {
		System.out.println(tabla.getSelektovanopolje().getSlovo() +" " +tabla.getSelektovanopolje().getBroj());
		System.out.println(tabla.getSelektovana().getPolje().getSlovo() +" "+tabla.getSelektovana().getPolje().getBroj());
		if(tabla.getSelektovanopolje().getSlovo() == tabla.getSelektovana().getPolje().getSlovo() &&
				tabla.getSelektovanopolje().getBroj() == tabla.getSelektovana().getPolje().getBroj())
			return true;
		else return false;
	}

}
