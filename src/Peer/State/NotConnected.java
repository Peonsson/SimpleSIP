package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * State NotConnected can go to Connecting or WaitOk.
 */
public class NotConnected extends State {

    private String sip_from;
    private String sip_to;
    private String ip_from;
    private String ip_to;
    private String voice_port;

    private int SERVER_PORT = 5060;

    /**
     * Constructor
     */
    public NotConnected() {

        new ClientHandler().start();

        try {

            ServerSocket listenSocket = new ServerSocket(SERVER_PORT);
            Socket clientSocket = listenSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String input = in.readLine();
            gotInvite(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "NotConnected";
    }

    public State sendInvite(String input) {
        String[] parts = input.split(" ");

        if (parts.length == 6) {
            ip_to = parts[3];
        }

        try {

            InetAddress address = InetAddress.getByName(ip_to);
            Socket socket = new Socket(address, 5060);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("INVITE");

            return new WaitOkConnect(socket, in, out);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public State gotInvite(String input) {

        if (input.equals("INVITE")) {
            return new Connecting();
        } else {
            return null;
        }

    }

    private class ClientHandler extends Thread {

        @Override
        public void run() {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            sendInvite(input);
        }
    }
}