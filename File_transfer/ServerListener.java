package listener;

import transfer.Functions;
import display.ServerFrame;

import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ServerListener implements MouseListener{
    ServerFrame serverFrame;
    Functions funcli;
    File[] fileparts;

    public File[] getfileparts(){ return this.fileparts; }
    public ServerFrame getserverFrame() { return serverFrame; }
    public Functions getfuncli() { return funcli; }

    public void setserverFrame(ServerFrame serverFrame) { this.serverFrame = serverFrame; }
    public void setfuncli(Functions funcli) { this.funcli = funcli; }
    public void setfileparts(File[] fileparts){ this.fileparts=fileparts; }

    public ServerListener(Functions funcli){
        this.setfuncli(funcli);
    }
    
    public void mouseClicked(MouseEvent event) {
        try{
            if(event.getSource()==(JButton)this.getserverFrame().getjbdownload()){
                this.getfuncli().downloadJoinFile(this.getfileparts());
                System.out.println("downn");
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