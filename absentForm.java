import java.awt.event.*;
import javax.swing.*;

public class absentForm implements ActionListener {
    private JLabel judul;
    private JLabel userName;
    private JLabel passWord;
    private JTextField hasilUser;
    private JTextField hasilPass;
    private JButton btnSubmit;
    private JButton btnList;

    public absentForm(){
        JFrame frame = new JFrame();
        frame.setBounds(200, 200, 800, 250);
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

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSubmit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSubmit){
            String kata = hasilUser.getText();
            JOptionPane.showMessageDialog(null, "Mahasiswa "+kata+" telah absen", "INFORMASI",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        absentForm frame = new absentForm();
    }

}