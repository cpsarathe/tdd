package csfundamental.tree;

import java.util.*;

public class BinaryTree {
    TNode root = null;

    public static void main(String[] ar) {
//        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130};
        int[] array = {4,4,4,4,9,5};
        BinaryTree binaryTree = new BinaryTree();
//        TNode node = binaryTree.formBST(array, 0, array.length - 1);
        TNode root = null;
        int i = 0;
        root = binaryTree.insertLevelOrder(array, root, i);
        System.out.println("hi");

//        Queue<TNode> queue = new LinkedList<>();
//        queue.add(root);
//        binaryTree.traverseLevelOrder(root, queue);
//
//        System.out.println(binaryTree.isSymmetricTree(root));
//

        //binaryTree.levelOrderBottom(root);

//        binaryTree.zigzagLevelOrder(root);

//        binaryTree.rightSideView(root);

//        System.out.println(binaryTree.longestUnivaluePath(root));
    }


    public TNode formBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TNode root = new TNode(array[mid]);
        root.left = formBST(array, 0, mid - 1);
        root.right = formBST(array, mid + 1, end);
        return root;
    }

    public TNode insertLevelOrder(int[] array, TNode root, int i) {
        if (i < array.length) {
            root = new TNode(array[i]);
            root.left = insertLevelOrder(array, root.left, 2 * i + 1);
            root.right = insertLevelOrder(array, root.right, 2 * i + 2);
        }
        return root;
    }

    public void traverseLevelOrder(TNode root, Queue<TNode> queue) {
        while (!queue.isEmpty()) {
            TNode node = queue.peek();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            queue.poll();
        }
    }

    public boolean isSymmetricTree(TNode root) {
        return isSymmetricSubTree(root.left, root.right);
    }

    public boolean isSymmetricSubTree(TNode leftTree, TNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        // return true if
        // 1. both trees are non-empty and
        // 2. left subtree is mirror image of right subtree and
        // 3. right subtree is mirror image of left subtree
        if (leftTree != null && rightTree != null) {
            boolean isLeftTreeSymmetric = isSymmetricSubTree(leftTree.left, rightTree.right);
            boolean isRightTreeSymmetric = isSymmetricSubTree(leftTree.right, rightTree.left);
            return isLeftTreeSymmetric && isRightTreeSymmetric;
        }
        return false;
    }

    /**
     * Leet code
     *
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     *
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrderBottom(TNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> mainList = new ArrayList();
        Queue<TNode> queue = new LinkedList();
        queue.add(root);

        int count = 1;
        while (!queue.isEmpty()) {
            int x = 0;
            List<Integer> subList = new ArrayList();
            for (int i = 0; i < count; i++) {
                TNode node = queue.peek();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    x++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    x++;
                }
                queue.poll();
            }
            count = x;
            mainList.add(subList);
        }
        Collections.reverse(mainList);
        System.out.println(mainList);
        return mainList;
    }

    /**
     * Leet code
     *
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     *
     * @param root
     * @return
     */

    public List<List<Integer>> zigzagLevelOrder(TNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> mainList = new ArrayList();
        Queue<TNode> queue = new LinkedList();
        queue.add(root);

        int count = 1 , mainRunIndex = 1;
        while (!queue.isEmpty()) {
            int x = 0;
            List<Integer> subList = new ArrayList();
            for (int i = 0; i < count; i++) {
                TNode node = queue.peek();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    x++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    x++;
                }
                queue.poll();
            }
            count = x;
            if(mainRunIndex % 2 == 0) {
                Collections.reverse(subList);
            }
            mainList.add(subList);
            mainRunIndex++;
        }
        System.out.println(mainList);
        return mainList;
    }

    /**
     * The Right view contains all nodes that are last nodes in their levels.
     * We have to remove from queue in the iteration of all subchilds until we reach last item in queue.
     * https://leetcode.com/problems/binary-tree-right-side-view/
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> subList = new ArrayList();
        Queue<TNode> queue = new LinkedList();
        queue.add(root);

        int count = 1 ;
        while (!queue.isEmpty()) {
            int x = 0;
            while(count != 0){
                TNode node = queue.peek();
                queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    x++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    x++;
                }
                if(count == 1){
                    subList.add(node.val);
                }
                count--;
            }
            count = x;
        }
        System.out.println(subList);
        return subList;
    }




}
