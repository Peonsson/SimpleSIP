package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:55.
 * Contact: johanp7@kth.se
 */

public class Connected extends State {

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
