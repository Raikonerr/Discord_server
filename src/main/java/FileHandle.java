import java.io.*;
import java.net.Socket;

public class FileHandle {

    private final Socket socket;


    public FileHandle(Socket socket) {
        this.socket = socket;
    }

    public void sendFile() throws Exception{
        FileInputStream fr = new FileInputStream("C://file/file.rtf");
        byte[] b = new byte[2000];
        fr.read(b,0,b.length);
        OutputStream os = socket.getOutputStream();
        os.write(b,0,b.length);
        os.flush();
    }

    public void recieveFile() throws Exception{
        InputStream is = socket.getInputStream();
        FileOutputStream fr = new FileOutputStream("C://files/file.rtf");
        byte[] b = new byte[2000];
        is.read(b, 0, b.length);
        fr.write(b, 0, b.length);
        fr.flush();

    }
}
