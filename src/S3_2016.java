import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class S3_2016 {
	
	/*
	 * Read N / M
	 * Add 0 to N - 1 restaurants/nodes
	 * Read M pho restaurants and set their nodes to true
	 * for each N - 1 paths:
	 * 		add the connections between the nodes
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		Node[] restaurants;
		int N, M;
		String[] NM = r.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		restaurants = new Node[N];
		for (int i = 0; i < N; i++) {
			restaurants[i] = new Node();
		}
		int[] pho = Stream.of(r.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		for(int i : pho) {
			restaurants[i].isPho = true;
		}
		for (int i = 1; i < N; i++) {
			int[] pair  = Stream.of(r.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			restaurants[pair[0]].paths.add(restaurants[pair[1]]);
			restaurants[pair[1]].paths.add(restaurants[pair[0]]);
		}
	}
	
	static class Node {
		boolean isPho = false;
		ArrayList<Node> paths = new ArrayList<Node>();
	}

}
