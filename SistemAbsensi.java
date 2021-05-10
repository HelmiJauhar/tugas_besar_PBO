import java.util.LinkedList;
import java.util.List;

public class SistemAbsensi {
    List<AbsensiPegawai> listAbsensiPegawai = new LinkedList<AbsensiPegawai>();

    public SistemAbsensi() {
        // ========== Pendefinisian Variabel =================

        // Menggunakan List<> agar ukurannya dapat berubah-ubah
        List<Pegawai> listPegawai = ReadWritePegawai.getPegawais(); 
        
        // Perulangan untuk mengisi absensiPegawai menggunakan objeck Pegawai
        for (Pegawai pegawai : listPegawai) {
            listAbsensiPegawai.add(new AbsensiPegawai(pegawai));
        }
    }
    
    public boolean Check(String nama, String pass){
        // Perulangan untuk check kecocokan nama dan password
        for (AbsensiPegawai absensiPegawai : listAbsensiPegawai) {
            if(absensiPegawai.Compare(nama, pass)){
                return true;
            }
        }
        return false;
    }
}
