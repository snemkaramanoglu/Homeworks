package Projeler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Polynomial class
public class Poly {
	int noOfNodes = 0;
	// -------------------------------------------------
	// Attributes
	private PolyNode head; 

	// -------------------------------------------------
	// Default constructor: Creates an empty polynomial
	public Poly() {
		if (noOfNodes == 0)
			head = null;
	}

	// -------------------------------------------------
	// Creates a polynomial from an expression.
	// Returns a pointer to the first PolyNode in the list (head of the list)
	//
	// Expression will be of the following sort:
	// Ex1: 2.3x^4 + 5x^3 - 2.64x - 4
	// Ex2: -4.555x^10 - 45.44
	// Ex3: x^6 + 2x^4 - x^3 - 6.3x + 4.223
	// Ex4: 34
	// Ex5: -x+1
	// Ex6: -3x^4 + 4x
	// Ex7: -2x - 5
	//

	public Poly(String expr) {
		tokenize(expr);
	} // end-Poly

	
	public void tokenize(String str) {
		this.noOfNodes = 0;
		int counter = 0; // Arrayin indexi

		String bosluksuz = str.replaceAll("\\s+", "");
		String eksiArti = bosluksuz.replaceAll("-", "+-");
		StringTokenizer st = new StringTokenizer(eksiArti, "+");
		ArrayList<String> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		// Exp ve Coef Bulma
		PolyNode[] nodes = new PolyNode[list.size()]; 

		for (int index = 0; index < list.size(); index++) {
			String s = list.get(index);
			nodes[counter] = new PolyNode(); 
    
			this.head = (PolyNode) nodes[0];

			if (s.contains("^")) {
				if (s.charAt(0) == 'x')
					nodes[counter].coef = 1;
				else if (s.charAt(0) == '-' && s.charAt(1) == 'x')
					nodes[counter].coef = -1;
				else if (s.charAt(0) != 'x' && s.charAt(0) != '-'
						&& s.contains("x"))    
					nodes[counter].coef = Double.parseDouble(s.substring(0,
							s.indexOf("x")));  
				else if (s.charAt(0) == '-' && s.charAt(1) != 'x')
					nodes[counter].coef = -1*Double.parseDouble(s.substring(1,
							s.indexOf("x")));

				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '^') {          
						nodes[counter].exp = Integer.parseInt(s.substring(
								s.indexOf("^") + 1, s.length()));
						break;
					}
				}
			} else {
				if (s.contains("x")) { 
                    
					if (s.charAt(0) == 'x') {
						nodes[counter].coef = 1;
						nodes[counter].exp = 1;
					} else if (s.charAt(0) == '-' && s.charAt(1) == 'x') {
						nodes[counter].coef = -1;
						nodes[counter].exp = 1;
					} else {
						nodes[counter].exp = 1;
						nodes[counter].coef = Double.parseDouble(s.substring(0,
								s.indexOf("x")));
					}

				} else {
					nodes[counter].exp = 0;
					nodes[counter].coef = Double.parseDouble(s);

				}

			}

