public class Main {

    public static void main(String[] args) {
        System.out.println("--Main--");

        BST testTree = new BST();
        testTree.insert(50);
        testTree.insert(100);
        testTree.insert(150);

        testTree.remove(50);
        testTree.printTree();
        testTree.insert(25);
        System.out.println(testTree.search(25));
        testTree.remove(25);
        System.out.println(testTree.search(25));

        
        testTree.toString();
        
    }
}
