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

/**
 * State NotConnected can go to Connecting or WaitOk.
 */
public class NotConnected extends State {

    private Socket socket;
    private String sip_from;
    private String sip_to;
    private String ip_from;
    private String ip_to;
    private String voice_port;

    private ServerSocket listenSocket;

    /**
     * Constructor
     */
    public NotConnected(ServerSocket listenSocket) {
        this.listenSocket = listenSocket;
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
            socket = new Socket(address, 5060);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("INVITE");
            return new WaitOkConnect(socket, in, out);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public State gotInvite() {
        return new Connecting();
    }
}