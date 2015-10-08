package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:54.
 * Contact: johanp7@kth.se
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
