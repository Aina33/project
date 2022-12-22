package server;
import display.ServerFrame;
import transfer.MyFile;
import transfer.Functions;

import java.util.*;

public class ServerMain2 {
    public static void main(String[] args)throws Exception {
        ServerFrame serverFrame=new ServerFrame();
        serverFrame.setLocation(730,260);
        serverFrame.serverpanel("2nd PART OF THE FILE");
        serverFrame.setVisible(true);

        Functions functions=new Functions();
        MyFile myFile=functions.myServer(7002);

        serverFrame.getfileToDownload().setText("-> "+myFile.getfile().getName());

        serverFrame.setVisible(true);
    }
}