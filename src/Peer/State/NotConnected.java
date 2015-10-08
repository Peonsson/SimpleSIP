package Peer.State;

/**
 * Created by Johan Pettersson on 2015-10-08 15:53.
 * Contact: johanp7@kth.se
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