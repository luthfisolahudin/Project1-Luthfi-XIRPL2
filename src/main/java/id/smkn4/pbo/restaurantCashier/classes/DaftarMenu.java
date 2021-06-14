package id.smkn4.pbo.restaurantCashier.classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;

    public DaftarMenu() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahMenu(Menu menu) {
        daftarMenu.add(menu);
    }

    public void getMenuByKategori(String kategori) {
        System.out.println("======== " + kategori + " ========");

        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu m = daftarMenu.get(i);

            if (m.getKategori().equals(kategori))
                System.out.println(i + 1 + ". " + m.getNama() + "\t" + m.getHarga());
        }
    }

    public void tampilkanDaftarMenu() {
        System.out.println("======== ALDEBARAMEN ========");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Topping");
        getMenuByKategori("Minuman");
    }

    public Menu pilihMenu() {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Nomor menu yang dipesan: ");
            int noMenu = in.nextInt();

            Menu menu = daftarMenu.get(noMenu - 1);

            if (menu.getKategori().equalsIgnoreCase("Kuah")) {
                System.out.println("[Err] Pesan dulu menu ramen");
                return pilihMenu();
            }

            return menu;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[Err] Pesanan tidak tersedia");
            return pilihMenu();
        } catch (InputMismatchException e) {
            System.out.println("[Err] Mohon masukkan nomor menu");
            return pilihMenu();
        }
    }

    public Menu pilihKuah() {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Kuah: [sesuai nomor menu] ");
            int noMenu = in.nextInt();

            Menu menu = daftarMenu.get(noMenu - 1);

            if (!menu.getKategori().equalsIgnoreCase("Kuah")) {
                System.out.println("[Err] Bukan menu kuah");
                return pilihKuah();
            }

            return menu;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[Err] Pesanan tidak tersedia");
            return pilihKuah();
        } catch (InputMismatchException e) {
            System.out.println("[Err] Mohon masukkan nomor kuah");
            return pilihKuah();
        }
    }
}
