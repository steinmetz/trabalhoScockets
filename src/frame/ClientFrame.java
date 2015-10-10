/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import socket.TCPClientSocket;
import socket.TCPServerSocket;
import socket.UDPClientSocket;
import socket.UDPServerSocket;

/**
 *
 * @author charles
 */
public class ClientFrame extends javax.swing.JFrame {

    private String mensagem  = "";
    public ClientFrame() {
        initComponents();
        mensagem = generateString(Integer.parseInt(cliEdtTamanho.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cliRadGroup = new javax.swing.ButtonGroup();
        servRadGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        cliEdtHost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cliEdtPorta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cliEdtRepeticoes = new javax.swing.JTextField();
        cliRadUDP = new javax.swing.JRadioButton();
        cliRadTCP = new javax.swing.JRadioButton();
        cliBtnStart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cliEdtTamanho = new javax.swing.JTextField();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel8 = new javax.swing.JLabel();
        servEdtPorta = new javax.swing.JTextField();
        servBtnStart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        servTxtStatus = new javax.swing.JLabel();
        servRadUDP = new javax.swing.JRadioButton();
        servRadTCP = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Cliente");
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Host");

        cliEdtHost.setText("localhost");

        jLabel2.setText("Porta");

        cliEdtPorta.setText("9000");

        jLabel4.setText("Repetições");

        cliEdtRepeticoes.setText("50");

        cliRadGroup.add(cliRadUDP);
        cliRadUDP.setText("UDP");

        cliRadGroup.add(cliRadTCP);
        cliRadTCP.setText("TCP");

        cliBtnStart.setText("Start");
        cliBtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliBtnStartActionPerformed(evt);
            }
        });

        jLabel5.setText("Tamanho Msg");

        cliEdtTamanho.setText("1000");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229)
                        .addComponent(jLabel2))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cliRadTCP))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(cliEdtRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cliRadUDP)))
                            .addGap(46, 46, 46)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cliEdtTamanho))
                            .addGap(27, 27, 27))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(cliEdtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cliEdtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(cliBtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliEdtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliEdtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cliRadTCP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cliEdtRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliRadUDP)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliEdtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(cliBtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jInternalFrame2.setTitle("Servidor");
        jInternalFrame2.setVisible(true);

        jLabel8.setText("Porta");

        servEdtPorta.setText("9000");

        servBtnStart.setText("Start");
        servBtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servBtnStartActionPerformed(evt);
            }
        });

        jLabel9.setText("Status");

        servTxtStatus.setText("Off");

        servRadGroup.add(servRadUDP);
        servRadUDP.setText("UDP");

        servRadGroup.add(servRadTCP);
        servRadTCP.setText("TCP");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(servTxtStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(servRadTCP))
                    .addComponent(servRadUDP))
                .addGap(26, 26, 26))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servEdtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(servBtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servEdtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servTxtStatus))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(servRadTCP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servRadUDP)))
                .addGap(20, 20, 20)
                .addComponent(servBtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtRelatorio.setColumns(20);
        txtRelatorio.setRows(5);
        jScrollPane1.setViewportView(txtRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInternalFrame2)
                    .addComponent(jInternalFrame1)
                    .addComponent(jScrollPane1))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void servBtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servBtnStartActionPerformed

        final int porta = Integer.parseInt(servEdtPorta.getText());
        Runnable run = new Runnable() {

            @Override
            public void run() {
                if (servRadTCP.isSelected()) {

                    TCPServerSocket serverTCP = new TCPServerSocket(porta);
                    try {
                        serverTCP.start(servTxtStatus);
                    } catch (IOException ex) {
                        Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if(servRadUDP.isSelected()) {
                    UDPServerSocket serverUDP = new UDPServerSocket(porta);
                    try {
                        serverUDP.start(servTxtStatus);
                    } catch (Exception e) {
                    }
                }
            }
        };
        Thread thread = new Thread(run);
        thread.start();

    }//GEN-LAST:event_servBtnStartActionPerformed

    private void cliBtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliBtnStartActionPerformed
        final String host = cliEdtHost.getText();
        final int porta = Integer.parseInt(cliEdtPorta.getText());

        Runnable run = new Runnable() {

            @Override
            public void run() {
                if (cliRadTCP.isSelected()) {

                    TCPClientSocket clientTCP;
                    clientTCP = new TCPClientSocket(host, porta, mensagem);                    
                    try {
                        Relatorio relatorio = clientTCP.start(Integer.parseInt(cliEdtRepeticoes.getText()));
                        txtRelatorio.setText(relatorio.toString());
                    } catch (IOException ex) {
                        Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (cliRadUDP.isSelected()){
                    UDPClientSocket clientUDP;
                    clientUDP = new UDPClientSocket(host, porta, mensagem);
                    try {
                        Relatorio relatorio = clientUDP.start(Integer.parseInt(cliEdtRepeticoes.getText()));
                        txtRelatorio.setText(relatorio.toString());
                    } catch (Exception e) {
                    }
                    System.out.println("");
                }
            }
        };
        Thread thread = new Thread(run);
        thread.start();
    }//GEN-LAST:event_cliBtnStartActionPerformed

    public static String generateString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cliBtnStart;
    private javax.swing.JTextField cliEdtHost;
    private javax.swing.JTextField cliEdtPorta;
    private javax.swing.JTextField cliEdtRepeticoes;
    private javax.swing.JTextField cliEdtTamanho;
    private javax.swing.ButtonGroup cliRadGroup;
    private javax.swing.JRadioButton cliRadTCP;
    private javax.swing.JRadioButton cliRadUDP;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton servBtnStart;
    private javax.swing.JTextField servEdtPorta;
    private javax.swing.ButtonGroup servRadGroup;
    private javax.swing.JRadioButton servRadTCP;
    private javax.swing.JRadioButton servRadUDP;
    private javax.swing.JLabel servTxtStatus;
    private javax.swing.JTextArea txtRelatorio;
    // End of variables declaration//GEN-END:variables
}
