/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import frame.Relatorio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charles
 */
public class TCPClientSocket {
    
    private String serverHostname;
    private int serverPort;
    private String message;
    private boolean sending = false;
    Socket echoSocket = null;

    public TCPClientSocket(String serverHostname, int serverPort, String message) {
        this.serverHostname = serverHostname;
        this.serverPort = serverPort;
        this.message = message;
    }

    public Relatorio start(int repeticoes) throws IOException {
        sending = true;
        
        PrintWriter out = null;
        BufferedReader in = null;
        Relatorio relatorio = new Relatorio();
        relatorio.bytes = message.getBytes().length;
        relatorio.repeticoes = repeticoes;
        
        try { 
            echoSocket = new Socket(serverHostname,serverPort );
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }
        
        long start, end;
        String receiveMessage;
        boolean error;
        for (int i  = 0; i < repeticoes; i++) {
            error = false;
            start = System.nanoTime();
            out.println(message);
            receiveMessage = in.readLine();
            end = System.nanoTime();
            if(!message.equals(receiveMessage)){
                error = true;
                System.out.println("error cliente");
            } 
            if(error){
                relatorio.erros++;
            }
            relatorio.tempos.add(end-start);            
        }

        out.close();
        in.close();
        echoSocket.close();
        return relatorio;
    }
    public void stop(){
        sending = false;
        try {
            echoSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
