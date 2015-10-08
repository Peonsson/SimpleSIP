package Peer;

import java.util.Scanner;

/**
 * Created by Peonsson and roppe546 on 2015-10-08 17:19.
 */

public class ClientHandler extends Thread {

    private boolean busy;

    private String sip_to;
    private String sip_from;
    private String ip_to;
    private String ip_from;
    private String voice_port;

    public ClientHandler(boolean busy) {
        this.busy = busy;
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


            } else
                System.err.println(errorMsg);
        }
    }
}
