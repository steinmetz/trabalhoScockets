/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

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
public class UTPClientSocket {
    
    private String serverHostname;
    private int serverPort;
    private String message;
    private boolean sending = false;

    public UTPClientSocket(String serverHostname, int serverPort, String message) {
        this.serverHostname = serverHostname;
        this.serverPort = serverPort;
        this.message = message;
    }   
    
    public void start() throws Exception {
        try {  

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(serverHostname);
            System.out.println("Attemping to connect to " + IPAddress
                    + ") via UDP port 9876");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
 
            sendData = message.getBytes();

            System.out.println("Sending data to " + sendData.length
                    + " bytes to server.");
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, serverPort);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket
                    = new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Waiting for return packet");
            clientSocket.setSoTimeout(10000);

            try {
                clientSocket.receive(receivePacket);
                String modifiedSentence
                        = new String(receivePacket.getData());

                InetAddress returnIPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                System.out.println("From server at: " + returnIPAddress
                        + ":" + port);
                System.out.println("Message: " + modifiedSentence);

            } catch (SocketTimeoutException ste) {
                System.out.println("Timeout Occurred: Packet assumed lost");
            }

            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
