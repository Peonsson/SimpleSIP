package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:54.
 * Contact: johanp7@kth.se
 */

public class WaitOkConnect extends State {

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
