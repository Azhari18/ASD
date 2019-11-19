package belajarUTS.nomer2;

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
        Node input = new Node(value);
        if (head == null) {
            head = tail = input;
            tail.next = head;
        } else {
            tail.next = input;
            tail = input;
            tail.next = head;
        }
        size++;
    }

    public CircularLinkedList reverse() {
        Node temp = tail;
        int count = size;
        CircularLinkedList a = new CircularLinkedList();
        for (int i = 0; i < size; i++) {
            a.addLast(temp.data);
            for (int j = 0; j < size-1 ; j++) {
                temp = temp.next;
            }
        }
        return a;
    }

    public String toString() {
        Node temp = head;
        StringBuilder hasil = new StringBuilder();
        if (head != null){
            while (temp != tail) {
                hasil.append(temp.data).append(" ");
                temp = temp.next;
            }
            hasil.append(temp.data).append(" ");
        }
        return hasil.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList clist1 = new CircularLinkedList();

        String[] aItems = sc.nextLine().split(" ");

        for (int i = 0; i < aItems.length; i++) {
            clist1.addLast(Integer.parseInt(aItems[i]));
        }

        CircularLinkedList clist2 = clist1.reverse();

        System.out.println(clist2);
        sc.close();
    }

}
