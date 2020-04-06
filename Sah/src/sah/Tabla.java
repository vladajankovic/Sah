package sah;

public class Tabla {

	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	private static final int N = 8;

	protected Figura[][] tabla = new Figura[N][N];

	public void postaviFiguru(Figura f) {
		if (this.dohvatiFiguru(f.polje) != null)
			return;
		tabla[f.polje.vrsta - 1][f.polje.kolona - 'A'] = f;
	}

	Figura dohvatiFiguru(Polje p) {
		return tabla[p.vrsta - 1][p.kolona - 'A'];
	}

	public int igraj(Figura f, char k, int v) {
		int n = f.igrajFigura(v, k, this);
		System.out.println(this);
		return n;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("    ");

		for (int i = 0; i < N; i++)

			sb.append((char) ('A' + i)).append("   "); // prvi red

		sb.append('\n');

		for (int i = 0; i < N; i++) {
			sb.append(i + 1).append(" |");

			for (int j = 0; j < N; j++) {
				if (tabla[i][j] == null) {
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							sb.append("   |");

						} else
							sb.append("(#)|");
					} else {
						if (j % 2 == 0) {
							sb.append("(#)|");
						} else
							sb.append("   |");
					}
				} else {
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							sb.append(" ").append(tabla[i][j]).append(" |");
						} else {
							sb.append("(").append(tabla[i][j]).append(")|");
						}
					} else {
						if (j % 2 == 0) {
							sb.append("(").append(tabla[i][j]).append(")|");
						} else {
							sb.append(" ").append(tabla[i][j]).append(" |");
						}
					}
				}

			}
			sb.append("\n");

		}
		sb.append('\n');

		return sb.toString();
	}

}
