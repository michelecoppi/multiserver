  package es2;

import java.net.*;
import java.io.*;

public class Server extends Thread{

ServerSocket server=null;
Socket client= null;
String stringaRicevuta= null;
String stringaModificata= null;
BufferedReader inDalClient;
DataOutputStream outVersoClient;

public Server (Socket s){

this.client=s;
}

@Override
public void run(){
try {
  comunica();
} catch (Exception e) {
  e.getMessage();
}

}
public void comunica() throws Exception{
inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
outVersoClient = new DataOutputStream(client.getOutputStream());

for(;;){
stringaRicevuta= inDalClient.readLine();
if(stringaRicevuta==null || stringaRicevuta.equals("FINE")){
outVersoClient.writeBytes(stringaRicevuta+"=>server in chiusura..."+"\n");
System.out.println("Echo sul server in chiusura :"+stringaRicevuta);
break;

}
else{
  outVersoClient.writeBytes(stringaRicevuta+" ricevuta e ritrasmessa"+"\n");
  System.out.println("6 echo sul server:"+stringaRicevuta);
}
        } 
outVersoClient.close();
inDalClient.close();
System.out.println("9 chiusura socket"+client);
client.close();
}



}



