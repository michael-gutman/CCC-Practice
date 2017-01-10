import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_2016 {

	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int q = 0, n= 0;
		String[] dS = null, pS = null;
 		try {
			q = Integer.parseInt(r.readLine());
			n = Integer.parseInt(r.readLine());
			dS = r.readLine().split(" ");
			pS = r.readLine().split(" ");
		} catch (IOException e){
			e.printStackTrace();
		}
 		
 		int[] d = new int[n];
 		int[] p = new int[n];
 		
 		for (int i = 0; i < n; i++) {
 			d[i] = Integer.parseInt(dS[i]);
 			p[i] = Integer.parseInt(pS[i]);
 		}
 		
 		Arrays.sort(d);
 		Arrays.sort(p);
 		
 		int sum = 0;
 		
 		switch (q) {
 		case 1:
 			for (int i = 0; i < n; i++) {
 				sum += Math.max(d[i],p[i]);
 			}
 			System.out.println(sum);
 			break;
 		case 2:
 			for (int i = 0; i < n; i++) {
 				sum += Math.max(d[i],p[n-i-1]);
 			}
 			System.out.println(sum);
 			break;
 		}
	}

}
