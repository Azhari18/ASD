package bab1.Tugas_1;

public class Perpus {
    public static void main(String[] args) {
        Buku doraemon = new Buku("Doraemon","Komik", 1000, 100);
        System.out.println("Peminjaman " + doraemon.getJenisBuku() + " "
                + doraemon.getNamaBuku() + " Selama 4 hari akan menghasilkan biaya sewa sebesar Rp"
                + doraemon.getBiayaSewa(4) + ",00. Apabila terlambat 2 hari, maka peminjam wajib membayar denda sebesar Rp"
                + doraemon.getDenda(2) + ",00.");
    }

//    public static void kataHati() {
//        System.out.print("I LOVE U ");
//    }
//    public static int love() {
//        return 3000;
//    }
//
//    public static void main(String[] args){
//        kataHati();
//        System.out.print(love());
//    }

}
