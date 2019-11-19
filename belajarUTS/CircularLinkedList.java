package belajarUTS;

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

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void addLast(int value) {
        Node input = new Node(value);
        if (head == null){
            head = tail = input;
            tail.next = head;
        } else {
            tail.next = input;
            tail = input ;
            tail.next = head;
        }
    }



    public void moveLeft(int d) {
        Node temp = head ;
        for (int i = 0; i < d;i++){
            tail = temp;
            temp = temp.next;
        }
        head = temp;

    }

    public String toString() {
        Node temp = head;
        StringBuilder hasil = new StringBuilder();
        while (temp != tail){
            hasil.append(temp.data).append(" ");
            temp = temp.next;
        }
        hasil.append(temp.data).append(" ");
    return hasil.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList clist = new CircularLinkedList();

        String[] nd = sc.nextLine().split(" "); // [n, d]
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);

        String[] aItems = sc.nextLine().split(" "); // [a, b, c, d, ...]

        for (int i = 0; i < n; i++) {
            clist.addLast(Integer.parseInt(aItems[i]));
        }

        clist.moveLeft(d);

        System.out.println(clist);
        sc.close();
    }

}
