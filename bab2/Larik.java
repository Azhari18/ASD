package bab2;

import java.util.Arrays;

public class Larik {

    private int size;
    private int[] itemDt;

    public static void main(String[] args) {
        int[] A = {2, 34, 5, 7, 10};
        Larik lA = new Larik(A);
        lA.cetak("Sebelum");
//        lA.Sort(0).cetak("Sesudah di sort");
//        int k = lA.PencarianBiner(34,0,5);
//        System.out.println(k);
//
//        Larik lB = lA.Sort(0);
//        int p = lB.PencarianBiner(10, 0, 5);
//        System.out.println(p);
        System.out.println(Arrays.toString(lA.findPosKelipatan(5,0,4)));
        System.out.println(Arrays.toString(lA.bubleSort()));
    }

    int [] findPosKelipatan(int x0, int x1, int x2) {
        int count = 0;
        int [] hasil = new int [x2-x1];
        for (int i = x1; i <= x2; i++) {
            if (itemDt[i]%x0==0){
                hasil[count] = i;
                count++;
            }
        }
        int [] hasilFinal =  new int [count];
        for (int i=0; i<count; i++){
            hasilFinal[i] = hasil[i];
        }
        return hasilFinal;
    }

    int [] bubleSort (){
        int temp;
        for (int i = 0; i < itemDt.length; i++){
            for (int j = 0; j < itemDt.length - 1 - i; j++){
                if (itemDt[j] > itemDt [j+1]){
                    temp =itemDt[j];
                    itemDt[j] = itemDt[j+1];
                    itemDt[j+1] = temp;
                }
            }
        }
        return itemDt;
    }

    private Larik(int n) {
        buatLarik(n);
    }

    private Larik(int[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++)
            isiItem(i, dt[i]);
    }

    private void buatLarik(int n) {
        this.size = n;
        this.itemDt = new int[this.size];
    }

    private void isiItem(int id, int dt) {
        this.itemDt[id] = dt;
    }

    private int getSize() {
        return this.size;
    }

    private void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
        }
        System.out.println();
    }

    public int findBesar() {
        int besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    /**
     * program ini mencari posisi suatu data tertentu di larik
     */

    public int getPosisi(int dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private int getPosMax(int id) {
        int max = this.itemDt[id];
        int posMax = id;
        for (int i = id + 1; i < size; i++) {
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }

    private int getPosMin(int id) {
        int min = this.itemDt[id];
        int posMin = id;
        for (int i = id + 1; i < size; i++) {
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }

    private int PencarianBiner(int dtCari, int awal, int akhir) {
        int pos = -99;
        int tengah = (awal + akhir) / 2;
        if (dtCari < this.itemDt[tengah]) {
            return PencarianBiner(dtCari, awal, tengah);
        } else if (dtCari > this.itemDt[tengah]) {
            return PencarianBiner(dtCari, tengah + 1, akhir);
        } else if (dtCari == this.itemDt[tengah]) {
            return tengah;
        } else return pos;
    }

    /**
     * program untuk mencopy isi suatu Larik
     * mulai dari posisi k sebanyak n item hasilnya
     * dikeluarkan sebagai array baru
     */

    private Larik copyLarik(int k, int n) {
        Larik Hasil = null;
        if (n <= this.size - k) {
            Hasil = new Larik(n);
            int j = 0;
            for (int i = k; i < k + n; i++) {
                Hasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return Hasil;
    }

    /**
     * pilihan 0 : urutkan dari kecil ke besar
     * lainya : urutkan dari besar ke kecil
     * Algoritma pengurutan ini menggunakan selection sort
     */

    private Larik SelectionSort(int pilihan) {
        Larik lsort = copyLarik(0, size);
        for (int i = 0; i < lsort.getSize(); i++) {
            int posData;
            if (pilihan == 0){
                posData = lsort.getPosMin(i);
            } else {
                posData = lsort.getPosMax(i);
            }
            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }
}
