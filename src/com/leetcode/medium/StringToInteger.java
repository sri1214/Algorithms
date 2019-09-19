package com.leetcode.medium;

public class StringToInteger {

    public static void main(String[] args){
        System.out.println("String to Integer");
        StringToInteger s2i = new StringToInteger();
        System.out.println(s2i.myAtoi("20000000000000000000"));
    }

    public int myAtoi(String str) {
        if(str==null||str.isEmpty()) return 0;
        Node node = null;Node temp = null;
        int j=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if((c>47&&c<58)|| (j<1 && (c=='-'||c=='+'))){
                System.out.println("input char: "+c);
                if(node == null){
                    temp=new Node(c);
                    node = temp;
                }
                else{
                    temp.next = new Node(c);
                    temp = temp.next;
                }
                j++;
            }
            else if(j<1&&c==' ') continue;
            else break;
        }
        long value = getNumber(node, j);
        if(value>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(value<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)value;

    }

    private long getNumber(Node node, int counter){
        long value = 0;
        char sign = '+';
        System.out.println("Counter: "+counter);
        while(node!=null){
            char c = node.value;
            node = node.next;
            System.out.println("output char: "+c);
            if(c=='-'||c=='+') {
                sign = c;
                counter--;
                continue;
            }

            value = value + ((c-48) * (long)Math.pow(10, --counter));
            System.out.println("Value: "+value);
        }
        if(sign=='-') return 0 - value;
        return value;
    }

    class Node {
        Node next;
        char value;

        public Node(char value){
            this.next = null;
            this.value = value;
        }
    }
}
