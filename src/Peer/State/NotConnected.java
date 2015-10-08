package Peer.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

/**
 * State NotConnected can go to Connecting or WaitOk.
 */
public class NotConnected extends State {

    @Override
    public String getName() {
        return "NotConnected";
    }

    public State sendInvite() {
        return new WaitOkConnect();
    }

    public State gotInvite() {
        return new Connecting();
    }
}