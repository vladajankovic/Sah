package main;

import java.util.Scanner;

import igrac.Beli;
import igrac.Crni;

public class Main {

	public static void main(String[] args) {

		Igra sah = new Igra();

		boolean red = false;
		
		System.out.println(sah);

		while (true) {
			int i = 0;
			red = red ? false : true;
			if (red)
				System.out.println("Beli igrac je na potezu: ");
			else
				System.out.println("Crni igrac je na potezu: ");
			
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			String[] s = str.split(" ");
			String figura = s[0];
			String kolona = s[1];
			String vrsta = s[2];
			
			switch(figura) {
			case "p1":{
				if(red) i = sah.tabla.igraj(Beli.p1, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p1, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p2":{
				if(red) i = sah.tabla.igraj(Beli.p2, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p2, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p3":{
				if(red) i = sah.tabla.igraj(Beli.p3, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p3, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p4":{
				if(red) i = sah.tabla.igraj(Beli.p4, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p4, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p5":{
				if(red) i = sah.tabla.igraj(Beli.p5, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p5, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p6":{
				if(red) i = sah.tabla.igraj(Beli.p6, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p6, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p7":{
				if(red) i = sah.tabla.igraj(Beli.p7, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p7, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "p8":{
				if(red) i = sah.tabla.igraj(Beli.p8, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.p8, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "t1":{
				if(red) i = sah.tabla.igraj(Beli.t1, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.t1, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "t2":{
				if(red) i = sah.tabla.igraj(Beli.t2, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.t2, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "k1":{
				if(red) i = sah.tabla.igraj(Beli.k1, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.k1, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "k2":{
				if(red) i = sah.tabla.igraj(Beli.k2, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.k2, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "l1":{
				if(red) i = sah.tabla.igraj(Beli.l1, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.l1, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "l2":{
				if(red) i = sah.tabla.igraj(Beli.l2, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.l2, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "k":{
				if(red) i = sah.tabla.igraj(Beli.k, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.k, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			case "q":{
				if(red) i = sah.tabla.igraj(Beli.q, kolona.charAt(0), Integer.valueOf(vrsta));
				else i = sah.tabla.igraj(Crni.q, kolona.charAt(0), Integer.valueOf(vrsta));
				break;
			}
			}
			if(i == 1) {
				System.out.println("Greska u potezu!");
				red = red ? false : true;
			}
		}
	}

}

/**
 * Moguce igrati naizmenicno poteze (beli, crni, beli, crni, ...).
 * FORMAT UNOSA U INPUT: "figura kolona vrsta" (pr. p5 e 3, q h 5, ...), mora biti odvojeno zarezima
 * 
 */