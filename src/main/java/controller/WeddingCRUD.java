package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.PaketWedding;
import model.Pelanggan;
import model.PemesananWedding;
import model.Vendor;
import model.VendorCatering;
import model.VendorDekorasi;
import view.Pesan;
import view.Menu;

public class WeddingCRUD {

    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<PaketWedding> daftarPaket;
    private ArrayList<PemesananWedding> daftarPemesanan;
    private ArrayList<Vendor> daftarVendor;
    private Scanner scanner;

    public WeddingCRUD(Scanner scanner) {
        this.scanner = scanner;

        daftarPelanggan = new ArrayList<>();
        daftarPelanggan.add(new Pelanggan(1, "Putri Anggita", "081333637409"));
        daftarPelanggan.add(new Pelanggan(2, "Vidya Khansa", "082211117197"));

        daftarPaket = new ArrayList<>();
        daftarPaket.add(new PaketWedding(1, "Paket Bismillah Lancar", 15000000));
        daftarPaket.add(new PaketWedding(2, "Paket Gas Nikah", 25000000));
        daftarPaket.add(new PaketWedding(3, "Paket Akhirnya Sah", 40000000));
        daftarPaket.add(new PaketWedding(4, "Paket Cinta Sampai Tua", 55000000));
        daftarPaket.add(new PaketWedding(5, "Paket Lancar Sampai Hari H", 75000000));

        daftarVendor = new ArrayList<>();
        daftarVendor.add(new VendorCatering(1, "Sundari Catering", "081283619319", "Nusantara", "Prasmanan", 75000));
        daftarVendor.add(new VendorDekorasi(2, "Glam Your Eyes", "081233691333", "Rose Garden", "Outdoor", 8700000));

        daftarPemesanan = new ArrayList<>();
        daftarPemesanan.add(new PemesananWedding(1, daftarPelanggan.get(0),
                daftarPaket.get(1), "Taman Samarendah", "01-09-2026", 200));
    }

    public void tambahPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          TAMBAH PELANGGAN          |");
        System.out.println("=====================================");

        int id = InputValidator.bacaInt(scanner, "ID Pelanggan: ");

