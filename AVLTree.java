class AVLTree extends BST { 
    Node root;
    Node current;
    int height (Node N) {
        if (N == null)
            return 0;
        return height(N);
    }

    

    void rotateRight(Node selected) {
        Node temp1 = selected.left;
        Node temp2 = selected.right;

        temp1.right = selected;
        selected.left = temp2;
    }
    
    void rotateLeft(Node selected) {
        Node temp1 = selected.right;
        Node temp2 = selected.left;

        temp1.left = selected;
        selected.right = temp2;
    }
    
    int insert(int key, Node n) {
        
    }

}
