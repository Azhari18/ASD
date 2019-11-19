package bab5;

import bab4.Buku;

import java.util.Scanner;

class NodeDLL {
    Buku data;
    NodeDLL prev, next;

    public NodeDLL(Buku data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    private NodeDLL pKepala, pEkor;
    private int size;

    public void sisipDipKepala(Buku dt) {
        NodeDLL baru = new NodeDLL(dt);
        baru.data = dt;
        if (pKepala == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.next = pKepala;
            pKepala.prev = baru;
            pKepala = baru;
        }
    }


    public void sisipDipEkor(Buku data) {
        NodeDLL baru = new NodeDLL(data);
        baru.data = data;
        if (pEkor == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.prev = pEkor;
            pEkor.next = baru;
            pEkor = baru;
        }
    }

    void removeFirst() {
        NodeDLL temp = pKepala;
        if (isEmpty()) {
            if (pKepala == pEkor)
                pKepala = pEkor = null;
            else {
                pKepala.next.prev = null;
                pKepala = temp.next;
            }
            size--;
        } else
            System.out.println("Data is empty!");

    }

    public void cetak(String kom) {

        System.out.println(kom);
        NodeDLL n = pKepala;
        if (n == null) {
            System.out.println("data kosong");
        } else {
            while (n != null) {
                System.out.print(n.data.getKategori() + " ");
                System.out.print(n.data.getJudul() + " ");
                System.out.print(n.data.getHargaSewa() + " ");
                System.out.print(n.data.getHargaDenda() + " ");
                System.out.println();
                n = n.next;
            }
        }

    }

    boolean isEmpty() {
        return size == 0;
    }

    public void hapusDataTertentu(String dataHapus) {
        NodeDLL temp = pKepala;
        if (isEmpty()) {
            while (temp != null) {
                if (temp.data.getJudul().equals(dataHapus)) {
                    if (temp == pKepala) {
                        this.removeFirst();
                        size--;
                        break;
                    } else {
                        if (temp.next == null) {
                            pEkor = temp.prev;
                            pEkor.next = null;
                        } else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                        }
                        size--;
                        break;
                    }
                }
                temp = temp.next;
            }
        } else
            System.out.println("Data is empty!");
        size--;
    }


    public void sisipDataUrut(Buku data) {
        NodeDLL node = new NodeDLL(data);
        sisipDipKepala(data);
        NodeDLL temp = pKepala;
        Buku sementara;
        while (temp != pEkor) {
            while (temp != pEkor) {
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


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000.0, 3000.0);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500.0, 2500.0);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000.0, 7000.0);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000.0, 4000.0);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000.0, 5000.0);
        buku1.cetak();
        buku2.cetak();
        buku3.cetak();
        buku4.cetak();
        buku5.cetak();
        boolean exit ;

        DoubleLinkedList ll = new DoubleLinkedList();
        do {

            System.out.println("1.sisip data di pKepala");
            System.out.println("2.sisip data di pEkor");
            System.out.println("3.hapus data tertentu");
            System.out.println("4.sisip data terurut");
            System.out.print("Masukan pilihan : ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    ll.sisipDipKepala(buku1);
                    ll.sisipDipKepala(buku2);
                    ll.sisipDipKepala(buku3);
                    ll.sisipDipKepala(buku4);
                    ll.sisipDipKepala(buku5);
                    break;
                case 2:
                    ll.sisipDipEkor(buku1);
                    ll.sisipDipEkor(buku2);
                    ll.sisipDipEkor(buku3);
                    ll.sisipDipEkor(buku4);
                    ll.sisipDipEkor(buku5);
                    break;
                case 3:
                    System.out.println(input.nextLine());
                    System.out.print("masukan judul buku yang mau dihapus : ");
                    ll.hapusDataTertentu(input.nextLine());
                    break;
                case 4:
                    ll.sisipDataUrut(buku1);
                    ll.sisipDataUrut(buku2);
                    ll.sisipDataUrut(buku3);
                    ll.sisipDataUrut(buku4);
                    ll.sisipDataUrut(buku5);
            }
            ll.cetak("Linked List Buku");

            System.out.print("exit ? ");
            exit = input.nextBoolean();
        } while (!exit);
    }
}
