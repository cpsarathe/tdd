package csfundamental.tree;

public class RangeSumBTS {

    public static void main(String[] ar) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        RangeSumBTS rangeSumBTS = new RangeSumBTS();
        TNode root = new TNode(10);
        binarySearchTree.addNode(root, 5);
        binarySearchTree.addNode(root, 15);
        binarySearchTree.addNode(root, 3);
        binarySearchTree.addNode(root, 7);
        binarySearchTree.addNode(root, 18);

        rangeSumBTS.rangeSumBST(root,7,15);

    }
    public int rangeSumBST(TNode root, int L, int R) {
        TNode temp = root;
        int sum = inOrderSum(temp, L , R);
        System.out.println(sum);
        return sum;
    }

    public int inOrderSum(TNode node , int L , int R){
        if(node == null) {
            return 0;
        }
        else if(node.val<=L && node.val >=R) {
            return node.val + inOrderSum(node.left, L , R) + inOrderSum(node.right, L , R);
        }
        else if(node.val < L) {
            return node.val + inOrderSum(node.right, L , R);
        }
        else if(node.val < R) {
            return node.val + inOrderSum(node.left, L , R);
        }
        else {
            return 0;
        }
    }

}
