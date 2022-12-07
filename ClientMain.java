package main;
import transfer.Functions;
import listen.Ecouteur;
import show.Fenetre;
public class ClientMain {
    public static void main(String[] args)throws Exception {
        Functions functions=new Functions();
        Fenetre fenetre=new Fenetre();
        fenetre.clientpanel();

        Ecouteur ecouteur=new Ecouteur(fenetre,functions);
        ecouteur.getfenli().getjbsendFile().addMouseListener(ecouteur);
        ecouteur.getfenli().getjbchooseFile().addMouseListener(ecouteur);
        fenetre.setVisible(true);
    }
}