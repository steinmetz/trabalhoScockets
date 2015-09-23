/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author charles
 */
public class UTPServerSocket {

    private int port = 9000;

    public UTPServerSocket(int port) {
        this.port = port;
    }
    
    public void start() throws Exception {
        try {
            DatagramSocket serverSocket = new DatagramSocket(port);

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {

                receiveData = new byte[1024];

                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("Waiting for datagram packet");

                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                System.out.println("From: " + IPAddress + ":" + port);
                System.out.println("Message: " + sentence);

                String capitalizedSentence = sentence.toUpperCase();

                sendData = capitalizedSentence.getBytes();

                DatagramPacket sendPacket
                        = new DatagramPacket(sendData, sendData.length, IPAddress,
                                port);

                serverSocket.send(sendPacket);

            }

        } catch (SocketException ex) {
            System.out.println("UDP Port "+port+" is occupied.");
            System.exit(1);
        }

    }
}
