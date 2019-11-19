package livicoding.soal1;

import java.util.Scanner;

class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    public class CircularSingleLinkedList {
        private Node head, tail;
        private int size;

        public void addLast(int dt) {
            Node baru = new Node(dt);
            baru.data = dt;
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

        public void move( int b) {
            Node temp = head;
            for (int i = 0; i < b ; i++){
                head = temp.next;
                temp = temp.next;
            }
        }

        public void cetak() {
        Node n = head;
            for (int i = 0; i < size - 1; i++){
                System.out.print(n.data + " ");
                n = n.next;
            }
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            CircularSingleLinkedList A = new CircularSingleLinkedList();
            String[] nd = input.nextLine().split(" "); // [n, d]
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            String[] aItems = input.nextLine().split(" "); // [a, b, c, d, ...]
            for (int i = 0; i < n; i++) {
                A.addLast(Integer.parseInt(aItems[i]));
            }
            A.move(d);
            A.cetak();
        }
    }



