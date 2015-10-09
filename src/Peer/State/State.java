package Peer.State;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public abstract class State {
    public abstract String getName();

    public State sendBye() {
        return this;
    }

    //TODO: change this name.
    public State gotBye() {
        return this;
    }

    public State tryConnect() {
        return this;
    }

    //TODO: Change name of this method.
    public State failedConnecting() {
        return this;
    }

    public State sendInvite(Socket clientSocket) {
        return this;
    }

    public State gotInvite() {
        return this;
    }

    //TODO: change this name.
    public State failedWaitAck() {
        return this;
    }

    //TODO: change this name.
    public State gotAck() {
        return this;
    }

    //TODO: change this name.
    public State gotBusy() {
        return this;
    }

    public State sendAck() {
        return this;
    }

    public State gotOk() {
        return this;
    }

    public State noResponse() {
        return this;
    }


}
