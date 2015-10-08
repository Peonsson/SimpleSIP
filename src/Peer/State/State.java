package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:48.
 * Contact: johanp7@kth.se
 */

public abstract class State {
    public abstract String getName();

    public State NotConnected() {
        return this;
    }

    public State Connecting() {
        return this;
    }

    public State WaitOkDisconnect() {
        return this;
    }

    public State WaitOkConnect() {
        return this;
    }

    public State WaitAck() {
        return this;
    }

    public State Connected() {
        return this;
    }
}
