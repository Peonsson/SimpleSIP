package Peer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Peonsson and roppe546 on 2015-10-08 17:19.
 */

public class ClientHandler extends Thread {

    private boolean busy;
    private StateHandler handler;

    private Socket socket;
    private String sip_to;
    private String sip_from;
    private String ip_to;
    private String ip_from;
    private String voice_port;

    public ClientHandler(boolean busy, StateHandler handler) {
        this.busy = busy;
        this.handler = handler;
    }

    @Override
    public void run() {

        Scanner scan = new Scanner(System.in);

        String startMsg = "INVITE <sip_to> <sip_from> <ip_to> <ip_from> <voice_port> or /quit to exit.";
        String errorMsg = "INVITE <sip_to> <sip_from> <ip_to> <ip_from> <voice_port> or /quit to exit.";

        while (true) {

            System.out.println(startMsg);
            String arg = scan.nextLine();
            String[] parts = arg.split(" ");

            if(busy == true) {
                System.err.println("Can't initiate a call while calling or talking with someone!");
                continue;
            }

            if (parts[0].startsWith("/quit"))
                System.exit(0);

            else if (parts.length == 6) {

                sip_to = parts[1];
                sip_from = parts[2];
                ip_to = parts[3];
                ip_from = parts[4];
                voice_port = parts[5];

                try {

                    InetAddress host = InetAddress.getLocalHost();
                    host = InetAddress.getByName(ip_to);
                    socket = new Socket(host, 5060);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    handler.invokeSendInvite(); // go from not connected to waitOk
                    out.println("INVITE");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String response = in.readLine();

                    if(response.equals("OK")) {
                        out.println("ACK");
                        System.out.println("we are now connected, yo");
                        handler.invokeSendAck();
                    } else if(response.equals("BUSY")) {
                        System.out.println("got busy");
                        handler.invokeGotBusy();
                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                System.err.println(errorMsg);
        }
    }
}
