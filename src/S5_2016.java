import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class S5_2016 {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String[] NT = r.readLine().split(" ");
		int N = Integer.parseInt(NT[0]);
		long T = Long.parseLong(NT[1]);
		int[] cells;
		cells = Stream.of(r.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		//int pow = (int) (Math.log10(L)/Math.log10(2));

		simulate(N, T, cells);

		for (int k = 0; k < cells.length; k++) {
			System.out.print(cells[k]);
		}
	}

	private static void simulate(int N, Long T, int[] cells) {
		long L = powOf2LessThan(T);
		L = L < T ? L : L>>1;
		int[] curr = cells.clone();
		for (int i=0; i<N; i++) {
			int prev = (int) ((i - L)%N);
			prev = prev >= 0 ? prev : prev + N;
			int next = (int) ((i + L)%N);
			next = next >= 0 ? next : next + N;
			cells[i] = curr[next] == curr[prev] ? 0 : 1;
		}
		T -= L;
		if (T > 0) simulate(N, T, cells);
	}

	private static long powOf2LessThan(long n) {
		long pow = 1;
		do {
			pow <<= 1;
		} while(pow < n);
		return pow;
	}
}
