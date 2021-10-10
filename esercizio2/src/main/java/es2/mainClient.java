package es2;

import java.io.IOException;

public class mainClient {
    public static void main(String[] args) throws IOException{
    Client cliente = new Client();
    cliente.connetti();
    cliente.comunica();
    
    }
}
