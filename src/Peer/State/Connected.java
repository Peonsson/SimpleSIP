package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
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