        boolean sudahAda = false;
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan() == id) {
                sudahAda = true;
                break;
            }
        }

        if (sudahAda) {
            Pesan.tampilkanPesan("Yaahh.. ID Pelanggan sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Pelanggan: ");
        String noHp = InputValidator.bacaTeks(scanner, "No HP: ");

        daftarPelanggan.add(new Pelanggan(id, nama, noHp));
        Pesan.tampilkanPesan("YAYY!! Data pelanggan berhasil ditambahkan :D");
    }

    public void tampilkanPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          DAFTAR PELANGGAN          |");
        System.out.println("=====================================");

        if (daftarPelanggan.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
            return;
        }

        for (Pelanggan p : daftarPelanggan) {
            p.tampilkanInfo();
        }
    }

    public void updatePelanggan() {
        System.out.println("=====================================");
        System.out.println("|          UPDATE PELANGGAN          |");
        System.out.println("=====================================");
        
        if (daftarPelanggan.isEmpty()) {
        Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
        return;
        }

        tampilkanPelanggan();
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Pelanggan yang ingin diupdate: ");

        Pelanggan p = null;
        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan() == idTarget) {
                p = pelanggan;
                break;
            }
        }

        if (p == null) {
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Baru: ");
        String noHp = InputValidator.bacaTeks(scanner, "No HP Baru: ");

        p.setNama(nama);
        p.setNoHp(noHp);

        Pesan.tampilkanPesan("Data pelanggan berhasil diperbarui yah ^__^");
    }

    public void hapusPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          HAPUS PELANGGAN           |");
        System.out.println("=====================================");
        
        if (daftarPelanggan.isEmpty()) {
        Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
        return;
        }

        tampilkanPelanggan();
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Pelanggan yang ingin dihapus: ");

        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdPelanggan() == idTarget) {
                daftarPelanggan.remove(i);
                Pesan.tampilkanPesan("Data pelanggan berhasil dihapus yaa!!");
                return;
            }
        }

        Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
    }

    public void tambahPaket() {
        System.out.println("=====================================");
        System.out.println("|        TAMBAH PAKET WEDDING        |");
        System.out.println("=====================================");

        int id = InputValidator.bacaInt(scanner, "ID Paket: ");

        boolean sudahAda = false;
        for (PaketWedding pw : daftarPaket) {
            if (pw.getIdPaket() == id) {
                sudahAda = true;
                break;
            }
        }

        if (sudahAda) {
            Pesan.tampilkanPesan("Yaahh.. ID Paket sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Paket: ");

        PaketWedding paket = new PaketWedding(id, nama, 1);

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga: ");
            paket.setHarga(harga);
        } while (paket.getHarga() != harga);

        daftarPaket.add(paket);
        Pesan.tampilkanPesan("YAYY!! Paket wedding berhasil ditambahkan :D");
    }

    public void tampilkanPaket() {
        System.out.println("=====================================");
        System.out.println("|        DAFTAR PAKET WEDDING        |");
        System.out.println("=====================================");

        if (daftarPaket.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }

        for (PaketWedding pw : daftarPaket) {
            pw.tampilkanInfo();
        }
    }

    public void updatePaket() {
        System.out.println("=====================================");
        System.out.println("|      UPDATE HARGA PAKET WEDDING    |");
        System.out.println("=====================================");

        if (daftarPaket.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }

        tampilkanPaket();     
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Paket yang ingin diupdate: ");

        PaketWedding pw = null;
        for (PaketWedding paket : daftarPaket) {
            if (paket.getIdPaket() == idTarget) {
                pw = paket;
                break;
            }
        }

        if (pw == null) {
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
            return;
        }

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga Baru: ");
            pw.setHarga(harga);
        } while (pw.getHarga() != harga);

        Pesan.tampilkanPesan("Harga paket wedding berhasil diperbarui yah ^__^");
    }

    public void hapusPaket() {
        System.out.println("=====================================");
        System.out.println("|         HAPUS PAKET WEDDING        |");
        System.out.println("=====================================");

        if (daftarPaket.isEmpty()) {
        Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
        return;
        }

        tampilkanPaket();
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Paket yang ingin dihapus: ");

        for (int i = 0; i < daftarPaket.size(); i++) {
            if (daftarPaket.get(i).getIdPaket() == idTarget) {
                daftarPaket.remove(i);
                Pesan.tampilkanPesan("Paket wedding berhasil dihapus yaa!!");
                return;
            }
        }

        Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
    }

    public void tambahPemesanan() {
        System.out.println("=====================================");
        System.out.println("|      TAMBAH PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        if (daftarPelanggan.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan, tambah dulu yuk :(");
            return;
        }

        if (daftarPaket.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }

        int id = InputValidator.bacaInt(scanner, "ID Booking: ");

        boolean sudahAda = false;
        for (PemesananWedding pmw : daftarPemesanan) {
            if (pmw.getIdBooking() == id) {
                sudahAda = true;
                break;
            }
        }

        if (sudahAda) {
            Pesan.tampilkanPesan("Yaahh.. ID Booking sudah dipakai :(");
            return;
        }

        tampilkanPelanggan();
        int idPelanggan = InputValidator.bacaInt(scanner, "Pilih ID Pelanggan: ");

        Pelanggan pelanggan = null;
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan() == idPelanggan) {
                pelanggan = p;
                break;
            }
        }

        if (pelanggan == null) {
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
            return;
        }

        tampilkanPaket();
        int idPaket = InputValidator.bacaInt(scanner, "Pilih ID Paket: ");

        PaketWedding paket = null;
        for (PaketWedding pw : daftarPaket) {
            if (pw.getIdPaket() == idPaket) {
                paket = pw;
                break;
            }
        }

        if (paket == null) {
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
            return;
        }

        String venue = InputValidator.bacaTeks(scanner, "Venue: ");
        String tanggalAcara = InputValidator.bacaTeks(scanner, "Tanggal Acara: ");

        PemesananWedding pemesanan =
                new PemesananWedding(id, pelanggan, paket, venue, tanggalAcara, 1);

        int pax;
        do {
            pax = InputValidator.bacaInt(scanner, "Jumlah Pax: ");
            pemesanan.setPax(pax);
        } while (pemesanan.getPax() != pax);

        daftarPemesanan.add(pemesanan);
        Pesan.tampilkanPesan("Pemesanan wedding berhasil ditambahkan, happy wedding :D");
    }

    public void tampilkanPemesanan() {
        System.out.println("=====================================");
        System.out.println("|      DAFTAR PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        if (daftarPemesanan.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
            return;
        }

        for (PemesananWedding pmw : daftarPemesanan) {
            pmw.tampilkanInfo();
        }
    }

    public void updatePemesanan() {
        System.out.println("=====================================");
        System.out.println("|      UPDATE PEMESANAN WEDDING      |");
        System.out.println("=====================================");
        
        if (daftarPemesanan.isEmpty()) {
        Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
        return;
        }

        tampilkanPemesanan();
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Booking yang ingin diupdate: ");

        PemesananWedding pmw = null;
        for (PemesananWedding p : daftarPemesanan) {
            if (p.getIdBooking() == idTarget) {
                pmw = p;
                break;
            }
        }

        if (pmw == null) {
            Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
            return;
        }

        String venue = InputValidator.bacaTeks(scanner, "Venue Baru: ");
        String tanggalAcara =
                InputValidator.bacaTeks(scanner, "Tanggal Acara Baru: ");

        pmw.setVenue(venue);
        pmw.setTanggalAcara(tanggalAcara);

        int pax;
        do {
            pax = InputValidator.bacaInt(scanner, "Pax Baru: ");
            pmw.setPax(pax);
        } while (pmw.getPax() != pax);

        Pesan.tampilkanPesan("Pemesanan wedding berhasil diperbarui yah ^__^");
    }

    public void hapusPemesanan() {
        System.out.println("=====================================");
        System.out.println("|       HAPUS PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        if (daftarPemesanan.isEmpty()) {
        Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
        return;
        }

        tampilkanPemesanan();
        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Booking yang ingin dihapus: ");

        for (int i = 0; i < daftarPemesanan.size(); i++) {
            if (daftarPemesanan.get(i).getIdBooking() == idTarget) {
                daftarPemesanan.remove(i);
                Pesan.tampilkanPesan("Pemesanan wedding berhasil dihapus yaa!!");
                return;
            }
        }

        Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
    }

    public void tambahVendor() {
        System.out.println("=====================================");
        System.out.println("|           TAMBAH VENDOR            |");
        System.out.println("=====================================");

        Menu.tampilkanMenuJenisVendor();
        int jenis = InputValidator.bacaPilihan(scanner, "Pilih (1-2): ", 1, 2);

        int id = InputValidator.bacaInt(scanner, "ID Vendor: ");

        boolean sudahAda = false;
        for (Vendor v : daftarVendor) {
            if (v.getIdVendor() == id) {
                sudahAda = true;
                break;
            }
        }

        if (sudahAda) {
            Pesan.tampilkanPesan("Yaahh.. ID Vendor sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Vendor: ");
        String noTelepon = InputValidator.bacaTeks(scanner, "No Telepon: ");

        if (jenis == 1) {
            String jenisMasakan =
                    InputValidator.bacaTeks(scanner, "Jenis Masakan: ");
            String sistemPenyajian =
                    InputValidator.bacaTeks(scanner, "Sistem Penyajian: ");

            VendorCatering vc = new VendorCatering(
                    id, nama, noTelepon, jenisMasakan, sistemPenyajian, 1);

            int harga;
            do {
                harga = InputValidator.bacaInt(scanner, "Harga Per Pax: ");
                vc.setHargaPerPax(harga);
            } while (vc.getHargaPerPax() != harga);

            daftarVendor.add(vc);
            Pesan.tampilkanPesan("YAYY!! Vendor catering berhasil ditambahkan :D");

        } else {
            String temaDekorasi =
                    InputValidator.bacaTeks(scanner, "Tema Dekorasi: ");
            String jenisDekorasi =
                    InputValidator.bacaTeks(scanner, "Jenis Dekorasi: ");

            VendorDekorasi vd = new VendorDekorasi(
                    id, nama, noTelepon, temaDekorasi, jenisDekorasi, 1);

            int harga;
            do {
                harga =
                        InputValidator.bacaInt(scanner, "Harga Paket Dekorasi: ");
                vd.setHargaPaketDekorasi(harga);
            } while (vd.getHargaPaketDekorasi() != harga);

            daftarVendor.add(vd);
            Pesan.tampilkanPesan("YAYY!! Vendor dekorasi berhasil ditambahkan :D");
        }
    }

    public void tampilkanVendor() {
        System.out.println("=====================================");
        System.out.println("|           TAMPILKAN VENDOR         |");
        System.out.println("=====================================");

        Menu.tampilkanMenuTampilkanVendor();
        int pilihan = InputValidator.bacaPilihan(scanner, "Pilih (1-3): ", 1, 3);

        switch (pilihan) {
            case 1 -> tampilkanSemuaVendor();
            case 2 -> tampilkanJenisVendor("Catering");
            case 3 -> tampilkanJenisVendor("Dekorasi");
            default -> Pesan.tampilkanPesan("Pilihan tidak valid :(");
        }
    }

    private void tampilkanSemuaVendor() {
        if (daftarVendor.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data vendor :(");
            return;
        }

        for (Vendor v : daftarVendor) {
            v.tampilkanInfo();
        }
    }

    private void tampilkanJenisVendor(String jenis) {
        boolean adaData = false;

        for (Vendor v : daftarVendor) {
            if (v.getJenisVendor().equalsIgnoreCase(jenis)) {
                v.tampilkanInfo();
                adaData = true;
            }
        }

        if (!adaData) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data vendor " + jenis + " :(");
        }
    }

    public void updateVendor() {
        System.out.println("=====================================");
        System.out.println("|           UPDATE VENDOR            |");
        System.out.println("=====================================");

        if (daftarVendor.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data vendor :(");
            return;
        }

        tampilkanSemuaVendor();
        int idTarget = InputValidator.bacaInt(
                scanner, "Masukkan ID Vendor yang ingin diupdate: ");

        Vendor v = null;

        for (Vendor vendor : daftarVendor) {
            if (vendor.getIdVendor() == idTarget) {
                v = vendor;
                break;
            }
        }

        if (v == null) {
            Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
            return;
        }

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga Baru: ");
            v.setHarga(harga);
        } while (v.getHarga() != harga);

        Pesan.tampilkanPesan("Harga vendor berhasil diperbarui yah ^__^");
    }

    public void hapusVendor() {
        System.out.println("=====================================");
        System.out.println("|            HAPUS VENDOR            |");
        System.out.println("=====================================");

        if (daftarVendor.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data vendor :(");
            return;
        }

        tampilkanSemuaVendor();
        int idTarget = InputValidator.bacaInt(
                scanner, "Masukkan ID Vendor yang ingin dihapus: ");

        for (int i = 0; i < daftarVendor.size(); i++) {
            if (daftarVendor.get(i).getIdVendor() == idTarget) {
                daftarVendor.remove(i);
                Pesan.tampilkanPesan("Vendor berhasil dihapus yaa!!");
                return;
            }
        }

        Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
    }
}