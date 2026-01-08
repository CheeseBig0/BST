class BST {
    private Node root;
    private Node previous;
    public BST()
    {
         root = null;
    }


    // rotates the tree such that the subRoot is replaced with it's right child with subRoot becoming the left child of the new subRoot. prev now points to the new subRoot.
    private void rotateLeft(Node subRoot, Node prev) {
        Node temp = subRoot.right;
        subRoot.right = temp.left;
        temp.left = subRoot;

        prev.left = subRoot;

    }

    // rotates the tree such that the subRoot is replaced with it's left child with subRoot becoming the right child of the new subRoot. prev now points to the new subRoot.
    private void rotateRight(Node subRoot, Node prev) {
        Node temp = subRoot.left;
        subRoot.left =  temp.right;
        temp.right = subRoot;
        
        prev.right = subRoot;
    }


    // requires an int key to put in the BST
    // Will add the inputted key in the correct spot in the BST
    void insert(int key){
        Node current = root;
        Node inserted = new Node(key);
        inserted.key = key;
        
        while(current != null) {
            if(key > current.key) {
                if(current.right == null) {
                    current.right = inserted;
                    return;
                }
                current = current.right;
            }

            if(current.left == null) {
                current.left = inserted;
                return;
            }
            current = current.left;
        }
        
    }
    
    //Requires a key to look for
    //Returns true if the key is found in the tree
    boolean search(int key){
        Node current = root;
        previous = root;
        while (current != null && current.key != key) {
            if(key < current.key) {
                previous = current;
                current = current.left;
            } else if(key > current.key) {
                previous = current;
                current = current.right;
            }
            if(current == null) {
                return false;
            }
        }
        return true;
    }

    //Requires a int key in the tree
    //The key somewhere in the tree will either be replaced or gone entirely
    int remove(int key){
        if(!search(key)){
            return -1;
        }
        
        //either removing the root
        if(root.key == key){
            
        }
        //or not the root
    //no children
    Node current = null;
    boolean isRight = true;
    if(previous.right.key == key){
        current = previous.right;
    }
    else {
        isRight = false;
        current = previous.left;
    }
        if(current.left == null && current.right == null) {
         if(isRight){
            previous.right = null;
         }
         else {
            previous.left = null;
         }
        }

        //one child
        if(current.left != null && current.right == null) {
            if(isRight) {
                previous.right = current.left;
            } else {
                previous.left = current.left;
            }
        }
        if(current.left == null && current.right != null) {
            if(isRight) {
                previous.right = current.right;
            } else {
                previous.left = current.right;
            }
        }

        //two children (tricky)
        //should find the left most node in the right subtree of current
        Node replaced = current;
        current = current.right;
        while(current.left != null) {
            previous = current;
            current = current.left;
        }
        
        replaced.key = previous.left.key;
        remove(previous.left.key);
        
        return 1;


    }




    public String toString(){
        return "not done pp";
    }

    

    //Add the following functions to your BST
 //Please use this code to verify your tree integrity
    public boolean isBSTOrNot() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
        // check for root is not null or not
        if (root == null) {
            return true;
        }
        // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
        if(root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) && isBSTOrNot(root.right, root.key, maxValue)){
            return true;
        }
        return false;
    }

 

   // please use the following pieces of code to display your tree in a more easy to follow style
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }
 
        showTrunks(p.prev);
        System.out.print(p.str);
    }
 
    public void printTree(){
        printTree(root, null, false);
    }

    private void printTree(Node root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }
 
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);
 
        printTree(root.right, trunk, true);
 
        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }
 
        showTrunks(trunk);
        System.out.println(" " + root.key);
 
        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";
 
        printTree(root.left, trunk, false);
    }

}
