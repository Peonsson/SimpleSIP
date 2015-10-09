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

    @Override
    public String getName() {
        return "NotConnected";
    }

    public State sendInvite(String input) {
        String[] parts = input.split(" ");

        if (parts.length == 6) {
            ip_to = parts[3];
        }
            return new WaitOkConnect();

    }

    public State gotInvite(String input) {

        if (input.equals("INVITE")) {
            return new Connecting();
        } else {
            return null;
        }

    }
}