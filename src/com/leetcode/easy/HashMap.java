package com.leetcode.easy;

public class HashMap {

    public static void main(String[] args) {
        HashMap obj = new HashMap();
        obj.put(2, 1);
        System.out.printf("get 2: %d", obj.get(2));
        obj.remove(2);
        System.out.printf("get 2: %d", obj.get(2));
    }

    private Node[] nodeArray ;
    private final int SIZE = 7;

    /** Initialize your data structure here. */
    public HashMap() {
        nodeArray = new Node[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int mod = key % SIZE;
        Node node = nodeArray[mod];
        Node prevNode = null;
        while(node!=null){
            if(node.key==key) break;
            prevNode = node;
            node = node.next;
        }
        if(node==null) {
            node = new Node(key, value);
            if(prevNode!=null) prevNode.next = node;
            else nodeArray[mod] = node;
        }
        else node.value = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int mod = key % SIZE;
        Node node = getMatch(nodeArray[mod], key);
        if(node!=null) return node.value;
        else return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int mod = key % SIZE;
        Node node = nodeArray[mod];
        Node prevNode = node;
        while(node!=null){
            if(node.key==key) break;
            prevNode = node;
            node = node.next;
        }
        if(node!=null) {
            prevNode.next = node.next;
        }
    }

    private Node getMatch(Node node, int key){
        while(node!=null){
            if(node.key==key) return node;
            node = node.next;
        }
        return null;
    }

    class Node{
        private int key;
        private int value;
        private Node next;

        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}
