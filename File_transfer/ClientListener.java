package listener;

import transfer.Functions;
import display.ClientFrame;

import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;

public class ClientListener implements MouseListener{
    ClientFrame clientFrame;
    Functions funcli;

    public ClientFrame getclientFrame() {
        return clientFrame;
    }
    public Functions getfuncli() {
        return funcli;
    }

    public void setclientFrame(ClientFrame clientFrame) {
        this.clientFrame = clientFrame;
    }
    public void setfuncli(Functions funcli) {
        this.funcli = funcli;
    }

    public ClientListener(Functions funcli){
        this.setfuncli(funcli);
    }

    public void mouseClicked(MouseEvent event) {
        try{
            if(event.getSource()==(JButton)this.getclientFrame().getjbchooseFile()){
                JFileChooser fileChooser=new JFileChooser();
                if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    this.getfuncli().setfiletoSend(fileChooser.getSelectedFile());
                    this.getclientFrame().getfilename().setText(""+this.getfuncli().getfiletoSend().getName());
                    this.getclientFrame().getjbsendFile().setVisible(true);
                }
            }
            if(event.getSource()==(JButton)this.getclientFrame().getjbsendFile()){
                this.getfuncli().myClient(7000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }
}