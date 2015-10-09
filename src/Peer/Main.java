package Peer;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Main {

    private static StateHandler handler;

    public static void main(String[] args) {
        new ClientHandler();
        handler = new StateHandler();
    }

    private static class ClientHandler extends Thread {

        @Override
        public void run() {

            String sip_from;
            String sip_to;
            String ip_from;
            String ip_to;
            String voice_port;
            final int SERVER_PORT = 5060;

            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            String[] parts = input.split(" ");

            if (parts.length == 6) {

                sip_from = parts[1];
                sip_to = parts[2];
                ip_to = parts[3];
                ip_from = parts[4];

                try {

                    InetAddress host = InetAddress.getByName(ip_to);
                    Socket clientSocket = new Socket(host, SERVER_PORT);
                    handler.invokeSendInvite(clientSocket);

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}}