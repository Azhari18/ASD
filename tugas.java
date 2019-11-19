import java.util.Scanner;

public class tugas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan banyak baris/lebar kolom = ");
        int n = input.nextInt();
        for (int i = 0; i < n / 2; i++) {
            if (i == 0) {
                //1. i = 0 untuk mencetak "*******"
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
            } else {
                //2. i = 1 untuk mencetak "**". baris kedua, dua bintang pertama
                //3. i = 2 untuk mencetak "* *". baris ketiga, dua bintang pertama dengan jarak satu spasi
                System.out.print("*");
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                //2. i = 1 untuk mencetak "   ". baris kedua, jumlah spasi setelah dua bintang pertama
                //3. i = 2 untuk mencetak " ". baris ketiga, jumlah spasi setelah dua bintang pertama
                for (int j = 0; j < n - (2 * (i + 1)); j++) {
                    System.out.print(" ");
                }
                //2. i = 1 untuk mencetak "**". baris kedua, dua bintang terakhir
                //3. i = 2 untuk mencetak "* *". baris ketiga, dua bintang terakhir
                System.out.print("*");
                for (int j = 0; j < i - 1; j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }

        if (n % 2 == 1) {
            // 4. mencetak "*". bintang pertama pada baris ke 4
            System.out.print("*");
            //4. mencetak "  ". banyaknya spasi setelah bintang pertama pada baris ke 4
            for (int j = 0; j < (n - 3) / 2; j++) {
                System.out.print(" ");
            }
            //4. mencetak "*". bintang di tengah pada baris ke 4
            System.out.print("*");
            //4. mencetak "  ". banyaknya spasi setelah bintang kedua (bintang yang di tengah) pada baris ke 4
            for (int j = 0; j < (n - 3) / 2; j++){
                System.out.print(" ");
            }
            // 4. mencetak "*" bintang terakhir pada baris 4
            System.out.print("*");
            System.out.println();
        }

        for (int i = n / 2 - 1; i >= 0; i--) {
            if (i == 0){
                //7.1 mencetak "*******" pada baris ke 7
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
            }
            else {
                //5. i = 2 mencetak "*". bintang pertama pada baris 5
                //6. i = 1 mencetak "*". bintang pertama pada baris 6
                System.out.print("*");
                // 5. i = 2 mencetak "  ". jumlah spasi setelah bintang pertama pada baris 5
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(" ");
                }
                // 5. i = 2 mencetak "*". bintang kedua pada bari 5
                // 6. i = 1 mencetak "*". bintang kedua pada bari 6
                System.out.print("*");
                // 5. i = 2 mencetak " ". jumlah spasi setelah bintang kedua pada bari 5
                // 6. i = 1 mencetak "   ". jumlah spasi setelah bintang kedua pada bari 6
                for (int j = 0; j < n - (2 * (i + 1)); j++) {
                    System.out.print(" ");
                }
                // 5. i = 2 mencetak "*". bintang ketiga pada baris 5
                // 6. i = 1 mencetak "*". bintang ketiga pada baris 6
                System.out.print("*");
                // 5. i = 2 mencetak " ". jumlah spasi setelah bintang ketiga
                for (int j = 0; j < i - 1; j++){
                    System.out.print(" ");
                }
                // 5. i = 2 mencetak "*". bintang keempat pada bari 5
                // 6. i = 1 mencetak "*". bintang keempat pada bari 6
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


//data camp
//        Scanner input = new Scanner(System.in);
//        int jamMasuk, menitMasuk, jamSelesai, menitSelesai, selisihJam, selisihMenit, selisihWaktu ;
//        System.out.print("masukan jam masuk ? ");
//        jamMasuk = input.nextInt();
//        System.out.print("masukan menit masuk ? ");
//        menitMasuk = input.nextInt();
//        System.out.print("masukan jam keluar ? ");
//        jamSelesai = input.nextInt();
//        System.out.print("masukan menit keluar ? ");
//        menitSelesai = input.nextInt();
//        selisihJam = jamSelesai - jamMasuk ;
//        System.out.println("selisih jam : " + selisihJam);
//        selisihMenit = menitSelesai - menitMasuk ;
//        System.out.println("selisih menit : " + selisihMenit);
//        selisihWaktu = (selisihJam*60) + selisihMenit;
//        System.out.println("selisih waktu : " +selisihWaktu);
//        selisihJam = selisihWaktu/60;
//        System.out.println("selisih jam : " + selisihJam);
//        selisihMenit = selisihWaktu%60;
//        System.out.println("selisih menit : " + selisihMenit);
//        System.out.println();
//        System.out.println("selisih waktu adalah : " + selisihJam + ":" + selisihMenit);
// 09.30 - 10.10

