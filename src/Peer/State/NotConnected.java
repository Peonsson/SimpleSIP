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

    @Override
    public String getName() {
        return "NotConnected";
    }

    public State sendInvite(Socket socket) {

        try {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("INVITE");

            return new WaitOkConnect();

        } catch (IOException e) {
            e.printStackTrace();
            return new NotConnected();
        }
    }

    public State gotInvite(String input) {

        if (input.equals("INVITE")) {
            return new Connecting();
        } else {
            return new NotConnected();
        }
    }
}