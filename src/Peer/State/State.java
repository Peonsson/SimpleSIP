package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:48.
 * Contact: johanp7@kth.se
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

    public State sendInvite() {
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
