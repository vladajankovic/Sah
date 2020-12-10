package sahnovi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Igra extends Frame {
	
	private Tabla tabla;
	//private boolean kraj = false;

	public Igra() {
		super("Sah");
		setBounds(100, 100, 515, 544);
		setResizable(false);
		populate();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// kraj = true;
				dispose();
			}
		});
		setVisible(true);
		tabla.whiteturn = true;
		
	}

	private void populate() {
		setBackground(Color.ORANGE.darker().darker().darker());
		this.tabla = new Tabla(8, 8);
		add(tabla, BorderLayout.CENTER);

		Panel topchar = new Panel(new GridLayout(1, 8));
		topchar.setBackground(Color.ORANGE.darker().darker().darker());
		topchar.setForeground(Color.WHITE);
		for (int i = 0; i < 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append((char) ('a' + i));
			Label l = new Label(sb.toString(), Label.CENTER);
			l.setFont(new Font("a", Font.BOLD, 15));
			topchar.add(l);
		}
		add(topchar, BorderLayout.NORTH);

		Panel botchar = new Panel(new GridLayout(1, 8));
		botchar.setBackground(Color.ORANGE.darker().darker().darker());
		botchar.setForeground(Color.WHITE);
		for (int i = 0; i < 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append((char) ('a' + i));
			Label l = new Label(sb.toString(), Label.CENTER);
			l.setFont(new Font("a", Font.BOLD, 15));
			botchar.add(l);
		}
		add(botchar, BorderLayout.SOUTH);

		Panel leftnum = new Panel(new GridLayout(8, 1));
		leftnum.setBackground(Color.ORANGE.darker().darker().darker());
		leftnum.setForeground(Color.WHITE);
		for (int i = 0; i < 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append((char) ('8' - i));
			Label l = new Label(sb.toString(), Label.CENTER);
			l.setFont(new Font("a", Font.BOLD, 15));
			leftnum.add(l);
		}
		add(leftnum, BorderLayout.EAST);

		Panel rightnum = new Panel(new GridLayout(8, 1));
		rightnum.setBackground(Color.ORANGE.darker().darker().darker());
		rightnum.setForeground(Color.WHITE);
		for (int i = 0; i < 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append((char) ('8' - i));
			Label l = new Label(sb.toString(), Label.CENTER);
			l.setFont(new Font("a", Font.BOLD, 15));
			rightnum.add(l);
		}
		add(rightnum, BorderLayout.WEST);
	}

	public static void main(String[] args) {
		new Igra();
	}

}
