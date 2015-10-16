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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @author charles
 */
public class UDPClientSocket {

    private String serverHostname;
    private int serverPort;
    private String message;
    private boolean sending = false;

    public UDPClientSocket(String serverHostname, int serverPort, String message) {
        this.serverHostname = serverHostname;
        this.serverPort = serverPort;
        this.message = message;
    }

    public Relatorio start(int repeticoes) throws Exception {
        Relatorio relatorio = new Relatorio();
        relatorio.bytes = message.getBytes().length;
        relatorio.repeticoes = repeticoes;
        try {
            
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(serverHostname);
            System.out.println("Attemping to connect to " + IPAddress
                    + ") via UDP port 9876");
 
            byte[] sendData; 
            byte[] receiveData = new byte[30000];

            sendData = message.getBytes();

            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, serverPort);

            long start, end;
            String receiveMessage = "";
            boolean error;
            for (int i = 0; i < repeticoes; i++) {
                error = false;
                start = System.nanoTime();
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData, receiveData.length);
                //System.out.println("Waiting for return packet"); 
                clientSocket.setSoTimeout(1000); 
                try {
                    clientSocket.receive(receivePacket);
                    receiveMessage
                            = new String(receivePacket.getData()).trim();                    
                    
                } catch (SocketTimeoutException ste) {
                    System.out.println("Timeout Occurred: Packet assumed lost");
                    error = true;
                }
                end = System.nanoTime();
                if (!message.equals(receiveMessage)) {
                    error = true; 
                    System.out.println("E:"+message);
                    System.out.println("R:"+receiveMessage);
                    System.out.println("\n\n");
                }
                if(error){
                    relatorio.erros++;
                }
                relatorio.tempos.add(end-start);
            }

            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return relatorio;
    }
}
