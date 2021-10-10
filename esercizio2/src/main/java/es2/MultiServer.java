package es2;

import java.io.IOException;
import java.net.*;



public class MultiServer {
   public void start() {
       try {
        ServerSocket serverSocket = new ServerSocket(6789);
        for(;;){
        System.out.println("1 Server in attesa ...");
        Socket socket = serverSocket.accept();
        System.out.println("3 Server socket "+socket);
        Server server = new Server(socket);
        server.start();
        }
       } catch (IOException e) {
           System.out.println(e.getMessage());
           System.out.println("Errore durante l'istanza del server");
           System.exit(1);
       }

   }
   
}
