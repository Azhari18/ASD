package bab1.Tugas_1;

public class Buku {
    private String namaBuku;
    private String JenisBuku;
    private int biayaSewa;
    private int denda;

    public Buku(String namaBuku, String jenisBuku, int biayaSewa, int denda) {
        this.namaBuku = namaBuku;
        JenisBuku = jenisBuku;
        this.biayaSewa = biayaSewa;
        this.denda = denda;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public String getJenisBuku() {
        return JenisBuku;
    }

    public int getBiayaSewa(int lamaSewa) {
        return biayaSewa * lamaSewa;
    }

    public int getDenda(int lamaTerlambat) {
        return denda * lamaTerlambat;
    }
}
