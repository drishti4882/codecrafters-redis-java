import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        serverSocket.setReuseAddress(true);
        Socket client = serverSocket.accept();
        OutputStream out = client.getOutputStream();
        out.write("+PONG\r\n".getBytes());
        out.flush();
    }
}