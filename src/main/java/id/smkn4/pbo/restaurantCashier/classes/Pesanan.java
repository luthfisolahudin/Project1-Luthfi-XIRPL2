package id.smkn4.pbo.restaurantCashier.classes;

public class Pesanan {
    private Menu menu;
    private int jumlah;
    private String keterangan;

    public Pesanan(Menu menu, int jumlah) {}

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
