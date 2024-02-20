package veriyapilari.fAVLT;

public class AVLTree {
    Node root;

    public AVLTree(){
        this.root = null;
    }

    // 1. add function
    public Node add(Node node,int data){
        if(node == null){
            node = new Node(data);
        }else if(node.data > data){
            node.lc = add(node.lc, data);
        }else if(node.data < data){
            node.rc = add(node.rc, data);
        }
        
        // 2. update node size 
        node.height = 1 + max(height(node.lc) , height(node.rc));

        // 3. get balance value
        int balance = balance(node);

        //4. **************************************    ROTATIONS    ************************************** 
        if(balance == 2 && data < node.lc.data){
            System.out.println("double right rotation");
            return rightRotation(node);
        }

        if(balance == -2 && data > node.rc.data){
            System.out.println("double left rotation");
            return leftRotation(node);
        }

        if(balance == 2 && data > node.lc.data){
            System.out.println("left right rotation");    
            node.lc = leftRotation(node.lc);
            return rightRotation(node);
        }

        if(balance == -2 && data < node.rc.data){
            System.out.println("right left rotation");
            node.rc = rightRotation(node.rc);
            return leftRotation(node);
        }
        return node;
    }
    

    // 5. remove function
    public void remove(int a){
        root = removeRecursive(root,a);
    }

    private Node removeRecursive(Node node,int a){
        if(node == null){
            return node;
        }else if(node.data < a){
            return removeRecursive(node.rc, a);
        }else if(node.data > a){
            return removeRecursive(node.lc, a);
        }else{
            if(node.lc == null){
                return node.rc;
            }else if(node.rc == null){
                return node.lc;
            }else{
                int leftMax = maxf(node.lc);
                node.data = leftMax;
                node.lc = removeRecursive(node.lc, leftMax);
            }
            return node;
        }
    }


    // 6. right Rotation function
    private Node rightRotation(Node node){
        Node y = node.lc;
        Node x = y.rc;

        // Rotation
        y.rc = node;
        node.lc = x;

        // Update
        node.height = 1 + max(height(node.lc) , height(node.rc));
        y.height = 1 + max(height(y.lc) , height(y.rc));

        return y;
    }

    // 7. left Rotation function
    private Node leftRotation(Node node){
        Node y = node.rc;
        Node x = y.lc;

        // Rotation
        y.lc = node;
        node.rc = x;
        // Update
        node.height = 1 + max(height(node.lc) , height(node.rc));
        y.height = 1 + max(height(y.lc) , height(y.rc));

        return y;
    }

    // 8. three different travel function
    public void preOrderTravel(Node node){
        preOrderTravelRecursive(root);
    }

    private void preOrderTravelRecursive(Node node){
        if(node != null){
            System.out.println(node.data + " ");
            preOrderTravelRecursive(node.lc);
            preOrderTravelRecursive(node.rc);
        }
    }

    public void inOrderTravel(Node node){
        inOrderTravelRecursive(root);
    }
    
    private void inOrderTravelRecursive(Node node){
        if(node != null){
            inOrderTravelRecursive(node.lc);
            System.out.println(node.data + " ");
            inOrderTravelRecursive(node.rc);
        }
    }

    public void postOrderTravel(Node node){
        postOrderTravelRecursive(root);
    }
    
    private void postOrderTravelRecursive(Node node){
        if(node != null){
            postOrderTravelRecursive(node.lc);
            postOrderTravelRecursive(node.rc);
            System.out.println(node.data + " ");
        }
    }

    // 9. balance function
    private int balance(Node node){
        return height(node.lc) - height(node.rc);
    }

    // 10. height function
    private int height(Node node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

    // 11. max function for delete function
    private int maxf(Node node){
        int maxdata = node.data;
        while(node.rc != null){
            maxdata = node.rc.data;
            node = node.rc;
        }
        return maxdata;
    }

    // 12. max function for balance and height function
    private int max(int a,int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}
