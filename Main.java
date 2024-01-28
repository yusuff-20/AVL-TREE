package veriyapilari.fAVLT;

public class Main {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        Node root = new Node(5);
    
        avl.add(root, 7);
        avl.postOrderTravel(avl.root);

        avl.add(root, 8);
        avl.postOrderTravel(avl.root);

        avl.add(root, 9);
        avl.postOrderTravel(avl.root);
        
        avl.add(root, 2);
        avl.postOrderTravel(avl.root);
        
        avl.add(root, 3);
        avl.postOrderTravel(avl.root);

        avl.add(root, 0);
        avl.postOrderTravel(avl.root);
    }
}
