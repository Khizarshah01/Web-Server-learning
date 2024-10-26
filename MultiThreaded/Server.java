import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {

    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello form the server");
                toClinet.close();
                clientSocket.close();
            }catch.(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {   int port = 8010;
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port" + port);
            while(true){
                Socket acceptedSocket = serverSocket.accept(); // make new socket as a acknowledge
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedSoocket));
                Thread.start();
            }
        }catch(e IOException){
            e.printStackTrace();
        }
    }
}
