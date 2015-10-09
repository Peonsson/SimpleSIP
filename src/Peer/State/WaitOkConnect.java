package Peer.State;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class WaitOkConnect extends State {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;


    public WaitOkConnect (Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public String getName() {
        return "WaitOkConnect";
    }

    //TODO: change this name.
    public State gotBusy() {
        return new NotConnected();
    }

    public State sendAck() {
        return new Connected();
    }
}
