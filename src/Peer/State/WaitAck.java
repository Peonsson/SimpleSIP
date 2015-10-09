package Peer.State;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class WaitAck extends State {

    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    @Override
    public String getName() {
        return "WaitAck";
    }

    //TODO: change this name.
    public State failedWaitAck() {
        return new NotConnected();
    }

    //TODO: change this name.
    public State gotAck() {
        return new Connected(socket, in, out);
    }
}
