package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
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
