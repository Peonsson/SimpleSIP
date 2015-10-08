package Peer;

import Peer.State.NotConnected;
import Peer.State.State;

/**
 * Created by Johan Pettersson on 2015-10-08 16:18.
 * Contact: johanp7@kth.se
 */

public class SIPStateHandler {

    private State currentState;

    public SIPStateHandler() {
        currentState = new NotConnected();
    }

    public String getState(){
        return currentState.getName();
    }

    public void invokeSendInvite() {
        currentState = currentState.sendInvite();
    }

 }
