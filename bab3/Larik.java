package bab3;

public class Larik {

    private int size;
    private double[] itemDt;

    public Larik(double[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++) {
            itemDt[i] = dt[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    public static double LarikKaliLarik (Larik l1, Larik l2){
        double hasil = 0 ;
        for (int i = 0; i < l1.getSize(); i++){
            hasil += (l1.itemDt[i]*l2.itemDt[i]);
        }
        return hasil ;
    }




    private void buatLarik(int n) {
        this.size = n;
        this.itemDt = new double[this.size];
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
        }
        System.out.println();
    }
}
