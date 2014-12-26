package Projeler;

public class ExpressionTreeNode {
  public byte type;         // 0: operator, 1: operand (a number)
  public char operator;     // One of '+', '-', '*', '/'
  public int operand;       // A number
  public ExpressionTreeNode left, right;  // Left & right children and root
  
  public ExpressionTreeNode(byte type){this.type = type; left=right=null;}
};