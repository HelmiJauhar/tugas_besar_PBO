import java.util.LinkedList;
import java.util.List;

public class SistemAbsensi {
    private List<AbsensiPegawai> listAbsensiPegawai = new LinkedList<AbsensiPegawai>();

    public SistemAbsensi() {
        // Mengambil data dari file pegawai.txt
        List<Pegawai> listPegawai = ReadWritePegawai.ReadFile(); 
        
        // Perulangan untuk mengisi absensiPegawai menggunakan objeck Pegawai
        for (Pegawai pegawai : listPegawai) {
            listAbsensiPegawai.add(new AbsensiPegawai(pegawai));
        }
    }
    
    // --- Melakukan perulangan ke seluruh elemen absensiPegawai ---
    // --- Hingga ditemukan kecocokan --- 
    public boolean Check(String nama, String pass){
        for (AbsensiPegawai absensiPegawai : listAbsensiPegawai) {
            if(absensiPegawai.Compare(nama, pass)){
                return true;
            }
        }
        return false;
    }
}
