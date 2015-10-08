package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
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
