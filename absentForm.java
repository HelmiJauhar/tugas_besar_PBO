import java.awt.event.*;
import java.util.List;
import java.awt.BorderLayout;

import javax.swing.*;

public class absentForm implements ActionListener {
    private JLabel judul;
    private JLabel userName;
    private JLabel passWord;
    private JTextField hasilUser;
    private JTextField hasilPass;
    private JButton btnSubmit;
    private JButton btnList;
    private JList listKehadiran;
    private JTextArea tArea;
    private static SistemAbsensi sistem;
    
    public absentForm(){
        JFrame frame = new JFrame();
        frame.setBounds(200, 200, 400, 250);
        frame.setTitle("Sistem Absensi Mahasiswa");
        
        judul = new JLabel("Absensi Mahasiswa");
        judul.setBounds(25, 15, 150, 25);
        frame.add(judul);
        
        userName = new JLabel("Inputkan Username");
        userName.setBounds(25, 45, 150, 25);
        frame.add(userName);
        
        passWord = new JLabel("Inputkan Password");
        passWord.setBounds(25, 70, 150, 25);
        frame.add(passWord);
        
        hasilUser = new JTextField();
        hasilUser.setBounds(150, 45, 150, 25);
        frame.add(hasilUser);
        
        hasilPass = new JTextField();
        hasilPass.setBounds(150, 70, 150, 25);
        frame.add(hasilPass);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(25, 115, 100, 25);
        frame.add(btnSubmit);
        
        btnList = new JButton("List Absent");
        btnList.setBounds(200, 115, 100, 25);
        frame.add(btnList);
        
        tArea = new JTextArea(4, 15);
        tArea.setEditable(false);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSubmit.addActionListener(this);
        btnList.addActionListener(this);
    }
    
    public void fillList(){
        List<String> list = ReadWritePegawai.ReadRiwayat();
        DefaultListModel listModel = new DefaultListModel<String>();
        for (String i : list) {
            listModel.addElement(i);
        }
        listKehadiran =  new JList(listModel);
    }
    
    public void showList(){
        JFrame newframe = new JFrame("Telah Melakukan Absensi");
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel(new BorderLayout());
        
        scrollPane.setViewportView(listKehadiran);
        listKehadiran.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);
        newframe.add(panel);
        newframe.setBounds(300, 300,500, 250);
        newframe.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSubmit){
            String nama = hasilUser.getText();
            String pass = hasilPass.getText();
            fillList();

            for(int i=0; i<listKehadiran.getModel().getSize(); ++i){
                if(nama.equals(listKehadiran.getModel().getElementAt(i))){
                    JOptionPane.showMessageDialog(null, "Anda sudah pernah absen", "INFORMASI",
                    JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            if(sistem.Check(nama, pass)){
                JOptionPane.showMessageDialog(null, "Mahasiswa "+nama+" berhasil absen", "INFORMASI",
                JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Username dan/atau Password Salah !!!", "INFORMASI",
                JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource()==btnList){
            fillList();
            showList();
        }
    }

    public static void main(String[] args) {
        sistem = new SistemAbsensi();
        absentForm frame = new absentForm();
    }
}