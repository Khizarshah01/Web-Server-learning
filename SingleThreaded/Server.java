import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000); // Optional
        while (true) {
            try {
                System.out.println("Server is listening on port " + port);
                Socket acceptedConnection = serverSocket.accept(); // Accepts a client connection
                System.out.println("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress());

                // Send message to client
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true); // Auto-flush enabled ~true~
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                // Respond to the client
                toClient.println("Hello I am Server ");

                // Close client socket after use
                fromClient.close();
                toClient.close();
                acceptedConnection.close(); // Close the client connection, not the ServerSocket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //serverSocket.close(); // Do not close the ServerSocket inside the loop
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
