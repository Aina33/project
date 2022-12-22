package server;
import transfer.Functions;
import listener.ServerListener;
import display.ServerFrame;
import transfer.MyFile;

import java.io.File;
import java.util.*;

public class ServerMain0 {
    public static void main(String[] args)throws Exception {
        ServerFrame serverFrame=new ServerFrame();
        serverFrame.setLocation(730,470);
        serverFrame.serverpanel(" FILE TO DOWNLOAD");
        serverFrame.setVisible(true);

        Functions functions=new Functions();
        MyFile myFile=functions.myServer(7000);
        functions.setmyFile(myFile);
        serverFrame.getfileToDownload().setText("~ "+functions.getmyFile().getfile().getName());
        serverFrame.getjbdownload().setVisible(true);

        String[] serverspath={"1st_part","2nd_part"};
        File[] file_parts=functions.splitFile(myFile.getabsolutePath(),serverspath);

        functions.setfiletoSend(file_parts[0]);
        functions.myClient(7001);

        functions.setfiletoSend(file_parts[1]);
        functions.myClient(7002);

        ServerListener serverListener=new ServerListener(functions);
        serverListener.setserverFrame(serverFrame);
        serverListener.setfileparts(file_parts);
        serverListener.getserverFrame().getjbdownload().addMouseListener(serverListener);

        serverFrame.setVisible(true);
    }
}