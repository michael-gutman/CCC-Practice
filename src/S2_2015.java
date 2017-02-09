import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numJ = Integer.parseInt(br.readLine());
		int numA = Integer.parseInt(br.readLine());
		int[] j = new int[numJ];
		for (int i = 0; i < numJ; i++) {
			String s = br.readLine().trim();
			if (s.equals("S")) j[i] = 0;
			if (s.equals("M")) j[i] = 1;
			if (s.equals("L")) j[i] = 2;
		}
		int reqs = 0;
		for (int i = 0; i < numA; i++) {
			String[] line = br.readLine().trim().split(" ");
			String size = line[0];
			int s = 0;
			if (size.equals("S")) s = 0;
			if (size.equals("M")) s = 1;
			if (size.equals("L")) s = 2;
			int p = Integer.parseInt(line[1]) - 1;
			if (p < numJ && s <= j[p]) {
				reqs++;
				j[p] = -1;
			}
		}
		System.out.println(reqs);
	}

}
