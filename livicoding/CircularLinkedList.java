package livicoding;

import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return String.format("%s", data);
    }
}

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(int value) {
        Node baru = new Node(value);
        if (head == null) {
            baru.next = baru;
            head = baru;
            tail = baru;
            size++;
        }
        tail.next = baru;
        baru.next = head;
        tail = baru;
        size++;

    }

    public CircularLinkedList reverse() {
        CircularLinkedList A = new CircularLinkedList();
        Node B = tail;
        for (int i = 0; i < size; i++) {
            A.addLast(B.data);
//            for (int j = 0; j < size - 1; j++) {
//                B = B.next;
//            }
        }
        return A;
    }
//    public String toString() {
//        return String.valueOf();
//
//    }

        public void cetak () {
            Node n = head;
            for (int i = 0; i < size ; i++) {
                System.out.print(n.data + " ");
                n = n.next;
            }
        }

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            CircularLinkedList clist1 = new CircularLinkedList();

            String[] aItems = sc.nextLine().split(" ");

            for (int i = 0; i < aItems.length; i++) {
                clist1.addLast(Integer.parseInt(aItems[i]));
            }
            clist1.cetak();
//            CircularLinkedList clist2 = clist1.reverse();

//            System.out.println(clist2);
            sc.close();
        }

    }