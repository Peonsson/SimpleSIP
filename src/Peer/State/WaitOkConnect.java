package Peer.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class WaitOkConnect extends State {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;


    public WaitOkConnect(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;

        try {

            String response = in.readLine();

            if (response.equals("OK")) {

                sendAck(socket, in, out);

            } else if (response.equals("BUSY")) {

                gotBusy();

            } else {

                out.println("I DIDN'T RECEIVE OK FROM YOU.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "WaitOkConnect";
    }

    //TODO: change this name.
    public State gotBusy() {
        return new NotConnected();
    }

    public State sendAck(Socket socket, BufferedReader in, PrintWriter out) {
        return new Connected(socket, in, out);
    }
}
