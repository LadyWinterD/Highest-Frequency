package fifth;
/**
* Suppose you have a text file with 100,000 words. Our task is to find the
* most frequent term in this file efficiently. Write a program that outputs
* the most frequent words---DONGDONG LI
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class five {

	private static List<String> initialArr(String str) {
		File f = new File(str);
		List<String> wordmap = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				wordmap.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordmap;
	}

	private static void printMostWord(List<String> words) {
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		
		int max = 1;
		for (int i = 0; i < words.size(); i++) {
			if (wordsMap.containsKey(words.get(i))) {
				int num = wordsMap.get(words.get(i)) + 1;
				wordsMap.put(words.get(i), num);
				if (num > max) {
					max = num;
				}
			} else {
				wordsMap.put(words.get(i), 1);
			}
		}
		// print the number 
		String frequentStr = "";
		for (Iterator<String> iterator = wordsMap.keySet().iterator(); iterator
				.hasNext();) {
			String word1 = iterator.next();
			int num = wordsMap.get(word1);
			if (max == num) {
				frequentStr = frequentStr + word1 + ",";
			}
		}
		System.out.println("The most frequent term is:" + frequentStr);
	}// end of this method

	public static void main(String args[]) {
		printMostWord(initialArr("e:\\5.txt"));
	}

}
