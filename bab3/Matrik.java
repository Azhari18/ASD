package bab3;

        import bab3.Larik;

public class Matrik {
    // Data

    private int nBaris, nKolom;
    private double[][] itemDt;

    public static void main(String[] args) {
        // implementasi untuk ADT_Matrik

        Matrik A,B,C;
        double [][] X = {{1, 2, 3},{2, 14, 5},{16, 8, 13}};
        double [][] Y = {{10, 12, 0},{5, 1, 5},{3, 1, 10}};

        A = new Matrik(X);
        B = new Matrik(Y);

        A.cetak("Matrik A");
        B.cetak("Matrik B");

        C = A.tambah(B);
        C.cetak("Matrik C = A+B");

        Larik lb,lk;
        lb = C.getBaris(1);
        lb.cetak("Larik  baris ke-1");
        lk = C.getKolom(1);
        lk.cetak("Larik kolom ke-1");

        System.out.println(A.determinan());
        A.transposeMatrik().cetak("transpose A: ");
        A.kali(B).cetak("Hasil kali A dan B : ");
    }

    public double determinan (){
        double A = 0 ;
        if (getNBaris() == getNKolom()){
            if (getNBaris()==3){
                A = (itemDt [0][0]*itemDt[1][1]*itemDt[2][2]) + (itemDt [0][1]*itemDt[1][2]*itemDt[2][0]) + (itemDt [0][2]*itemDt[1][0]*itemDt[2][1])-
                        (itemDt [2][0]*itemDt[1][1]*itemDt[0][2]) - (itemDt [2][1]*itemDt[1][2]*itemDt[0][0]) - (itemDt [2][2]*itemDt[1][0]*itemDt[0][1]);
            } else if (getNBaris() == 2){
                A = (itemDt [0][0] * itemDt[1][1]) - (itemDt[0][1]*itemDt[1][0]);
            }
        }
        return A;
    }

    public Matrik transposeMatrik (){
        double [][] baru = new double[getNKolom()][getNBaris()];
        for (int i = 0; i < getNKolom(); i ++){
            for (int j = 0; j < getNBaris(); j ++){
                baru[i][j] = itemDt [j][i];
//                System.out.println("baris : " + i + " kolom : " + j + " = " + baru[i][j]);
            }
        }
        Matrik A = new Matrik(baru);
        return A;
    }

    public Matrik kali (Matrik m){

//        double [][] baru = new double[getNBaris()][getNKolom()];
        double[][] hasil = new double[getNBaris()][m.getNKolom()];
        for (int i = 0; i < getNBaris(); i++) {
            for (int j = 0; j < m.getNKolom(); j++) {
                int x = 0;
                for (int k = 0; k < m.getNBaris(); k++) {
                    x += itemDt[i][k] * m.itemDt[k][j];
                }
                hasil[i][j] = x;
            }
        }
        Matrik A = new Matrik(hasil);
        return A;
    }


    public Larik getBaris (int n){
        double[] hasil = new double[getNKolom()];
        for (int i = 0; i < getNKolom(); i++){
            hasil[i] = itemDt[n-1][i];
        }
        Larik A = new Larik(hasil);
        return A ;
    }

    public Larik getKolom (int n){
        double[] hasil = new double[getNBaris()];
        for (int i = 0; i < getNBaris(); i++){
            hasil[i] = itemDt[i][n-1];
        }
        Larik A = new Larik(hasil);
        return A ;
    }

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] dt) {
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.setItem(i, j, dt[i][j]);
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

    public Matrik tambah(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j, this.itemDt[i][j] + x.getItem(i, j));
                }
            }
        }
        return y;
    }


    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.print(this.itemDt[i][j] + " ");
            }
            System.out.println();
        }
    }
}