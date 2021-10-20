package structure.set;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

	}

	/**
	 * 804号问题 摩斯密码
	 */
	class Solution {
		public int uniqueMorseRepresentations(String[] words) {
			String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

			Set<String> seen = new HashSet<>();

			for (var word : words) { // 拆分成每个单词
				StringBuilder code = new StringBuilder();
				for (var c : word.toCharArray()) {
					code.append(morse[c - 'a']);

				}
				seen.add(code.toString());
			}

			return seen.size();

		}
	}
}
