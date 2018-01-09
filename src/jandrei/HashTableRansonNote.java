package jandrei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTableRansonNote {
	
	/**
	 * arguments for test,
	 * NO 
	 * "6 5" "two times three is not four" "two times two is four"
	 * 
	 * YES
	 * "6 4" "give me one grand today night" "give one grand today"
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.asList(args));
		String[] mn = args[0].split(" ");
		
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		
		
		String magazine[] = args[1].split(" ");
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = magazine[magazine_i];
		}
		
		String ransom[] = args[2].split(" ");
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = ransom[ransom_i];
		}
		
		System.out.println(Arrays.asList(magazine));
		System.out.println(Arrays.asList(ransom));
		
		if ((m < 1 && m > 30000) || (n < 1 && n > 30000)) {
			System.out.println("No");
			return;
		}
		
		
		Map<String, Integer> mapa = new HashMap<>();
		for (int i = 0; i < magazine.length; i++) {
			String magazine_key = magazine[i];
			
			if (magazine_key.length() < 1 || magazine_key.length() > 5 || !magazine_key.matches("[a-zA-Z]+")) {
				System.out.println("No");
				return;
			}
			if (!mapa.containsKey(magazine_key)) {
				mapa.put(magazine_key, 1);
			}else {
				mapa.put(magazine_key, mapa.get(magazine_key) + 1);
			}
		}
		
		for (int i = 0; i < ransom.length; i++) {
			String ransom_key = ransom[i];
			if (ransom_key.length() < 1 || ransom_key.length() > 5 || !ransom_key.matches("[a-zA-Z]+")) {
				System.out.println("No");
				return;
			}
			if (!mapa.containsKey(ransom_key)) {
				System.out.println("No");
				return;
			}
			
			Integer keysFound = mapa.get(ransom_key);
			if (keysFound < 1) {
				System.out.println("No");
				return;
			}
			
			keysFound --;
			
			mapa.put(ransom_key, keysFound);
		}
		System.out.println("Yes");
	}

}
