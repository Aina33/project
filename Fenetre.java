package show;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    JPanel fenpan = new JPanel();
    Font police = new Font("Tahoma", Font.ROMAN_BASELINE, 18);
    JButton jbchooseFile=new JButton("Choose File");
    JButton jbsendFile=new JButton("Send");
    JLabel filename=new JLabel("chosen file: ");

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

    public Fenetre(){
        this.setSize(400,400);
        this.setLocation(430,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getfenpan().setLayout(new BorderLayout());
        this.add(this.getfenpan());
    }

    public void clientpanel()throws Exception{
        JPanel panel=new JPanel();
        panel.setLayout(null);

        JLabel titre=new JLabel("CHOOSE A FILE TO SEND");
        titre.setFont(police);
        titre.setBounds(80,60,300,30);

        filename.setFont(police);
        filename.setBounds(80,150,300,30);

        jbchooseFile.setBounds(80,120,100,30);
        jbsendFile.setBounds(80,200,80,30);

        panel.add(titre);
        panel.add(jbchooseFile);
        panel.add(filename);
        panel.add(jbsendFile);

        this.getfenpan().add(panel,BorderLayout.CENTER);
    }
}