package csfundamental.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    TNode top;

    public static void main(String[] ar) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        TNode root1 = new TNode(30);
//        binarySearchTree.addNode(root1,10);
//        binarySearchTree.addNode(root1,12);
//        binarySearchTree.addNode(root1,21);
//        binarySearchTree.addNode(root1,7);
//        binarySearchTree.addNode(root1,14);
//
//        binarySearchTree.inOrderTraversal(root1);
//        TNode node = binarySearchTree.search(root1,12);
//        System.out.println("**************");
//        System.out.println(node.val);
//        System.out.println("**************");
//        System.out.println("Min:"+ binarySearchTree.findMin(root1).val);
//        System.out.println("**************");
//        System.out.println("Max:"+ binarySearchTree.findMax(root1).val);

        TNode root = new TNode(30);
        binarySearchTree.addNode(root, 10);
        binarySearchTree.addNode(root, 40);
        binarySearchTree.addNode(root, 52);
        binarySearchTree.addNode(root, 12);
        binarySearchTree.addNode(root, 15);
        binarySearchTree.addNode(root, 11);
        binarySearchTree.addNode(root, 7);
        binarySearchTree.addNode(root, 2);
        binarySearchTree.addNode(root, 32);
        binarySearchTree.addNode(root, 37);
        binarySearchTree.addNode(root, 58);

        System.out.println("*************************");
//        binarySearchTree.inOrderTraversal(root);
//        binarySearchTree.delete(root,10);
//        System.out.println("*************************");
//        binarySearchTree.inOrderTraversal(root);
//        System.out.println("*************************");
//        System.out.println(binarySearchTree.isBalanced(root));
//        System.out.println("*************************");
//        System.out.println(binarySearchTree.height(root));

//        List<TNode> nodes = new ArrayList<>();
//                binarySearchTree.findLeafNodes(root,nodes);
//        for (TNode node : nodes) {
//            System.out.println(node.val);
//        }

//        binarySearchTree.preOrderTraversal(root);

//        binarySearchTree.levelOrderTraversal(root);

        System.out.println(binarySearchTree.maxLevelSum(root));

    }

    public TNode addNode(TNode root, int val) {
        if (root == null) {
            return new TNode(val);
        } else {
            if (val > root.val) {
                root.right = addNode(root.right, val);
            } else if (val < root.val) {
                root.left = addNode(root.left, val);
            }
        }
        return root;
    }

    public void inOrderTraversal(TNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    public TNode search(TNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val > root.val) {
            return search(root.right, val);
        }
        if (val < root.val) {
            return search(root.left, val);
        }
        return null;
    }

    public TNode findMin(TNode root) {
        TNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }


    public TNode findMax(TNode root) {
        TNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }


    public TNode delete(TNode root, int val) {
        if (root == null) {
            return root;
        } else if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            //value is now equal to current node

            //case 2 when to be deleted node has child in only 1 side
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            //case 3 when to be deleted node has child subtree
            else {
                TNode node = this.findMin(root.right); // we need to respect bst rule for root , left , right rule
                root.val = node.val;
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }

    public boolean isBalanced(TNode root) {
        //tree is balanced if height of left subtree is 1 distance apart from height of right subtree.
        return getMaxHeight(root) - getMinHeight(root) <= 1;
    }

    public int getMaxHeight(TNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxHeight(root.left), getMaxHeight(root.right));
    }

    public int getMinHeight(TNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(getMinHeight(root.left), getMaxHeight(root.right));
    }

    public int height(TNode root) {
        int left = 0, right = 0;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        }
        left = 1 + height(root.left);
        right = 1 + height(root.right);
        return Math.max(left, right);
    }

    public void findLeafNodes(TNode root, List<TNode> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root);
            }
            if (root.left != null) {
                findLeafNodes(root.left, list);
            }
            if (root.right != null) {
                findLeafNodes(root.right, list);
            }

        }
    }

    public void flattenBST(TNode root) {

    }

    public void preOrderTraversal(TNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void levelOrderTraversal(TNode root) {
        if (root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode node = queue.peek();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            queue.remove();
        }
    }

    /**
     * somewhat similar to find height of node
     * @param root
     * @return
     */
    public int minDepth(TNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        int left = 0 , right = 0;
        if(root.left!=null) {
            left = 1 + minDepth(root.left);
        }
        if(root.right!=null) {
            right = 1 + minDepth(root.right);
        }

        //when there is no left child at all
        int min = 0;
        if(left==0) {
            min = right;
        }
        //when there is no right child at all
        if(right==0) {
            min = left;
        }

        if(left > 0 && right > 0) {
            min = Math.min(left,right);
        }

        return min;
    }

    /**
     * Level order traversal , however here queue is looped and pollled for each set of nodes instead of one by one node
     * @param root
     * @return
     */
    public int maxLevelSum(TNode root) {
        if(root==null) {
            return 0;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 1 , maxSum = 0 , maxSumLevel = 0 , currentRow = 0;
        while(!queue.isEmpty()) {
            currentRow++;
            int sum = 0 , x =0;
            for(int i=0;i<count;i++) {
                TNode temp = queue.poll();
                sum = sum + temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                    x++;
                }
                if(temp.right!=null) {
                    queue.add(temp.right);
                    x++;
                }
            }
            count = x;
            if(sum>maxSum){
                maxSum = sum;
                maxSumLevel = currentRow;
            }
        }
        return maxSumLevel;
    }


}

