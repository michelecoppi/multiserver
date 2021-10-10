package es2;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Client {
   String nomeServer="nomeServer";
   int portaServer= 6789;
   Socket miosocket;
   BufferedReader tastiera;
   String stringaUtente;
   String stringaRicevutaDalServer;
   DataOutputStream outVersoServer;
   BufferedReader inDalServer;

   
   
   public Socket connetti(){
   System.out.println("2 CLIENT partito in esecuzione ...");
       try {
           tastiera = new BufferedReader(new InputStreamReader(System.in));
           miosocket= new Socket(nomeServer,portaServer);
           
           outVersoServer= new DataOutputStream(miosocket.getOutputStream());
           inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
           
       } catch (Exception e) {
        System.out.println(e.getMessage());
        System.exit(1);
       }
   return miosocket;
   }
  public void comunica() throws IOException{
  for(;;)
  try{
  System.out.println("4 ... utente, inserisci la stringa da trasmettere al server:");
  stringaUtente = tastiera.readLine();
  System.out.println("5 ... invio la stringa al server e attendo");
  outVersoServer.writeBytes(stringaUtente+"\n");
  stringaRicevutaDalServer=inDalServer.readLine();
  System.out.println("7 ... risposta dal server"+"\n"+stringaRicevutaDalServer);
  if(stringaUtente.equals("FINE")){
      System.out.println("8 Client termina elaborazione e chiude connesione");
      miosocket.close();
    }break;
      }  
   catch(Exception e){
   System.out.println(e.getMessage());
   }
        
  }
}


