/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author charles
 */
public class TCPClientSocket {
    
    private String serverHostname;
    private int serverPort;
    private String message;
    private boolean sending = false;

    public TCPClientSocket(String serverHostname, int serverPort, String message) {
        this.serverHostname = serverHostname;
        this.serverPort = serverPort;
        this.message = message;
    }

    public void start(String[] args) throws IOException {
        sending = true;
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

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
        while (sending) {
            error = false;
            start = System.nanoTime();
            out.println(message);
            receiveMessage = in.readLine();
            end = System.nanoTime();
            if(!message.equals(receiveMessage)){
                error = true;
            }
            System.out.println("echo: " + in.readLine());
            System.out.print("input: ");
        }

        out.close();
        in.close();
        echoSocket.close();
    }
    public void stop(){
        sending = false;
    }

}
