package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:55.
 * Contact: johanp7@kth.se
 */

public class WaitAck extends State {

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
        return new Connected();
    }
}
