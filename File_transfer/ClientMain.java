package client;
import transfer.Functions;
import listener.ClientListener;
import display.ClientFrame;
public class ClientMain {
    public static void main(String[] args)throws Exception {
        ClientFrame clientFrame=new ClientFrame();
        clientFrame.clientpanel();

        Functions functions=new Functions();
        ClientListener clientListener=new ClientListener(functions);
        clientListener.setclientFrame(clientFrame);
        clientListener.getclientFrame().getjbsendFile().addMouseListener(clientListener);
        clientListener.getclientFrame().getjbchooseFile().addMouseListener(clientListener);

        clientFrame.setVisible(true);
    }
}