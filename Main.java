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

    // 2. düğüm boyunu güncelle 
    node.height = 1 + max(boy(node.lc), boy(node.rc)); 

    public void remove(){

    }

    public void removeRecursive(){

    }

    public void preOrderTravel(){//ön

    }

    public void preOrderTravelRecursive(){

    }

    public void inOrderTravel(){//ara

    }
    
    public void inOrderTravelRecursive(){

    }

    public void postOrderTravel(){//arka

    }
    
    public void postOrderTravelRecursive(){

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
            return node.hei
        }
    }

}
