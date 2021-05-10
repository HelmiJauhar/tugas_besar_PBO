import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class ReadWritePegawai {
    //Penggunaan List ditujukan agar dapat mengatasi perubahan size
    //Di sini kami menerapkan Static Polymorphism yaitu Overloading method
    public static List<Pegawai> ReadFile(){
        List<Pegawai> result = new LinkedList<Pegawai>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("stored/data_pegawai.txt"));
            while(reader.readLine() != null){
                try{
                    Pegawai temp = new Pegawai();
                    temp.SetId(reader.readLine());
                    temp.SetNama(reader.readLine());
                    temp.SetPassword(reader.readLine());

                    result.add(temp);
                }catch(Exception e){
                    reader.close();
                    e.printStackTrace();
                    break;
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static List<String> ReadFile(LocalDate today){
        List<String> result = new LinkedList<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("stored/riwayat.txt"));
            String text;
            while((text = reader.readLine()) != null){
                if(text.equals("Nama") ){
                    String nama = reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    if(LocalDate.parse(reader.readLine()).equals(today)){
                        result.add(nama);
                    }
                }else if(text.equals("")){
                    break;
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // PROSES PENULISAN RIWAYAT
    public static void WriteFile(String id, String nama,String tanggal, String waktu, String status){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("stored/riwayat.txt", true));
            out.write("#"); //Ini digunakan sebagai pembatas, agar file lebih mudah dibaca
            
            out.newLine();
            out.write("ID \t: "+id);            
            out.newLine();
            out.write("Nama \t: "+nama);                       
            out.newLine();
            out.write("Tanggal : "+tanggal);			
            out.newLine();
            out.write("Waktu \t: "+waktu);			
            out.newLine();
            out.write("Status \t: "+status);

            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
