package listen;

import transfer.Functions;
import show.Fenetre;

import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Ecouteur implements MouseListener{
    Fenetre fenli;
    Functions funcli;

    public Fenetre getfenli() {
        return fenli;
    }

    public Functions getfuncli() {
        return funcli;
    }

    public void setfenli(Fenetre fenli) {
        this.fenli = fenli;
    }

    public void setfuncli(Functions funcli) {
        this.funcli = funcli;
    }

    public Ecouteur(Fenetre fenli, Functions funcli){
        this.setfenli(fenli);
        this.setfuncli(funcli);
    }

    public void mouseClicked(MouseEvent event) {
        try{
            if(event.getSource()==(JButton)this.getfenli().getjbchooseFile()){
                JFileChooser fileChooser=new JFileChooser();
                if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    this.getfuncli().setfiletoSend(fileChooser.getSelectedFile());
                    this.getfenli().getfilename().setText("chosen file: "+this.getfuncli().getfiletoSend().getName());
                }
                System.out.println(this.getfuncli().getfiletoSend().getName());
                System.out.println("ok");
            }
            if(event.getSource()==(JButton)this.getfenli().getjbsendFile()){
                this.getfuncli().myClient();
                System.out.println("hum");
            }
        }
        catch (Exception e){
            // System.out.println(e.getMessage());
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