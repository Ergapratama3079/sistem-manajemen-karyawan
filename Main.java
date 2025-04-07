import java.util.Scanner;

class Karyawan {
    private String nama;
    private String id;
    private double gajiPokok;

    public Karyawan(String nama, String id, double gajiPokok) {
        this.nama = nama;
        this.id = id;
        this.gajiPokok = gajiPokok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public double hitungGaji() {
        return gajiPokok;
    }
}

class KaryawanTetap extends Karyawan {
    public KaryawanTetap(String nama, String id, double gajiPokok) {
        super(nama, id, gajiPokok);
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() + 500000;
    }
}

class KaryawanKontrak extends Karyawan {
    public KaryawanKontrak(String nama, String id, double gajiPokok) {
        super(nama, id, gajiPokok);
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() - 200000;
    }
}

class KaryawanMagang extends Karyawan {
    public KaryawanMagang(String nama, String id, double gajiPokok) {
        super(nama, id, gajiPokok);
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan jenis karyawan (Tetap/Kontrak/Magang): ");
        String jenis = input.nextLine();

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan ID: ");
        String id = input.nextLine();

        System.out.print("Masukkan gaji pokok: ");
        double gajiPokok = input.nextDouble();

        Karyawan karyawan;

        switch (jenis.toLowerCase()) {
            case "tetap":
                karyawan = new KaryawanTetap(nama, id, gajiPokok);
                break;
            case "kontrak":
                karyawan = new KaryawanKontrak(nama, id, gajiPokok);
                break;
            case "magang":
                karyawan = new KaryawanMagang(nama, id, gajiPokok);
                break;
            default:
                System.out.println("Jenis karyawan tidak valid.");
                return;
        }

        System.out.println("\n--- Informasi Gaji ---");
        System.out.println("Nama: " + karyawan.getNama());
        System.out.println("ID: " + karyawan.getId());
        System.out.println("Gaji Akhir: Rp " + karyawan.hitungGaji());
    }
}
