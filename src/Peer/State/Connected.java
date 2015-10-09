package Peer.State;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Connected extends State {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Connected(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public String getName() {
        return "Connected";
    }

    public State sendBye() {
        return new WaitOkDisconnect();
    }

    //TODO: change this name.
    public State gotBye() {
        return new NotConnected();
    }
}
