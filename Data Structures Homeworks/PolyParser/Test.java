package Projeler;

public class Test {
  /****************************************************
   * Test1
   ****************************************************/
  public static int Test1(){
    // infixExpr: 3500 - ((43*12) + (47/2));    
    // Let the Java compiler do the evaluation :-)
    int expressionValue = 3500 - ((43*12) + (47/2));
        
    // postfix: 3500 43 12 * 47 2 / + -
    String postfixExpr = "3500 43 12 * 47 2 / + -";
    int result = Expression.EvaluatePostfixExpression(postfixExpr);
	if (result != expressionValue) return 0;    
    
	ExpressionTreeNode root = Expression.Postfix2ExpressionTree(postfixExpr);

	if (root.type != 0 && root.operator != '-') return 0;		

	if (root.left.type != 1 && root.left.operand != 3500) return 0;		
	if (root.right.type != 0 && root.right.operator != '+') return 0;		

	if (root.right.left.type != 0 && root.right.left.operator != '*') return 0;		
	if (root.right.left.left.type != 1 && root.right.left.left.operand != 43) return 0;		
	if (root.right.left.right.type != 1 && root.right.left.right.operand != 12) return 0;		
	if (root.right.right.type != 0 && root.right.left.operator != '/') return 0;		
	if (root.right.right.left.type != 1 && root.right.right.left.operand != 47) return 0;		
	if (root.right.right.right.type != 1 && root.right.right.right.operand != 2) return 0;	
	result = Expression.EvaluateExpressionTree(root);

	if (result != expressionValue) return 0;    
    return 20;
  } //end-Test1

  /****************************************************
   * Test2
   ****************************************************/
  public static int Test2(){
    int expressionValue = 20 + 2 * 3     + (2*8 + 5)* 4;
    
    String infixExpr = "20 + 2 * 3     + (2*8 + 5)* 4";
    String postfixExpr = Expression.Infix2Postfix(infixExpr);
    System.out.print("Infix Expr: <" + infixExpr + ">\nPostfixExpr: <" + postfixExpr + ">\n");
  
    int result = Expression.EvaluatePostfixExpression(postfixExpr);
    if (result != expressionValue) return 0;

    // Convert to expression tree & evaluate
    ExpressionTreeNode root = Expression.Postfix2ExpressionTree(postfixExpr);
    result = Expression.EvaluateExpressionTree(root);
    if (result != expressionValue) return 0;
    
    return 20;
  } //end-Test2
  
  /****************************************************
   * Test3
   ****************************************************/
  public static int Test3(){
    // Let the Java compiler do the evaluation :-)
    int expressionValue = 20* 2 + 3 - (2*8 + 5)* 4;
    
    String infixExpr = "20* 2 + 3 - (2*8 + 5)* 4";
    String postfixExpr = Expression.Infix2Postfix(infixExpr);
    System.out.print("Infix Expr: <" + infixExpr + ">\nPostfixExpr: <" + postfixExpr + ">\n");
  
    int result = Expression.EvaluatePostfixExpression(postfixExpr);
    if (result != expressionValue) return 0;

    // Convert to expression tree & evaluate
    ExpressionTreeNode root = Expression.Postfix2ExpressionTree(postfixExpr);
    result = Expression.EvaluateExpressionTree(root);
    if (result != expressionValue) return 0;
    
    return 20;
  } //end-Test3

  /****************************************************
   * Test4
   ****************************************************/
  public static int Test4(){
    int expressionValue = 220 - 45 - 10;
    
    String infixExpr = "220 - 45 - 10";
    String postfixExpr = Expression.Infix2Postfix(infixExpr);
    System.out.print("Infix Expr: <" + infixExpr + ">\nPostfixExpr: <" + postfixExpr + ">\n");
  
    int result = Expression.EvaluatePostfixExpression(postfixExpr);
    if (result != expressionValue) return 0;

    // Convert to expression tree & evaluate
    ExpressionTreeNode root = Expression.Postfix2ExpressionTree(postfixExpr);
    result = Expression.EvaluateExpressionTree(root);
    if (result != expressionValue) return 0;
    
    return 20;
  } //end-Test4

  /****************************************************
   * Test5
   ****************************************************/
  public static int Test5(){
    int expressionValue = (((13+35)*22)/45) - (45+34*(190-34))/100;
  
    String infixExpr = "(((13+35)*22)/45) - (45+34*(190-34))/100";
    String postfixExpr = Expression.Infix2Postfix(infixExpr);
    System.out.print("Infix Expr: <" + infixExpr + ">\nPostfixExpr: <" + postfixExpr + ">\n");
  
    int result = Expression.EvaluatePostfixExpression(postfixExpr);
    if (result != expressionValue) return 0;

    // Convert to expression tree & evaluate
    ExpressionTreeNode root = Expression.Postfix2ExpressionTree(postfixExpr);
    result = Expression.EvaluateExpressionTree(root);
    if (result != expressionValue) return 0;
    
    return 20;
  } //end-Test5


  /****************************************************
   * Program entry point
   ****************************************************/
  public static void main(String args[]){
    int grade = 0;

    System.out.print("======================= TEST1 ========================\n");
    grade += Test.Test1();
    
    if (grade > 0){
      System.out.print("======================= TEST2 ========================\n");
      grade += Test.Test2();

      System.out.print("======================= TEST3 ========================\n");
      grade += Test.Test3();

      System.out.print("======================= TEST4 ========================\n");
      grade += Test.Test4();

      System.out.print("======================= TEST5 ========================\n");
      grade += Test.Test5();
    } //end-if
    
    System.out.print("------------------------------------------------------\n");
    System.out.println("Final grade: " + grade);
  } // end-main
};
