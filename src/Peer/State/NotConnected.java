package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

import java.net.ServerSocket;

/**
 * State NotConnected can go to Connecting or WaitOk.
 */
public class NotConnected extends State {

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

    public State sendInvite() {
        return new WaitOkConnect();
    }

    public State gotInvite() {
        return new Connecting();
    }
}