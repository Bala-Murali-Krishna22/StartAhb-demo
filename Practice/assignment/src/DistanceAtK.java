public class DistanceAtK {

    public static void nodeVales(){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        int k = 2;

        distanceK(node, k);
    }

    public static void distanceK(Node node, int k){
        if(k == 0){
            System.out.print(node.data+" ");
            return;
        }

        distanceK(node.left, k - 1);
        distanceK(node.right, k - 1);
    }

}//distance

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}//node
