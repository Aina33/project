package server;
import display.ServerFrame;
import transfer.MyFile;
import transfer.Functions;

import java.util.*;

public class ServerMain1 {
    public static void main(String[] args)throws Exception {
        ServerFrame serverFrame=new ServerFrame();
        serverFrame.setLocation(730,50);
        serverFrame.serverpanel("1st PART OF THE FILE");
        serverFrame.setVisible(true);

        Functions functions=new Functions();
        MyFile myFile=functions.myServer(7001);

        serverFrame.getfileToDownload().setText("-> "+myFile.getfile().getName());

        serverFrame.setVisible(true);
    }
}