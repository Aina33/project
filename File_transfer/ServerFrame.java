package display;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ServerFrame extends JFrame{
    JPanel fenpan = new JPanel();
    Font police = new Font("Tahoma", Font.ROMAN_BASELINE, 18);
    JLabel fileToDownload;
    JButton jbdownload=new JButton("Download");
    
    public JPanel getfenpan() {
        return fenpan;
    }
    public JLabel getfileToDownload() { return fileToDownload; }
    public void setfileToDownload(JLabel fileToDownload) {
        this.fileToDownload = fileToDownload;
    }
    public JButton getjbdownload() {
        return jbdownload;
    }

    public ServerFrame(){
        this.setSize(400,200);
        this.setLocation(730,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getfenpan().setLayout(new BorderLayout());
        this.add(this.getfenpan());
    }

    public void serverpanel(String title)throws Exception{
        JPanel panel=new JPanel();
        panel.setLayout(null);

        JLabel titre=new JLabel(title);
        titre.setFont(police);

        titre.setBounds(100,10,300,30);

        this.fileToDownload=new JLabel(". . .");
        this.fileToDownload.setFont(police);
        this.fileToDownload.setBounds(70,50,400,25);

        jbdownload.setBounds(150,90,90,25);
        jbdownload.setVisible(false);

        panel.add(fileToDownload);
        panel.add(titre);
        panel.add(jbdownload);

        this.getfenpan().add(panel,BorderLayout.CENTER);
    }
}