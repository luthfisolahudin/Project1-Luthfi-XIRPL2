package id.smkn4.pbo.restaurantCashier.main;

import id.smkn4.pbo.restaurantCashier.classes.*;

import java.util.Scanner;


public class MainAplikasiKasir {
    public DaftarMenu daftarMenu;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainAplikasiKasir app = new MainAplikasiKasir();

        app.generateDaftarMenu();
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
}
