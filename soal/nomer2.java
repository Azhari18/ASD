package soal;

import java.util.Scanner;

public class nomer2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("umur : ");
        int umur = input.nextInt();
        System.out.print("ipk : ");
        double ipk = input.nextDouble();
        System.out.print("pengalaman kerja : ");
        int pengalamanKerja = input.nextInt();
        System.out.print("status : ");
        boolean status = input.nextBoolean();
        System.out.print("toefel : ");
        int toefel = input.nextInt();
        System.out.print("sertifikat : ");
        boolean sertifikat = input.nextBoolean();
        System.out.print("juara : ");
        boolean juara = input.nextBoolean();
        boolean a =  false,b = false,c = false,d = false;



        if (umur > 20 && umur < 30){
            System.out.println("lolos syarat pertama");
            a = true ;
        } else {
            if (pengalamanKerja >= 5 && umur <= 35){
                System.out.println("lolos syarat pertama");
                a = true ;
            } else {
                System.out.println("tidak lolos syarat pertama");
            }
        }

        if (ipk >= 3.5){
            System.out.println("lolos syarat kedua");
            b = true ;
        } else {
            if(sertifikat){
                System.out.println("lolos syarat kedua");
                b = true;
            } else {
                System.out.println("tidak lolos syarat kedua");
            }
        }

        if (pengalamanKerja >= 1){
            System.out.println("lolos syarat ketiga");
            c = true;
        } else {
            if (juara){
                System.out.println("lolos syarat ketiga");
                c = true;
            } else {
                System.out.println("tidak lolos syarat ketiga");
            }
        }
        System.out.println((status)?"tidak lolos syarat keempat":"lolos syarat keempat");
        d = toefel >= 500;
        System.out.println((d)?"lolos syarat kelima":"tidak lolos syarat kelima");
        if (a && b && c && d && !status){
            System.out.println("selamat anda lolos seleksi pendaftaran");
        } else {
            System.out.println("maaf anda tidak lolos seleksi pendaftaran");
        }
    }
}
