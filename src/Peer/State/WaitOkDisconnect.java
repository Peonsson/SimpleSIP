package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:54.
 * Contact: johanp7@kth.se
 */

public class WaitOkDisconnect extends State {

    @Override
    public String getName() {
        return "WaitOkDisconnect";
    }

    public State gotOk() {
        return new NotConnected();
    }

    public State noResponse() {
        return new NotConnected();
    }
}
