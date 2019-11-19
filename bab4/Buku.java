package bab4;

public class Buku {
    private String kategori, judul ;
    private Double hargaSewa, hargaDenda ;

    public Buku(String kategori, String judul, Double hargaSewa, Double hargaDenda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = hargaSewa;
        this.hargaDenda = hargaDenda;
    }


    public void cetak() {
        System.out.print(kategori + " ");
                System.out.print(judul+ " ");
                System.out.print(hargaSewa + " ");
                System.out.print(hargaDenda + " ");
                System.out.println();
    }

    public String getKategori() {
        return kategori;
    }

    public String getJudul() {
        return judul;
    }

    public Double getHargaSewa() {
        return hargaSewa;
    }

    public Double getHargaDenda() {
        return hargaDenda;
    }
}
