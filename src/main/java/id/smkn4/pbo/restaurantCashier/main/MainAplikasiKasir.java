package id.smkn4.pbo.restaurantCashier.main;

import id.smkn4.pbo.restaurantCashier.classes.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainAplikasiKasir {
    public DaftarMenu daftarMenu;

    public static double PAJAK_PPN = 10d / 100d;
    public static double BIAYA_PELAYANAN = 5d / 100d;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String noTransaksi, namaPemesan, tanggal, noMeja, transaksiLagi, pesanLagi, keterangan, makanDiTempat;
        MainAplikasiKasir app = new MainAplikasiKasir();

        noMeja = null;
        keterangan = null;

        app.generateDaftarMenu();

        System.out.println("======== TRANSAKSI ========");
        System.out.println("No transaksi: ");
        noTransaksi = in.next();
        System.out.println("Pemesan: ");
        namaPemesan = in.next();
        System.out.println("Tanggal: [dd-mm-yyyy] ");
        tanggal = in.next();
        System.out.println("Makan ditempat? [y/N] ");
        makanDiTempat = in.next();

        if (makanDiTempat.equalsIgnoreCase("Y")) {
            System.out.println("Nomor Meja : ");
            noMeja = in.next();
        }

        Transaksi transaksi = new Transaksi(noTransaksi, namaPemesan, tanggal, noMeja);
        int jumlahPesanan, jumlahRamen, jumlahKuah, noKuah;
        String level;

        System.out.println("======== PESANAN ========");

        do {
            Menu menuYangDipilih = app.daftarMenu.pilihMenu();
            jumlahPesanan = (int) app.cekInputNumber("Jumlah: ");

            Pesanan pesanan = new Pesanan(menuYangDipilih, jumlahPesanan);
            transaksi.tambahPesanan(pesanan);

            if (menuYangDipilih.getKategori().equalsIgnoreCase("Ramen")) {
                jumlahRamen = jumlahPesanan;

                do {
                    Menu kuahYangDipilih = app.daftarMenu.pilihKuah();

                    System.out.println("Level: [0-5] ");
                    level = in.next();

                    do {
                        jumlahKuah = (int) app.cekInputNumber("Jumlah: ");

                        if (jumlahKuah <= jumlahRamen)
                            break;

                        System.out.println("[Err] Jumlah kuah melebihi jumlah ramen yang dipesan");
                    } while (true);

                    Pesanan pesananKuah = new Pesanan(kuahYangDipilih, jumlahKuah);
                    pesananKuah.setKeterangan("Level " + level);
                    transaksi.tambahPesanan(pesananKuah);
                    jumlahRamen -= jumlahKuah;

                } while (jumlahRamen > 0);

            } else {
                System.out.println("Keterangan: [- jika kosong] ");
                keterangan = in.next();
            }

            if (keterangan != null && !keterangan.equalsIgnoreCase("-"))
                pesanan.setKeterangan(keterangan);

            System.out.println("Tambah pesanan lagi? [y/N] ");
            pesanLagi = in.next();

        } while (pesanLagi.equalsIgnoreCase("Y"));
    }

    public void generateDaftarMenu() {
        daftarMenu = new DaftarMenu();

        daftarMenu.tambahMenu(new Ramen("Ramen Seafood", 25000));
        daftarMenu.tambahMenu(new Ramen("Ramen Original", 18000));
        daftarMenu.tambahMenu(new Ramen("Ramen Vegetarian", 22000));
        daftarMenu.tambahMenu(new Ramen("Ramen Karnivor", 28000));

        daftarMenu.tambahMenu(new Kuah("Kuah Orsinil"));
        daftarMenu.tambahMenu(new Kuah("Kuah Internasional"));
        daftarMenu.tambahMenu(new Kuah("Kuah Spicy Lada"));
        daftarMenu.tambahMenu(new Kuah("Kuah Soto Padang"));

        daftarMenu.tambahMenu(new Topping("Crab Stick Bakar", 6000));
        daftarMenu.tambahMenu(new Topping("chicken Katsu", 8000));
        daftarMenu.tambahMenu(new Topping("Gyoza Goreng", 4000));
        daftarMenu.tambahMenu(new Topping("Bakso Goreng", 7000));
        daftarMenu.tambahMenu(new Topping("Enoki Goreng", 5000));

        daftarMenu.tambahMenu(new Minuman("Jus Alpukat SPC", 10000));
        daftarMenu.tambahMenu(new Minuman("Jus Stoberi", 11000));
        daftarMenu.tambahMenu(new Minuman("Capuccino Coffee", 15000));
        daftarMenu.tambahMenu(new Minuman("Vietnam Dripp", 14000));

        daftarMenu.tampilkanDaftarMenu();
    }

    public double cekInputNumber(String label) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println(label);
            return in.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Harap masukkan angka");
            return cekInputNumber(label);
        }
    }
}
