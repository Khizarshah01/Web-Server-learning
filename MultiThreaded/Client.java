public class Client{
    public Runnable getRunnable(){
        @Override
        public void run(){
            try{

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
            }catch(e Exception)
            {
                e.printStackTrace();
            }

    }
    public  static void main(String[] args){
        Client client = new Client();
        for(int i = 0; i < 100; i++)
        {
            try{
                Thread thred = new Thread(client.getRunnable());
                thread.start();
            }catch(e Exception){
                e.printStackTrace();
            }
        }
    }
}
