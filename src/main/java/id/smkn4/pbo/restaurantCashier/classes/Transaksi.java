package id.smkn4.pbo.restaurantCashier.classes;

import java.util.ArrayList;


public class Transaksi {
    private String noTransaksi;
    private String namaPemesan;
    private String tanggal;
    private String noMeja;
    private ArrayList<Pesanan> pesanan;
    private double uangBayar;
    private double pajak;
    private double biayaService;
    private double totalBayar;

    public Transaksi(String noTransaksi, String namaPemesan, String tanggal, String noMeja) {
        this.noTransaksi = noTransaksi;
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
        this.noMeja = noMeja;
        this.pesanan = new ArrayList<Pesanan>();
    }

    public void tambahPesanan(Pesanan pesanan) {
        this.pesanan.add(pesanan);
    }

    /*
    public Pesanan getPesanan() {
        return null;
    }
    */

    public ArrayList<Pesanan> getSemuaPesanan() {
        return this.pesanan;
    }

    public double hitungTotalBayar() {
        return 0;
    }

    public double hitungKembalian() {
        return 0;
    }

    public void cetakStruk() {
        System.out.println("======== ALDEBARAMEN ========");
        System.out.println("No Transaksi: " + this.noTransaksi);
        System.out.println("Pemesan: " + this.namaPemesan);
        System.out.println("Tanggal: " + this.tanggal);
        System.out.println("Meja: " + (this.noMeja.isBlank() ? this.noMeja : "Take away"));
        System.out.println("============================");
        for (Pesanan p : this.pesanan) {
            Menu m = p.getMenu();
            String pesanan = p.getJumlah() + " " + m.getNama() + "\t" + (m.getHarga() * p.getJumlah());

            if (m.getKategori().equals("Kuah"))
                pesanan = "  " + pesanan;

            System.out.println(pesanan);
        }
    }

    public void setBiayaService(double biayaService) {
        this.biayaService = biayaService;
    }

    public void setPajak(double pajak) {
        this.pajak = pajak;
    }

    public double hitungTotalPesanan() {
        for (Pesanan p : this.pesanan) {
            double harga = p.getMenu().getHarga();
            this.totalBayar += (harga * p.getJumlah());
        }
        return this.totalBayar;
    }

    public double hitungPajak() {
        return this.totalBayar * this.pajak;
    }

    public double hitungBiayaService() {
        return this.totalBayar * this.biayaService;
    }

    public double hitungTotalBayar(double pajak, double biayaService) {
        this.totalBayar = this.totalBayar + pajak + biayaService;
        return this.totalBayar;
    }

    public double hitungKembalian(double uangBayar) {
        return uangBayar - this.totalBayar;
    }
}
