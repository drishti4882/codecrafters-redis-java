import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        serverSocket.setReuseAddress(true);
        Socket client = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        OutputStream out = client.getOutputStream();

        String line;
        while ((line = in.readLine()) != null) {
            if (line.equalsIgnoreCase("PING")) {
                out.write("+PONG\r\n".getBytes());
                out.flush();
            }
        }
    }
}