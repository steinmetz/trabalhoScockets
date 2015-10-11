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
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JLabel;

/**
 *
 * @author charles
 */
public class TCPServerSocket {

    private int port = 9000;
    private boolean listening = false;

    public TCPServerSocket(int port) {
        this.port = port;
    }

    public void start(JLabel status) throws IOException {
        listening = true;
        do {
            ServerSocket serverSocket = null;

            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                status.setText("Could not listen on port:" + port);
                System.err.println("Could not listen on port:" + port);
                System.exit(1);
            }

            Socket clientSocket = null;

            status.setText("Waiting for connection.....");

            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                status.setText("Accept failed.");
                System.exit(1);
            }

            status.setText("Connection successful\n" + "Waiting for input.....");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) { 
                out.println(inputLine); 
                System.out.println("Charles");
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } while (listening);

    }

    public void stop() {
        listening = false;
    }
}
