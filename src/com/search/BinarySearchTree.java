package com.search;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private class Node {
        private Value value;
        private Key key;
        private Node right;
        private Node left;
        private int size;

        public Node(Key key, Value value, int size) {
            this.value = value;
            this.key = key;
            this.size = size;
        }
    }

    private Node root;
    static final int COUNT = 10;

    public void delete(Node key) {

    }

    public boolean contains(Node key) {
        return false;
    }

    public int size() {
        if (root != null)
            return root.size;
        return 0;
    }

    public String get(int k) {
        return "";
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) {
            root = new Node(key, value, 1);
        } else if (key.compareTo(root.key) < 0) {
            root.left = put(root.left, key, value);
            root.size++;
        } else if (key.compareTo(root.key) > 0) {
            root.right = put(root.right, key, value);
            root.size++;
        } else {
            root.value = value;
        }

        return root;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.put(7, "Seven");
        bst.put(3, "Three");
        bst.put(8, "eight");
        bst.put(4, "Four");
        bst.put(1, "one");
        print2D(bst.root);
    }

    // Wrapper over print2DUtil()
    static void print2D(BinarySearchTree.Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    static void print2DUtil(BinarySearchTree.Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.printf("k:%d, s:%d\n", root.key, root.size);

        // Process left child
        print2DUtil(root.left, space);
    }


}
