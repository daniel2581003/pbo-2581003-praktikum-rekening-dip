public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);
        Deposito dewi = new Deposito("301", "Dewi", 5000000, 4.0);

        Rekening[] semua = { ani, citra, budi, dewi };
        BerBunga[] berbunga = { ani, citra, dewi };
        BisaDitarik[] bisaDitarik = { ani, citra, budi };

        // Uji ketentuan 6 (sudah dihapus): BisaDitarik[] salah = { ani, dewi };
        // Pesan error: incompatible types: Deposito cannot be converted to BisaDitarik

        // Uji ketentuan 7: mengganti new EmailNotifikasi() menjadi new SmsNotifikasi()
        // hanya mengubah 1 baris (baris ini). ProsesAkhirBulan tidak diubah sama sekali.

        // Composition root: satu-satunya tempat yang tahu class konkret Notifikasi
        Notifikasi notifikasi = new EmailNotifikasi();

        ProsesAkhirBulan proses = new ProsesAkhirBulan(notifikasi);
        LaporanBank laporan = new LaporanBank();

        laporan.cetakDaftar("========== REKENING AWAL ==========", semua);
        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(bisaDitarik, 50000);
        System.out.println();
        laporan.cetakDaftar("========== REKENING AKHIR =========", semua);
        laporan.cetakTotal(semua);
    }
}