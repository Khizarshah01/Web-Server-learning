import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public class Client{
    public void run() throws UnknownHostException, IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);

        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toSocket.println("Hello from the client");
        toSocket.flush();
        
        String line = fromSocket.readLine();
        System.out.println("Response from socket: " + line);

        // Close the streams first, then the socket
        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String args[]){
        Client client = new Client();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
