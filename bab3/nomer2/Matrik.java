package bab3.nomer2;


import bab3.Larik;

/**
 * ADT Matrik
 *
 * @author achmad ridok
 */



public class Matrik {
    private int nBaris, nKolom;
    private double[][] itemDt;

    public static void main(String[] args) {

        Matrik A,B,C;
        double [][]data1 = {{1,2,3},{3,4,7}};
        double [][]data2 = {{4,5,1},{6,1,9}};
        A = new Matrik(data1);
        B = new Matrik(data2);
        A.cetak("A"); B.cetak("B");
        C = Matrik.tambah(A,B);
        C.cetak("C");
        System.out.println("Determinan C :"+C.determinan());
        Matrik CT = Matrik.tranpos(C);
        CT.cetak("Tranpos");
        Larik l1 = C.getBaris(1);
        l1.cetak("Baris ke 1 dari C");
        Larik l2 = Matrik.VektorKaliMatrik(l1,CT);
        l2.cetak("Hasil kali C.L1");
    }

    /**
     * constructor untuk membuat suatu matrik
     *
     * @param nBrs : banyaknya baris
     * @param nKlm : banyaknya kolom
     */

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    /**
     * constructor untuk membuat matrik dari array 2 dimensi
     *
     * @param A : array dua dimensi
     */

    public Matrik(double[][] A) {
        this(A.length, A[0].length); // panggil contructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

    /**
     * Fungsi untuk mendapatakan jumlah baris
     *
     * @return jumlah baris
     */

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    /**
     * fungsi tambah antara dua matrik A dan B
     * @param A : Matrik
     * @param B : Matrik
     * @return Matrik hasil
     */

    public static Matrik tambah(Matrik A, Matrik B){
        double [][] hasil = new double[A.getNBaris()][A.getNKolom()] ;
        for (int i = 0; i < A.getNBaris(); i++){
            for (int j = 0 ;j < A.getNKolom(); j++){
                hasil [i][j] = A.itemDt[i][j] + B.itemDt[i][j];
            }
        }
        Matrik c = new Matrik(hasil);
        return c;
    }

    /**
     * fungsi static perkalian antara vektor dengan matrik
     * Syarat : lebar L sama dengan jumlah baris M
     *
     * @param L : Vector (Larik)
     * @param M : Matrik
     * @return Vector (Larik) berdimensi nKolom dari M
     */

    public static Larik VektorKaliMatrik(Larik L, Matrik M) {

        Larik lHasil = null;
        Larik lKolom = null;
        if (L.getSize() == M.getNBaris()) {
            double [] A = new double[M.getNKolom()];
            lHasil = new Larik(A);
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }

    /**
     * fungsi static determinan matriks
     * @return double determinan
     */

    public String determinan (){
        double A = 0;
        if (getNBaris() == getNKolom()){
            if (getNBaris()==3){
                A = (itemDt [0][0]*itemDt[1][1]*itemDt[2][2]) + (itemDt [0][1]*itemDt[1][2]*itemDt[2][0]) + (itemDt [0][2]*itemDt[1][0]*itemDt[2][1])-
                        (itemDt [2][0]*itemDt[1][1]*itemDt[0][2]) - (itemDt [2][1]*itemDt[1][2]*itemDt[0][0]) - (itemDt [2][2]*itemDt[1][0]*itemDt[0][1]);
            } else if (getNBaris() == 2){
                A = (itemDt [0][0] * itemDt[1][1]) - (itemDt[0][1]*itemDt[1][0]);
            }
        } else {
            return " Bukan matriks persegi" ;
        }
        return "matriks persegi" ;
    }

    /**
     * fungsi static tranpos suatu matrik
     * @param A : Matrik
     * @return Matrik tranpos
     */


    public static Matrik tranpos(Matrik A){
        double [][] baru = new double[A.getNKolom()][A.getNBaris()];
        for (int i = 0; i < A.getNKolom(); i ++){
            for (int j = 0; j < A.getNBaris(); j ++){
                baru[i][j] = A.itemDt [j][i];
//                System.out.println("baris : " + i + " kolom : " + j + " = " + baru[i][j]);
            }
        }
        Matrik B = new Matrik(baru);
        return B;
    }

    /**
     * fungsi untuk mendapatkan vektor baris dari matrik
     * @param idBaris : indek baris yang akan diekstrak
     * @return Larik representasi baris
     */

    public Larik getBaris (int idBaris){
        double[] hasil = new double[getNKolom()];
        for (int i = 0; i < getNKolom(); i++){
            hasil[i] = itemDt[idBaris][i];
        }
        Larik A = new Larik(hasil);
        return A ;
    }

    /**
     * fugsi untuk mendapatkan vektor kolom suatu matrik
     *
//     * @param idKolom : id kolom yang akan diekstrak
     * @return Larik representasi kolom
     */

    public Larik getKolom (int idKolom){
        double[] hasil = new double[getNBaris()];
        for (int i = 0; i < getNBaris(); i++){
            hasil[i] = itemDt[i][idKolom];
        }
        Larik A = new Larik(hasil);
        return A ;
    }

    /**
     * procedure cetak
     *
     * @param kom
     */

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDt[i][j]);
            }
            System.out.println();
        }
    }
}


