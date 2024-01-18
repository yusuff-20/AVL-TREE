package veriyapilari.fAVLT;

public class Main {
    Node root;
    public Main(){
        this.root = null;
    }
    
    public void add(int a){
        root = addRecursive(root, a); 
    }

    private Node addRecursive(Node node,int a){
        if(node == null){
            node = new Node(a);
        }else if(node.data > a){
            node.lc = addRecursive(node.lc, a);
        }else if(node.data < a){
            node.rc = addRecursive(node.rc, a);
        }
        return node;
    }

    // 2. update node size 
    node.height = 1 + max(height(node.lc) , height(node.rc)); 

    // 3.get balance value
    int balance = balance(node);

    public void remove(){

    }

    public void removeRecursive(){

    }

    public void preOrderTravel(){//ön
        preOrderTravelRecursive(root);
    }

    private void preOrderTravelRecursive(Node node){
        if(node != null){
            System.out.println(node.data);
            preOrderTravelRecursive(node.lc);
            preOrderTravelRecursive(node.rc);
        }
    }

    public void inOrderTravel(){//ara
        inOrderTravelRecursive(root);
    }
    
    private void inOrderTravelRecursive(Node node){
        if(node != null){
            inOrderTravelRecursive(node.lc);
            System.out.println(node.data);
            inOrderTravelRecursive(node.rc);
        }
    }

    public void postOrderTravel(){//arka
        postOrderTravelRecursive(root);
    }
    
    private void postOrderTravelRecursive(Node node){
        if(node != null){
            postOrderTravelRecursive(node.lc);
            postOrderTravelRecursive(node.rc);
            System.out.println(node.data);
        }
    }


    public int balance(Node node){
        return height(node.lc) - height(node.rc);
    }

    public int max(int a,int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }

    public int min(int a,int b){
        if(a > b){
            return b;
        }else{
            return a;
        }
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

}
