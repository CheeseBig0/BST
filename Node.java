public class Node{
    int key;
    Node left, right;
    
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
    
    // returns the height of the node 
    private int height(Node node){
        if(node.left == null && node.right == null) {
            return 0;
        }
        //get the height of the left and right nodes and return the bigger height
        int leftHeight = 0;
        if(node.left != null) {
            leftHeight = height(node.left) + 1;
        }
        int rightHeight = 0;
        if(node.right != null) {
            rightHeight = height(node.right) + 1;
        }
        
        return Math.max(leftHeight, rightHeight);
    }

    //returns the balance at the specified node
    private int balance(Node node){
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return rightHeight - leftHeight;
    }
    
}