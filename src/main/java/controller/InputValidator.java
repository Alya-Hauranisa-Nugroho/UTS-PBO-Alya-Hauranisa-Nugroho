package controller;

import java.util.Scanner;
import view.Pesan;

public class InputValidator {

    public static int bacaInt(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                Pesan.tampilkanPesan("Input harus angka yaa!!!");
            }
        }
    }
    
        public static int bacaPilihan(Scanner scanner, String label, int min, int max) {
        while (true) {
            int pilihan = bacaInt(scanner, label);

            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }

            Pesan.tampilkanPesan("Pilihannya cuma dari " + min + " sampai " + max + " yaa ^__^");
        }
    }

    public static String bacaTeks(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                Pesan.tampilkanPesan("Jangan dikosongin dong..");
            } else {
                return input;
            }
        }
    }
}