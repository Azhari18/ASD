package bab4;

class Node {
    Buku data;
    Node next;

    public Node(Buku data) {
        this.data = data;
    }
}

public class SingleLinkedList {
    private Node head;
    private Node tail;
    int size;

    boolean isEmpty() {
        return (size == 0);
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    public void sisipDataUrut(Buku data) {
        Node node = new Node(data);
        addFirst(node);
        Node temp = head;
        Buku sementara;
        while (temp != tail) {
            while (temp != tail) {
//                if (temp.data.getHargaSewa() == temp.next.data.getHargaSewa()){
                if (temp.data.getHargaSewa().equals(temp.next.data.getHargaSewa())) {
                    if (temp.data.getHargaDenda() > temp.next.data.getHargaDenda()) {
                        sementara = temp.data;
                        temp.data = temp.next.data;
                        temp.next.data = sementara;

                    }
                } else {
                    if (temp.data.getHargaSewa() > temp.next.data.getHargaSewa()) {
                        sementara = temp.data;
                        temp.data = temp.next.data;
                        temp.next.data = sementara;
                    }
                }
                temp = temp.next;
            }
        }
    }

    public void cetak(String kom) {
        System.out.println(kom);
        Node n = head;
//        if (n == null) {
//            System.out.println("data kosong");
//        } else {
//            while (n != null) {
//                System.out.print(n.data.getKategori() + " ");
//                System.out.print(n.data.getJudul() + " ");
//                System.out.print(n.data.getHargaSewa() + " ");
//                System.out.print(n.data.getHargaDenda() + " ");
//                System.out.println();
//                n = n.next;
//            }
//            System.out.println("null");
//        }
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }
}
