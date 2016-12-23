import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Ragaman
 * Given 2 strings, determines if the second is a wildcard anagram of the first.
 */
public class S1_2017 {

	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "";
		String s2 = "";
		try {
			s1 = r.readLine();
			s2 = r.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(ragaman(s1, s2));
	}

	public static String ragaman(String s1, String s2) {
		ArrayList<Character> checked = new ArrayList<Character>();
		if (s1.length() != s2.length()) return "N";
		int stars = 0;
		char curr = 0;
		for (int i = 0; i < s2.length(); i++) if (s2.charAt(i) == '*') stars++;
		for (int i = 0; i < s1.length(); i++) {
			curr = s1.charAt(i);
			if (checked.indexOf(curr) == -1) {
				checked.add(curr);
				int n1 = count(s1, curr);
				int n2 = count(s2, curr);
				if (n1 > n2) stars -= (n1-n2);
			}
		}
		return stars >= 0 ? "A" : "N";
	}

	public static int count(String s, char c) {
		return s.length() - s.replace(c + "", "").length();
	}
}
