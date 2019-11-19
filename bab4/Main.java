package bab4;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000.0, 3000.0);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500.0, 2500.0);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000.0, 7000.0);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000.0, 4000.0);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000.0, 5000.0);
        SingleLinkedList ll = new SingleLinkedList ();
        ll.sisipDataUrut(buku1);
        ll.sisipDataUrut(buku2);
        ll.sisipDataUrut(buku3);
        ll.sisipDataUrut(buku4);
        ll.sisipDataUrut(buku5);
        ll.cetak("Linked List Buku");
    }
}
