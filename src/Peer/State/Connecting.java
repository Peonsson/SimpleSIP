package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Connecting extends State {

    @Override
    public String getName() {
        return "Connecting";
    }

    public State tryConnect() {
        return new WaitAck();
    }

    //TODO: Change name of this method.
    public State failedConnecting() {
        return new NotConnected();
    }
}
