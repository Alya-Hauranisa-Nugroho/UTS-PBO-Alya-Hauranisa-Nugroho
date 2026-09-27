package model;

public class Vendor {
    private final int idVendor;
    private final String namaVendor;
    private final String noTelepon;

    public Vendor(int idVendor, String namaVendor, String noTelepon) {
        this.idVendor = idVendor;
        this.namaVendor = namaVendor;
        this.noTelepon = noTelepon;
    }

    public int getIdVendor() {
        return idVendor;
    }

    public String getNamaVendor() {
        return namaVendor;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getJenisVendor() {
        return "Vendor";
    }

    public int getHarga() {
        return 0;
    }

    public void setHarga(int harga) {
    }

    public void tampilkanInfo() {
        System.out.println("=====================================");
        System.out.println("ID Vendor   : " + idVendor);
        System.out.println("Nama Vendor : " + namaVendor);
        System.out.println("No Telepon  : " + noTelepon);
    }
}