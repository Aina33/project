package transfer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Functions{
    File filetoSend;
    MyFile myFile=new MyFile();

    public File getfiletoSend() { return filetoSend; }
    public MyFile getmyFile() { return myFile; }

    public void setfiletoSend(File filetoSend) { this.filetoSend = filetoSend; }
    public void setmyFile(MyFile myFile) { this.myFile = myFile; }

    public MyFile myServer(int port)throws Exception{
        ServerSocket serverSocket =new ServerSocket(port);
        String filename="";
        int idfile=0;
        byte[] fileBytes=null;
        String filepath="";

        while (true){
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            int filenamelength=dataInputStream.readInt();
            if(filenamelength>0){
                idfile+=1;
                byte[] filenameBytes=new byte[filenamelength];
                dataInputStream.readFully(filenameBytes,0,filenamelength);
                filename=new String(filenameBytes);

                int filelength=dataInputStream.readInt();
                if(filelength>0){
                    fileBytes=new byte[filelength];
                    dataInputStream.readFully(fileBytes,0,filelength);
                }

                int filepathlength=dataInputStream.readInt();
                if(filepathlength>0){
                    byte[] filepathBytes=new byte[filepathlength];
                    dataInputStream.readFully(filepathBytes,0,filepathlength);
                    filepath=new String(filepathBytes);
                }
                return new MyFile(idfile,new File(filename),filepath,fileBytes);
            }
        }
    }

    public void myClient(int port)throws Exception{
        String absolutePath=this.getfiletoSend().getAbsolutePath();
        File file = new File(absolutePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Socket socket=new Socket("localhost",port);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String filename=file.getName();

        byte[] filenameByte=filename.getBytes(); //pour envoyer le nom du fichier
        byte[] fileByte=new byte[(int) file.length()]; //pour envoyer le contenu du fichier
        byte[] pathByte=absolutePath.getBytes(); //pour envoyer le chemin du fichier

        fileInputStream.read(fileByte);

        dataOutputStream.writeInt(filenameByte.length);
        dataOutputStream.write(filenameByte);

        dataOutputStream.writeInt(fileByte.length);
        dataOutputStream.write(fileByte);

        dataOutputStream.writeInt(pathByte.length);
        dataOutputStream.write(pathByte);

        fileInputStream.close();
        dataOutputStream.close();
    }

    public File[] splitFile(String path, String[] serverpath)throws Exception{
        File[] file_parts=new File[2];
        int nb_file=1;
        //ex:path = C:\\file.txt
        String newfile_name=path.substring(path.lastIndexOf("\\")); //ex: file.txt
        String newfile_path="";
        int newfile_size=0;

        long sizefile=(new File(path)).length();
        byte bytefile[]=new byte[(int)sizefile];
        FileInputStream fis=new FileInputStream(path);

        while(fis.available()!=0 && nb_file<3){
            //ex:serverpath=1st_part
            newfile_path=serverpath[nb_file-1]+newfile_name+"."+nb_file;
            FileOutputStream fos=new FileOutputStream(newfile_path);
            newfile_size=fis.read(bytefile,0,(bytefile.length/2));
            fos.write(bytefile,0,newfile_size);
            file_parts[nb_file-1]=new File(newfile_path);
            nb_file++;
        }
        fis.close();
        return file_parts;
    }

    public void downloadJoinFile(File[] part_file)throws Exception{
        byte[] part_size=new byte[(int) part_file[0].length()];
        String[] part_path={part_file[0].getAbsolutePath(),part_file[1].getAbsolutePath()};

        String[] file_name=new String[2];
        file_name[0]=part_path[0].substring(0,part_path[0].lastIndexOf(".")); 
        file_name[1]=part_path[1].substring(0,part_path[1].lastIndexOf("."));

        String file_extension=file_name[0].substring(file_name[0].lastIndexOf(".")); 

        String new_file_name=file_name[0].substring(part_path[0].lastIndexOf("\\"),part_path[0].indexOf("."))+"_joined"; //ex: file_joined.txt
        String combine_file_path="downloads\\"+new_file_name+file_extension;

        FileOutputStream fos = new FileOutputStream(combine_file_path);
        FileInputStream fis=null;
        int numero_file=1;
        int combine_file_size=0;
        String parts_name_path="";
        int indice=0;

        while(true){
            parts_name_path=file_name[indice]+"."+numero_file;
            File file=new File(parts_name_path);
            if(file.exists()){
                fis=new FileInputStream(parts_name_path);
                while (fis.available()!=0){
                    combine_file_size=fis.read(part_size,0,(int)file.length());
                    fos.write(part_size,0,combine_file_size);
                }
                fis.close();
                numero_file++;
                indice=1;
            }
            else {
                break;
            }
            fis.close();
        }
    }
}
