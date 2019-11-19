package Tugas;

/*
 * @author
 * Ibrahimsyah Zairussalam - 185150400111001
 * Azhari Arsyad - 185150400111007
 */
class Buku {

    double sewa;
    double denda;
    String judul;
    String kategori;

    public Buku(double sewa, double denda, String judul, String kategori) {
        this.sewa = sewa;
        this.denda = denda;
        this.judul = judul;
        this.kategori = kategori;
    }
}

class Node {

    Buku buku;
    Node pKiri;
    Node pKanan;
    Node pInduk;
    int tinggi;

    public Node(Buku buku, int tinggi, Node kiri, Node kanan, Node induk) {
        this.buku = buku;
        this.pKiri = kiri;
        this.pKanan = kanan;
        this.tinggi = tinggi;
        this.pInduk = induk;
    }

}

public class AVL {

    Node root;

    public boolean insert(Buku dt) {
        if (root == null) {
            root = new Node(dt, 1, null, null, null);
            return true;
        } //tree tidak kosong
        else {
            Node temp = root;
            Node prev = null;
            while (temp != null) {
                if (dt.sewa == temp.buku.sewa) {
                    return false;
                } //sisip dt di subtree pKiri
                else if (dt.sewa < temp.buku.sewa) {
                    prev = temp;
                    temp = temp.pKiri;
                } //sisip dt di subtree pKanan
                else {
                    prev = temp;
                    temp = temp.pKanan;
                }
            }
            temp = new Node(dt, 1, null, null, prev);
            if (dt.sewa < prev.buku.sewa) {
                prev.pKiri = temp;//sisip di pKiri
            } else {
                prev.pKanan = temp;
            }

            while (temp != null) {
                if (Math.abs(tinggi(temp.pKiri) - tinggi(temp.pKanan)) <= 1) {
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } //kasus 1 algoritma AVL
                else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2 && tinggi(temp.pKiri.pKiri) >= tinggi(temp.pKiri.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKiri = temp.pKiri;
                    temp.pKiri = pKiri.pKanan;
                    if (temp.pKiri != null) {
                        temp.pKiri.pInduk = temp;
                    }
                    pKiri.pKanan = temp;
                    temp.pInduk = pKiri;
                    pKiri.pInduk = parent;
                    if (parent == null) {
                        root = pKiri;
                    } else if (parent.pKiri == temp) {
                        parent.pKiri = pKiri;
                    } else {
                        parent.pKanan = pKiri;
                    }
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } //case 2 algoritma AVl
                else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2 && tinggi(temp.pKanan.pKanan) >= tinggi(temp.pKanan.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKanan = temp.pKanan;
                    temp.pKanan = pKanan.pKiri;
                    if (temp.pKanan != null) {
                        temp.pKanan.pInduk = temp;
                    }
                    pKanan.pKiri = temp;
                    temp.pInduk = pKanan;
                    pKanan.pInduk = parent;
                    if (parent == null) {
                        root = pKanan;
                    } else if (parent.pKanan == temp) {
                        parent.pKanan = pKanan;
                    } else {
                        parent.pKiri = pKanan;
                    }
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } //kasus 3 dari algoritma AVL
                else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2 && tinggi(temp.pKiri.pKanan) >= tinggi(temp.pKiri.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKiripKanan = temp.pKiri.pKanan;
                    temp.pKiri.pKanan = pKiripKanan.pKiri;
                    if (temp.pKiri.pKanan != null) {
                        temp.pKiri.pKanan.pInduk = temp.pKiri;
                    }
                    pKiripKanan.pKiri = temp.pKiri;
                    temp.pKiri.pInduk = pKiripKanan;
                    temp.pKiri = pKiripKanan.pKanan;
                    if (temp.pKiri != null) {
                        temp.pKiri.pInduk = temp;
                    }
                    pKiripKanan.pKanan = temp;
                    temp.pInduk = pKiripKanan;
                    pKiripKanan.pInduk = parent;
                    if (parent == null) {
                        root = pKiripKanan;
                    } else if (parent.pKiri == temp) {
                        parent.pKiri = pKiripKanan;
                    } else {
                        parent.pKanan = pKiripKanan;
                    }
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiripKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } //kasus 4 dari algoritma AVL
                else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2 && tinggi(temp.pKanan.pKiri) >= tinggi(temp.pKanan.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKananpKiri = temp.pKanan.pKiri;
                    temp.pKanan.pKiri = pKananpKiri.pKanan;
                    if (temp.pKanan.pKiri != null) {
                        temp.pKanan.pKiri.pInduk = temp.pKanan;
                    }
                    pKananpKiri.pKanan = temp.pKanan;
                    temp.pKanan.pInduk = pKananpKiri;
                    temp.pKanan = pKananpKiri.pKiri;
                    if (temp.pKanan != null) {
                        temp.pKanan.pInduk = temp;
                    }
                    pKananpKiri.pKiri = temp;
                    temp.pInduk = pKananpKiri;
                    pKananpKiri.pInduk = parent;
                    if (parent == null) {
                        root = pKananpKiri;
                    } else if (parent.pKanan == temp) {
                        parent.pKanan = pKananpKiri;
                    } else {
                        parent.pKiri = pKananpKiri;
                    }
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKananpKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                temp = temp.pInduk;
            }
            return true;
        }
    }

    int tinggi(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.tinggi;
        }
    }
    void urut(){
        if(root != null)urutin(root);
    }
    void urutin(Node n){
        if(n == null)return;
        urutin(n.pKanan);
        System.out.printf("%-10s|%-10s|%-6.0f|%-6.0f\n", n.buku.judul, n.buku.kategori, n.buku.sewa, n.buku.denda);
        urutin(n.pKiri);
    }

    public static void main(String[] args) {
        Buku b1 = new Buku (20000, 1000, "A", "A");
        Buku b2 = new Buku (10000, 1000, "B", "B");
        Buku b3 = new Buku (5000, 1000, "C", "C");
        Buku b4 = new Buku (2000, 1000, "D", "D");
        AVL a = new AVL();
        a.insert(b4);
        a.insert(b2);
        a.insert(b1);
        a.insert(b3);
        System.out.printf("%-10s|%-10s|%-6s|%-6s\n", "judul", "kategori", "sewa", "denda");
        a.urut();
    }
}
