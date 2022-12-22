package transfer;
import java.io.*;
public class MyFile {
    int idfile;
    File file;
    String absolutePath;
    byte[] filebytes;

    public int getidfile() {
        return idfile;
    }
    public File getfile() {
        return file;
    }
    public String getabsolutePath() {
        return absolutePath;
    }
    public byte[] getfilebytes() {
        return filebytes;
    }

    public void setidfile(int idfile) {
        this.idfile = idfile;
    }
    public void setfile(File file) {
        this.file = file;
    }
    public void setabsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
    public void setfilebytes(byte[] filebytes) {
        this.filebytes = filebytes;
    }

    public MyFile(){
    }
    public MyFile(int idfile,File file,String absolutePath,byte[] filebytes){
        this.setidfile(idfile);
        this.setfile(file);
        this.setabsolutePath(absolutePath);
        this.setfilebytes(filebytes);
    }
}