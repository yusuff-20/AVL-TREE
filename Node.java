package Java.veriyapilari.fAVLT;

public class Node {
    int data;
    int height;
    Node lc;
    Node rc;

    public Node(int a){
        data = a;
        height = 1;
        lc = null;
        rc = null;
    }
}
