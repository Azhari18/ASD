package soal;

import java.util.Scanner;

public class nomer1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("formal atau tidak ? ");
        boolean formal = input.nextBoolean();
        if (formal) {
            //indoor or outdoor
            System.out.print("indoor atau tidak ? ");
            boolean indoor = input.nextBoolean();
            if (indoor) {
                System.out.println("kemeja");
                System.out.println("jas");
                System.out.println("kacamata");
                System.out.println("celana bahan");
                System.out.println("sepatu hitam");
                System.out.println("kaos kaki hitam");
            } else {
                System.out.println("kemeja");
                System.out.println("tidak memakai jas");
                System.out.println("tidak memakai kacamata");
                System.out.println("celana bahan");
                System.out.println("sepatu coklat");
                System.out.println("kaos kaki coklat");
            }
        } else {
            // dingin or nondingin
            System.out.print("dingin atau tidak ?");
            boolean dingin = input.nextBoolean();
            if (dingin) {
                System.out.println("kaos");
                System.out.println("swetter");
                System.out.println("kaos tebal");
                System.out.println("celana jeans");
                System.out.println("sepatu");
                System.out.println("celana jeans panjang");
            } else {
                System.out.println("kaos");
                System.out.println("jaket");
                System.out.println("kaos tipis");
                System.out.println("jelana jeans");
                System.out.println("tidak memakai sepatu");
                System.out.println("celana jeans pendek");

            }
        }
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                System.out.println("ibrahim menggunakan motor");
                break;
            case 2:
                System.out.println("ibrahim menggunakan mobil");
                break;
            case 3:
                System.out.println("ibrahim menggunakan transportasi umum");
        }
    }
}
