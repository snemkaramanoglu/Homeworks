package Projeler;

import java.util.Stack;

public class Expression {

	// /////////////////////////////////////////////////////////////////////////////////////////////
	// ***** IMPORTANT NOTE: Since we are allowed to use Stack class in Java, we
	// didn't implement //
	// stack structure.**** //
	// ////////////////////////////////////////////////////////////////////////////////////////////
	static Stack<Object> s;

	/*****************************************************************
	 * Converts an infix expression to a postfix expression and returns a
	 * pointer to the buffer containing the postfix expression
	 *****************************************************************/
	public static String Infix2Postfix(String infixExpr) {
		// Fill this in
		s = new Stack<Object>();
		String bosluksuz = infixExpr.replaceAll(" ", "");

		StringBuilder postFix = new StringBuilder();
		for (int i = 0; i < bosluksuz.length(); i++) {
			if (bosluksuz.charAt(i) == '+' || bosluksuz.charAt(i) == '-'
					|| bosluksuz.charAt(i) == '*' || bosluksuz.charAt(i) == '/') {
				postFix.append(" ");
				while (!s.isEmpty()) {
					if ((char) s.peek() == '(')
						break;
					if (bEsit((char) s.peek(), bosluksuz.charAt(i))) {
						postFix.append(s.pop() + " ");
					} else
						break;

				}// end-while
				s.push(bosluksuz.charAt(i));
			} else if (bosluksuz.charAt(i) == ')') {
				while (!s.isEmpty()) {
					char z = (char) s.pop();
					if (z == '(')
						break;
					else
						postFix.append(" " + z);
				}
			} else if (bosluksuz.charAt(i) == '(') {
				s.push(bosluksuz.charAt(i));

			} else { // Operand olma durumu
				postFix.append(bosluksuz.charAt(i));
			}
		}

		while (!s.isEmpty()) {
			postFix.append(" " + s.pop());
		}
		return postFix.toString();
	} // end-Infix2Postfix

	/*****************************************************************
	 * Given an expression in postfix form, evaluates the expression and returns
	 * the result
	 *****************************************************************/
	public static int EvaluatePostfixExpression(String postfixExpr) {
		s = new Stack<Object>();
		String[] atS = postfixExpr.split(" ");
		for (int i = 0; i < atS.length; i++) {
			if (atS[i].equals("+")) {
				s.push(Integer.parseInt("" + s.pop())
						+ Integer.parseInt("" + s.pop()));
			} else if (atS[i].equals("-")) {
				Integer x = Integer.parseInt("" + s.pop()); // Çýkarmada sýra
															// farkediyor b-a
															// deðil a-b olmalý
				s.push(Integer.parseInt("" + s.pop()) - x);
			} else if (atS[i].equals("*")) {
				s.push(Integer.parseInt("" + s.pop())
						* Integer.parseInt("" + s.pop()));
			} else if (atS[i].equals("/")) {
				Integer x = Integer.parseInt("" + s.pop());
				s.push(Integer.parseInt("" + s.pop()) / x); // Bölmede de farklý
			} else
				s.push(atS[i]);
		}
		return (int) s.peek();
	} // end-EvaluatePostfixExpression

	/*****************************************************************
	 * Given a postfix expression, converts this to an expression tree and
	 * returns a pointer to the root of the tree
	 *****************************************************************/
	public static ExpressionTreeNode Postfix2ExpressionTree(String postfixExpr) {
		// Fill this in
		ExpressionTreeNode p = null;
		s = new Stack<Object>();
		String[] atS = postfixExpr.split(" ");
		for (int i = 0; i < atS.length; i++) {
			if (atS[i].equals("+") || atS[i].equals("-") || atS[i].equals("*")
					|| atS[i].equals("/")) {
				p = new ExpressionTreeNode((byte) 0);
				p.operator = atS[i].charAt(0);

				ExpressionTreeNode temp = (ExpressionTreeNode) s.pop();
				p.right = temp;
				temp = (ExpressionTreeNode) s.pop();
				p.left = temp;
				s.push(p);
			} else {
				p = new ExpressionTreeNode((byte) 1);
				p.operand = Integer.parseInt(atS[i]);
				s.push(p);
			}
		}

		return (ExpressionTreeNode) s.peek();
	}// end-Postfix2ExpressionTree

	/*****************************************************************
	 * Given a pointer to the root of an expression tree, evaluates the
	 * expression tree, and returns the result
	 *****************************************************************/
	public static int EvaluateExpressionTree(ExpressionTreeNode root) {
		// Fill this in
		if (root.left == null && root.right == null)
			return root.operand;

		else {
			int sonuc = 0, left = EvaluateExpressionTree(root.left), right = EvaluateExpressionTree(root.right);
			char islem = root.operator;

			switch (islem) {
			case '+':
				sonuc = left + right;
				break;

			case '-':
				sonuc = left - right;
				break;

			case '*':
				sonuc = left * right;
				break;

			case '/':
				sonuc = left / right;
				break;
			}

			return sonuc;

		}
	} // end-EvaluateExpressionTree

	// Stack' e eklerken daha öncelikli bir operator var mý diye bakar
	public static boolean bEsit(char a, char b) {
		if (a == '*' || a == '/')
			return true;
		if (b == '+' || b == '-')
			return true;
		return false;
	}

};
