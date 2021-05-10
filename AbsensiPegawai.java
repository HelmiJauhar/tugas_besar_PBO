import java.time.LocalTime;
import java.time.LocalDate;

public class AbsensiPegawai extends Pegawai{
    private String waktu;
    private String tanggal;
    private String status = "absent";
    
    public AbsensiPegawai(Pegawai pegawai){
        SetId(pegawai.id);
        SetNama(pegawai.nama);
        SetPassword(pegawai.password);
    }

    public boolean Compare(String n, String p){
        if(nama.equals(n) && password.equals(p)){
            Submit(LocalTime.now());
            return true;
        }
        return false;
    }
    
    //Submit Absensi
    private void Submit(LocalTime waktu){
        this.waktu = waktu.toString();//Mengknversi localTime menjadi string
        this.tanggal = LocalDate.now().toString();

        status = waktu.isBefore(LocalTime.parse("08:00:00"))? "masuk" : "terlambat"; //Untuk mengetahui keterlambatan absensi yang dilakukan
        ReadWritePegawai.StoreAbsensi(id, nama, this.tanggal, this.waktu, status);
    }

}