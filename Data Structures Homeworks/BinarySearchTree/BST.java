package dataHomework;

/******************************************************
 * BST ADT. Supported operations: Insert Delete Find Min Max Depth Print
 ******************************************************/
public class BST {
	private BSTNode root; /* Pointer to the root of the tree */
	private int noOfNodes; /* No of nodes in the tree */
	int nodeCounter;

	/*******************************************************
	 * Constructor: Initializes the BST
	 *******************************************************/
	public BST() {
		root = null;
		noOfNodes = 0;
	}

	/*******************************************************
	 * Returns a pointer to the root of the tree
	 *******************************************************/
	public BSTNode Root() {
		return this.root;
	}

	/*******************************************************
	 * Returns the number of nodes in the tree
	 *******************************************************/
	public int NoOfNodes() {
		return nodeCounter;
	}

	/*******************************************************
	 * Inserts the key into the BST. Returns a pointer to the inserted node
	 *******************************************************/
	public BSTNode Insert(int key) {
		// Fill this in
		BSTNode p = this.root, q = null;
		if (this.root == null) {
			nodeCounter++;
			return root = new BSTNode(key);
		} else {
			while (p != null) {
				q = p;
				if (key == p.key) {
					p.count++;
					return p;
				} else if (key < p.key)
					p = p.left;
				else
					p = p.right;
			} /* end-while */
			p = new BSTNode(key);
			if (q.key > key)
				q.left = p;
			else
				q.right = p;
		}
		nodeCounter++;
		return p;
	} // end-Insert

	/*******************************************************
	 * Deletes the key from the tree (if found). Returns 0 if deletion succeeds,
	 * -1 if it fails
	 *******************************************************/
	public int Delete(int key) {
		if (Find(key) == null)
			return -1;
		BSTNode p = this.root;
		BSTNode q = p;
		int leftDurumu = 1;
		while (p.key != key) {
			q = p;
			if (key < p.key) {
				leftDurumu = 1;
				p = p.left;
			} else {
				leftDurumu = 0;
				p = p.right;
			}
		}
		if (p.left == null && p.right == null) {
			if (p == root)
				root = null;
			else if (leftDurumu == 1)
				q.left = null;
			else
				q.right = null;
		} else if (p.right == null)
			if (p == root)
				root = p.left;
			else if (leftDurumu == 1)
				q.left = p.left;
			else
				q.right = p.left;
		else if (p.left == null)
			if (p == root)
				root = p.right;
			else if (leftDurumu == 1)
				q.left = p.right;
			else{
				q.right = p.right;
			}

		else {
			BSTNode gelecek = getir(p);
			if (p == this.root)
				root = gelecek;
			else if (leftDurumu == 1)
				q.left = gelecek;
			else
				q.right = gelecek;

			gelecek.left = p.left;
		}
		nodeCounter--;
		return 0;
	}

	/*******************************************************
	 * Searches the BST for a key. Returns a pointer to the node that contains
	 * the key (if found) or NULL if unsuccessful
	 *******************************************************/
	public BSTNode Find(int key) {
		// Fill this in
		if (this.root == null)
			return null;
		return traverseTree(this.root, key);
	} // end-Find

	/*******************************************************
	 * Returns a pointer to the node that contains the minimum key
	 *******************************************************/
	public BSTNode Min() {
		// Fill this in
		BSTNode p = this.root;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	} // end-Min

	/*******************************************************
	 * Returns a pointer to the node that contains the maximum key
	 *******************************************************/
	public BSTNode Max() {
		BSTNode p = this.root;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	} // end-Max

	/*******************************************************
	 * Returns the depth of tree. Depth of a tree is defined as the depth of the
	 * deepest leaf node. Root is at depth 0
	 *******************************************************/
	public int Depth() {
		// Fill this in
		if (root == null)
			return -1;
		int counter = 0, counter2 = 0;
		BSTNode p = root;
		while (p.left != null) {
			p = p.left;
			counter++;
		}
		p = root;
		while (p.right != null) {
			p = p.right;
			counter2++;
		}
		return (counter > counter2) ? counter : counter2;
	} // end-Depth

	/*******************************************************
	 * Performs an inorder traversal of the tree and prints [key, count] pairs
	 * in sorted order
	 *******************************************************/
	public void Print() {
		// Fill this in
		inOrderTraversal(this.root);

	} // end-Print

	public BSTNode traverseTree(BSTNode root, int key) {
		if (root == null)
			return null;
		if (root.key == key)
			return root;
		if (root.key > key)
			return traverseTree(root.left, key);
		else
			return traverseTree(root.right, key);
	}

	public void inOrderTraversal(BSTNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.key);
		inOrderTraversal(root.right);

	}

	public BSTNode getir(BSTNode temp) {
		BSTNode ataNode = temp;
		BSTNode gelecek = temp;
		BSTNode p = temp.right;
		while (p != null) {
			ataNode = gelecek;
			gelecek = p;
			p = p.left;
		}

		if (gelecek != temp.right) {
			ataNode.left = gelecek.right;
			gelecek.right = temp.right;
		}
		return gelecek;
	}

};
