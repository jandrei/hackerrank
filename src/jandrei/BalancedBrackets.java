package jandrei;

import java.util.Stack;

public class BalancedBrackets {

	/**
	 * "3" "{[()]}" "{[(])}" "{{[[(())]]}}"
	 * 
	 * "5"
	 * "[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{"
	 * "[]()([{}])[]{}[]" ")}{){(]{)([)}{)]())[(})[]]))({[[[)}[((]](])][({[]())"
	 * "{}()[[((()(({{[]}{}{{[]}}{}}))))]]{{{{([{{{{}}}}])}}}}"
	 * "{{[()()]}()}(())()()[[[]]][{[]()}(())]"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int t = Integer.parseInt(args[0]);

		for (int a0 = 1; a0 < args.length; a0++) {
			String expression = args[a0];
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}

	public static boolean isBalanced(String expression) {
		Stack<String> pilha = new Stack<>();
		String left = "{[(";
		String right = ")]}";

		for (int i = 0; i < expression.length(); i++) {
			String ex = String.valueOf(expression.charAt(i));

			if (!"{[()]}".contains(ex)) {
				return false;
			}
			if (left.contains(ex)) {
				pilha.add(ex);
			} else if (right.contains(ex)) {
				if (pilha.empty()) {
					return false;
				}
				String saida = pilha.pop();
				if (!"()[]{}".contains(saida + "" + ex)) {
					return false;
				}
			}
		}

		return pilha.isEmpty();
	}
}
