package seleksiKondisi;

import java.util.Scanner;

public class kelasTambahan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int uangJajan = input.nextInt();
        boolean traktir = false;

//        conditional assignment
        boolean jajan = (uangJajan > 0) ? true : false;

//        if else
        if (uangJajan > 50000) {
            traktir = true;
        } else {
            System.out.println("gak bisa traktir");
        }

//        nasted if
        if (uangJajan > 0) {
            jajan = true;
            if (uangJajan > 50000) {
                traktir = true;
            } else {
                System.out.println("gak bisa traktir");
            }
        } else {
            System.out.println("gak jajan");
        }

//        switch case
        switch (uangJajan) {
            case 0:
                jajan = false;
                traktir = false;
                break;
            case 10000:
                jajan = true;
                traktir = false;
                break;
            case 50000:
                jajan = true;
                traktir = false;
                break;
            case 100000:
                jajan = true;
                traktir = true;
                break;
            default:
                System.out.println("inputan salah");
        }

        // penerapan

//        conditional assignment
        boolean jajan1 = (uangJajan > 0) ? true : false;
        String jajan2 = (uangJajan > 0) ? "jajan" : "tidak jajan";
        int jajan3 = (uangJajan > 0) ? 1 : 0;
        double jajan4 = (uangJajan > 0) ? 1.0 : 0;

//        simplfy
        boolean jajan5 = uangJajan > 0;

        // kapan harus menggunakan conditional assignment
        boolean jajan6 = (uangJajan > 0) ? true : false;

        if (uangJajan > 0) {
            jajan6 = true;
        } else {
            jajan6 = false;
        }

        switch (uangJajan) {
            case 0:
                jajan6 = false;
                break;
            case 10000:
                jajan6 = true;
                break;
        }

        // tambahan
//        jika hanya mengubah status boolean maka bisa menggunakan seleksi kondisi secara langsung tanpa harus menggunakan
//                bentuk conditional assignment karena bisa di-simplfy
        boolean datang = false;
        boolean berangkat = datang == true;

        int jajan7 = (traktir == true) ? +5000 : 0;

//        kesimpulan
//        seleksi kondisi conditional assignment digunakan pada seleksi kondisi yang simpel (ketika kita hanya membutuhkan
//        suatu program melakukan suatu hal pada saat kondisi benar atau salah) karena tidak bisa dibuat menjadi nasted
//        dan program hanya akan menjalankan satu perintah saja

//        if else
        int traktir1 = 10000;


        if (traktir1 == 10000) {
            uangJajan += 5000;
            System.out.println("uang jajan aku ditambah lima ribu");
        } else {
            uangJajan += 10000;
            System.out.println("uang jajan aku ditambah sepuluh ribu");
        }

        switch (traktir1) {
            case 10000:
                uangJajan += 5000;
                System.out.println("uang jajan aku ditambah lima ribu");
                break;
            default:
                uangJajan += 10000;
                System.out.println("uang jajan aku ditambah sepuluh ribu");
        }

//        apa yang membedakan if else dan switch case ?

        if (traktir1 > 0 && traktir1 <= 10000) {
            uangJajan += 5000;
            System.out.println("uang jajan aku ditambah lima ribu");
        } else {
            uangJajan += 10000;
            System.out.println("uang jajan aku ditambah sepuluh ribu");
        }

//        kalo pake if else dengan lebih dari 2 kondisi gimana ?

        if (traktir1 > 0 && traktir1 <= 10000) {
            uangJajan += 5000;
            System.out.println("uang jajan aku ditambah lima ribu");
        } else if (traktir1 > 10000 && traktir1 <= 20000) {
            uangJajan += 10000;
            System.out.println("uang jajan aku ditambah sepuluh ribu");
        } else {
            uangJajan += 15000;
            System.out.println("uang jajan aku ditambah lima belas ribu");
        }

//        kapan pake else if ? kapan pake else ?

        // tidak ada kondisi default
        if (traktir1 > 0 && traktir1 <= 10000) {
            uangJajan += 5000;
            System.out.println("uang jajan aku ditambah lima ribu");
        } else if (traktir1 > 10000 && traktir1 <= 20000) {
            uangJajan += 10000;
            System.out.println("uang jajan aku ditambah sepuluh ribu");
        }

        // ada kondisi default
        if (traktir1 > 0 && traktir1 <= 10000) {
            uangJajan += 5000;
            System.out.println("uang jajan aku ditambah lima ribu");
        } else if (traktir1 > 10000 && traktir1 <= 20000) {
            uangJajan += 10000;
            System.out.println("uang jajan aku ditambah sepuluh ribu");
        } else {
            uangJajan += 15000;
            System.out.println("uang jajan aku ditambah lima belas ribu");
        }

//        switch case
        switch (traktir1) {
            case 5000: uangJajan += 2500;break;
            case 10000: uangJajan += 5000;break;
            case 20000: uangJajan += 10000;break;
            case 30000: uangJajan += 15000; break;
            default:uangJajan += 20000; break;
        }

        if (traktir1 == 5000) {
            uangJajan += 2500;
        } else if (traktir1 == 10000) {
            uangJajan += 5000;
        } else if (traktir1 == 20000) {
            uangJajan += 10000;
        } else if (traktir1 == 30000) {
            uangJajan += 15000;
        } else {
            uangJajan += 20000;
        }

        if (uangJajan == 1) {
            System.out.println();
        }

        int [] a = {1,2,3};

        for (int b: a) {
            System.out.println(b);
        }








//        kesimpulannya adalah switch case digunakan apabila nilai dalam seleksi kondisi bernilai pasti atau tetap dan
//        digunakan apabila kondisinya banyak agar lebir terstruktur dan lebih mudah dibaca

    }
}