			noOfNodes++;
			counter++;
		}
		PolyNode pn;
		for (int i = 0; i < noOfNodes - 1; i++) {
			pn = (PolyNode) nodes[i];
			pn.next = (PolyNode) nodes[i + 1];
		}
	}

	// -------------------------------------------------
	// Adds a node (coefficient, exponent) to poly. If there already
	// is a node with the same exponent, then you simply add the coefficient
	// to the existing coefficient. If not, you add a new node to polynomial
	// Returns a pointer to the possibly new head of the polynomial.
	//     6x^3  + 4x              
	public void AddNode(double coef, int exp) {
		// Fill this in
		PolyNode p = this.head;
		if (p == null) {
			PolyNode polyNode = new PolyNode();
			this.head = polyNode;
			this.head.next = null;
			this.head.coef = coef;
			this.head.exp = exp;
			this.noOfNodes++;
		} else {
			boolean found = false;
			if (head.exp == exp) {
				head.coef += coef;
			} else {
				while (p.next != null) {
					if (p.exp == exp) {
						found = true;
						break;
					} else {
						p = p.next;
						if (p.next == null && p.exp == exp) {
							found = true;
						}
					}
				}
				if (found) {
					p.coef += coef;
				} else {
					PolyNode polyNodes = new PolyNode();

					polyNodes.next = p.next;
					p.next = polyNodes;

					polyNodes.coef = coef;
					polyNodes.exp = exp;
					noOfNodes++;
				}
			}
		}
		   p=head;
		   if(head.coef==(double)0) head = head.next; 
			while(p.next!=null){  
				if(p.next.coef==(double)0){
					p.next = p.next.next;
					p = p.next;
					this.noOfNodes--;
				}
				else p = p.next;
			}

	} // end-AddNode

	// -------------------------------------------------
	// Adds two polynomials and returns a new polynomial that contains the
	// result
	// Computes: poly3 = poly1 + poly2 and returns poly3
	//
	public static Poly Add(Poly poly1, Poly poly2) {
		// Fill this in
		Poly poly3 = new Poly(); // Return edilecek þey
		Map<Integer,Double> p1 = new HashMap<>();
		Map<Integer,Double> p2 = new HashMap<>();
		PolyNode p=poly1.head;
		while(p.next!=null){
			p1.put(p.exp, p.coef);
			p = p.next;
			if(p.next==null){
				p1.put(p.exp, p.coef);
			}
		}
		p = poly2.head;
		while(p.next!=null){
			p2.put(p.exp, p.coef);
			p = p.next;
			if(p.next==null){
				p2.put(p.exp, p.coef);
			}
		}
		//Iterator p1Key = p1.keySet().iterator();  //KeySet exp   EntrySet coef
		//Iterator p2Key;
		//boolean found = false;
			
		for(Integer i : p1.keySet()){
			poly3.AddNode(p1.get(i), i);
		}
		for(Integer i : p2.keySet()){
			poly3.AddNode(p2.get(i), i);
		}
		return poly3;
	} // end-Add

	// -------------------------------------------------
	// Subtracts poly2 from poly1 and returns the resulting polynomial
	// Computes: poly3 = poly1 - poly2 and returns poly3
	//
	public static Poly Subtract(Poly poly1, Poly poly2) {
		// Fill this in
		Poly poly3 = new Poly(); // Return edilecek þey
		Map<Integer,Double> p1 = new HashMap<>();
		Map<Integer,Double> p2 = new HashMap<>();
		PolyNode p=poly1.head;
		while(p.next!=null){
			p1.put(p.exp, p.coef);
			p = p.next;
			if(p.next==null){
				p1.put(p.exp, p.coef);
			}
		}
		p = poly2.head;
		while(p.next!=null){
			p2.put(p.exp, -1*p.coef);  
			p = p.next;
			if(p.next==null){
				p2.put(p.exp, -1*p.coef);
			}
		}
		for(Integer i : p1.keySet()){
			poly3.AddNode(p1.get(i), i);
		}
		for(Integer i : p2.keySet()){
			poly3.AddNode(p2.get(i), i);
		}
		
		
		
		return poly3;
	} // end-Substract

	// -------------------------------------------------
	// Multiplies poly1 and poly2 and returns the resulting polynomial
	// Computes: poly3 = poly1 * poly2 and returns poly3
	//
	public static Poly Multiply(Poly poly1, Poly poly2) {
		// Fill this in
		Poly poly3 = new Poly();
		PolyNode p=poly1.head, q=null;
		while(p!=null){
			q = poly2.head;
			while(q!=null){
				poly3.AddNode(p.coef*q.coef, p.exp+q.exp);
				q = q.next;
			}
			p=p.next;
		}
		return poly3;
	} // end-Multiply

	// -------------------------------------------------
	// Evaluates the polynomial at a particular "x" value and returns the result
	//
	public double Evaluate(double x) {
		// Fill this in
		PolyNode p = this.head;
		double sonuc=0;
		while(p!=null){
			sonuc += p.coef*ustAl(x, p.exp);
			p=p.next;
		}
		return sonuc;
	} // end-Evaluate
	
	public static double ustAl(double x,int y){
		if(y==1) return x;
		else if(y==0) return 1;
		else{
			double toplam=0;
			while(y>1){
				toplam +=x*x;
				y--;
			}
			return toplam;
		}
	}

	// -------------------------------------------------
	// Computes the derivative of the polynomial and returns it
	// Ex: poly(x) = 3x^4 - 2x + 1-->Derivative(poly) = 12x^3 - 2
	//
	public Poly Derivative() {
		// Fill this in
		Poly poly3 = new Poly();
		PolyNode p=this.head;
		while(p!=null && p.exp!=0){
			poly3.AddNode(p.coef*p.exp, --p.exp);
			p = p.next;
		}
		
		return poly3;
	} // end-Derivative

	// -------------------------------------------------
	// Plots the polynomial in the range [x1, x2].
	// -39<=x1<x2<=39
	// -12<=y<=12
	// On the middle of the screen you gotta have x & y axis plotted
	// During evaluation, if "y" value does not fit on the screen,
	// then just skip it. Otherwise put a '*' char depicting the curve
	//
	public void Plot(int x1, int x2) {
		// Fill this in
		for(int i=-12;i<=12;i++){
			for(int j=x1;j<=x2;j++){
				if(i==0 & j==0) System.out.printf("%c",43);
			 if(i==0)System.out.printf("%c",45);
				else if(j==0)System.out.printf("%c",124);
				else if(i==(int)this.Evaluate(j) && !((int)this.Evaluate(j)>12) && !((int)this.Evaluate(j)<-12)){
				   System.out.print("*");
				  }
				else System.out.print(" ");
			}
			System.out.println("");
		}
	} // end-Plot

	// -------------------------------------------------
	// Prints a polynomial in a nicely formatted manner
	//
	public void Print() {
		if (head == null) {
			System.out.printf("<NULL>\n");
			return;
		}

		System.out.printf("<");
		PolyNode p = head;
		while (p != null) {
			if (p.exp == 0) {
				System.out.printf("%+-3.1f", p.coef);

			} else if (p.exp == 1) {
				if (p.coef == 1.0)
					System.out.printf("+x ");
				else if (p.coef == -1.0)
					System.out.printf("-x ");
				else
					System.out.printf("%+-3.1fx ", p.coef);

			} else {
				if (p.coef == 1.0)
					System.out.printf("+x^%-2d ", p.exp);
				else if (p.coef == -1.0)
					System.out.printf("-x^%-2d ", p.exp);
				else
					System.out.printf("%+-3.1fx^%-2d ", p.coef, p.exp);
			} // end-else

			p = p.next;
		} // end-while

		System.out.printf(">\n");
	} // end-Print
} // end-Poly
