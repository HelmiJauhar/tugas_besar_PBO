import java.time.LocalTime;

public class AbsensiPegawai extends Pegawai{
    private String waktu;
    private String status = "absent";
    
    public AbsensiPegawai(Pegawai pegawai){
        SetId(pegawai.id);
        SetNama(pegawai.nama);
        SetPassword(pegawai.password);
    }

    //Submit Absensi
    private void Submit(LocalTime waktu){
        this.waktu = waktu.toString();//Mengknversi localTime menjadi string
        status = waktu.isBefore(LocalTime.parse("08:00:00"))? "masuk" : "terlambat"; //Untuk mengetahui keterlambatan absensi yang dilakukan
    }

    public void Compare(String n, String p){
        if(nama.equals(n) && password.equals(p)){
            Submit(LocalTime.now());
        }
    }
    
    //Untuk store data absensi ke dalam file riwayat.txt
    public void Store(){
        ReadWritePegawai.StoreAbsensi(id, nama, waktu, status);
    }
}