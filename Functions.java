package transfer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Functions{
    File filetoSend;

    public File getfiletoSend() {
        return filetoSend;
    }

    public void setfiletoSend(File filetoSend) {
        this.filetoSend = filetoSend;
    }
    public void myClient()throws Exception{
        File file = new File(this.getfiletoSend().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        Socket socket=new Socket("localhost",7000);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String filename=file.getName();
        byte[] filenameByte=filename.getBytes();

        byte[] fileByte=new byte[(int) file.length()];
        fileInputStream.read(fileByte);

        dataOutputStream.writeInt(filenameByte.length);
        dataOutputStream.write(filenameByte);

        dataOutputStream.writeInt(fileByte.length);
        dataOutputStream.write(fileByte);

        fileInputStream.close();
        dataOutputStream.close();
    }

    public void myServer()throws Exception{
        ServerSocket serverSocket =new ServerSocket(7000);
        while (true){
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            int filenamelength=dataInputStream.readInt();
            String filename="";
            if(filenamelength>0){
                System.out.println("oooooooo");
                byte[] filenameBytes=new byte[filenamelength];
                dataInputStream.readFully(filenameBytes,0,filenamelength);
                filename=new String(filenameBytes);

                int filelength=dataInputStream.readInt();
                if(filelength>0){
                    byte[] fileBytes=new byte[filelength];
                    dataInputStream.readFully(fileBytes,0,filelength);
                }
                System.out.println(filename);
            }
        }
    }
}
