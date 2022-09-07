public class Main {
	
    public static void main(String[] args) {
       
    	Node root = new Node(1);
        treeInsert(root, 30);
        treeInsert(root, 40);
        treeInsert(root, 10);
        treeInsert(root, 20);
        treeInsert(root, 5);
        treeInsert(root, 15);

        treeDisplay(root);
        System.out.println("30 is in the tree: " + treeFind(root, 30));
        System.out.println("40 is in the tree: " + treeFind(root, 40));
        System.out.println("10 is in the tree: " + treeFind(root, 10));
        System.out.println("7 is in the tree: " + treeFind(root, 7));
    }
    
	 public static boolean treeFind(Node root, int x) { 
		 
		 Node currentNode = root;
	       
	        while (currentNode != null)
	            if (currentNode.key == x)
	                return true;
	            else if (currentNode.key > x)
	                currentNode = currentNode.leftNode;
	            else
	                currentNode = currentNode.rightNode;
	        return false;
	        
	    }

	    public static Node treeInsert(Node root, int k) {
	    	
	        if (root == null) 
	            return new Node(k);
	        else if (k > root.key) 
	            root.rightNode = treeInsert(root.rightNode, k);
	        else 
	            root.leftNode = treeInsert(root.leftNode, k);
	        return root;
	    }


	    public static void treeDisplay(Node root) {
	    	
	    	if (root != null) {
	            treeDisplay(root.leftNode); 
	            System.out.println(root.key);
	            treeDisplay(root.rightNode);
	        }
	    }
}
