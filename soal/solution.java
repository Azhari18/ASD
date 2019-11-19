package soal;

import java.io.*;
import java.util.*;

public class solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int umur = scan.nextInt();
        double ipk = scan.nextDouble();
        int pengalaman = scan.nextInt();
        boolean status = scan.nextBoolean();
        int toefel = scan.nextInt();
        boolean sertif = scan.nextBoolean();
        boolean juara = scan.nextBoolean();
        boolean lulus = false;

        if ((umur < 20 || umur >30) && pengalaman < 5 && umur > 35) System.out.print("tidak "); System.out.println("lolos syarat pertama");
        if (ipk < 3.5 && sertif == false) System.out.print("tidak "); System.out.println("lolos syarat kedua");
        if (pengalaman < 1 && juara == false) System.out.print("tidak "); System.out.println("lolos syarat ketiga");
        if (status == true) System.out.print("tidak "); System.out.println("lolos syarat keempat");
        if (toefel < 500 ) System.out.print("tidak "); System.out.println("lolos syarat kelima");

        if (umur > 30 && umur <=35 && pengalaman >= 5) lulus = true;
        else if (ipk < 3.5 && sertif == true ) lulus = true;
        else if (pengalaman < 1 && juara == true) lulus = true;
        else if (umur >= 20 && umur <= 30 && ipk >=3.5 && pengalaman >=1 && status == false && toefel >= 500) lulus = true;

        if(lulus == true ) System.out.println("selamat anda lolos seleksi pendaftaran"); else
            System.out.println("maaf anda tidak lolos seleksi pendaftaran");
    } }
