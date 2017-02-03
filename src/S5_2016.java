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
		for (long i = 0; i < T; i++) {
			int[] curr = cells.clone();
			for (int j = 0; j<N; j++) {
				if (j == 0) {
					cells[j] = curr[j+1] == curr[N-1] ? 0 : 1;
				} else if (j > 0 && j < N - 1) {
					cells[j] = curr[j+1] == curr[j-1] ? 0 : 1;
				} else {
					cells[j] = curr[0] == curr[j-1] ? 0 : 1;
				}
			}
		}
		for (int k = 0; k < cells.length; k++) {
			System.out.print(cells[k]);
		}
	}
}
