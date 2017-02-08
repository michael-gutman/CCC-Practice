import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S1_2015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> ints = new ArrayList<Integer>();
		int numInts = Integer.parseInt(br.readLine());
		for (int i = 0; i < numInts; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				ints.add(n);
			} else {
				ints.remove(ints.size()-1);
			}
		}
		int sum = 0;
		for (int a : ints) sum += a;
		System.out.println(sum);
	} 

}