package display;
import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame{
    JPanel fenpan = new JPanel();
    Font police = new Font("Tahoma", Font.ROMAN_BASELINE, 18);
    JButton jbchooseFile=new JButton("Choose File");
    JButton jbsendFile=new JButton("Send");
    JLabel filename=new JLabel(" ");

    public JPanel getfenpan() {
        return fenpan;
    }
    public JButton getjbchooseFile() {
        return jbchooseFile;
    }
    public JButton getjbsendFile() {
        return jbsendFile;
    }
    public JLabel getfilename() {
        return filename;
    }

    public ClientFrame(){
        this.setSize(500,200);
        this.setLocation(230,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getfenpan().setLayout(new BorderLayout());
        this.add(this.getfenpan());
    }

    public void clientpanel()throws Exception{
        JPanel panel=new JPanel();
        panel.setLayout(null);

        JLabel titre=new JLabel("CHOOSE A FILE TO SEND");
        titre.setFont(police);
        titre.setBounds(135,15,300,30);

        filename.setFont(police);
        filename.setBounds(140,90,300,30);

        jbchooseFile.setBounds(190,50,100,30);
        jbsendFile.setBounds(205,120,75,30);
        jbsendFile.setVisible(false);

        panel.add(titre);
        panel.add(jbchooseFile);
        panel.add(filename);
        panel.add(jbsendFile);

        this.getfenpan().add(panel,BorderLayout.CENTER);
    }
}