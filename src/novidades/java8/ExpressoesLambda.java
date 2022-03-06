package novidades.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ExpressoesLambda {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		String owner, l, color, size;
		Tshirt[] tshirts;
		int N;
		boolean firstCase = true;
		while (!(l = read()).trim().equals("0")) {
			if (firstCase) {
				firstCase = false;
			} else {
				out.println();
			}
			N = toInt(l);
			if (N <= 0) {
				return;
			}
			tshirts = new Tshirt[N];
			for (int i = 0; i < N; i++) {
				owner = read();
				l = read();
				StringTokenizer st = new StringTokenizer(l);
				color = st.nextToken();
				size = st.nextToken();
				tshirts[i] = new Tshirt(size, color, owner);
			}
			Arrays.sort(tshirts, new Comparator<Tshirt>() {
				@Override
				public int compare(Tshirt t1, Tshirt t2) {
					String color1 = t1.getColor();
					String color2 = t2.getColor();
					int diff = color1.compareTo(color2);
					if (diff != 0) {
						return diff;
					} else {
						if (t1.getSize().equals(t2.getSize())) {
							return t1.getOwner().compareTo(t2.getOwner());
						} else if ((t1.getSize() == "P" && (t2.getSize() == "M" || t2.getSize() == "G"))
								|| (t1.getSize() == "M" && t2.getSize() == "G")) {
							return -1;
						}
						return 1;
					}
				}
			});
			for (int i = 0; i < N; i++) {
				System.out.println(tshirts[i]);
			}

		}
		out.close();
	}

	private static String read() throws IOException {
		return in.readLine();
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}

class Tshirt {

	private String size;
	private String color;
	private String owner;

	public Tshirt(String size, String color, String owner) {
		this.size = size;
		this.color = color;
		this.owner = owner;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return this.getColor() + " " + this.getSize() + " " + this.getOwner();
	}
}