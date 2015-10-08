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

    public void invokeSendBye() {
        currentState = currentState.sendBye();
    }

    public void invokeGotBye() {
        currentState = currentState.gotBye();
    }

    public void invokeTryConnect() {
        currentState = currentState.tryConnect();
    }

    public void invokeFailedConnecting() {
        currentState = currentState.failedConnecting();
    }

    public void invokeGotInvite() {
        currentState = currentState.gotInvite();
    }

    public void invokeFailedWaitAck() {
        currentState = currentState.failedWaitAck();
    }

    public void invokeGotAck() {
        currentState = currentState.gotAck();
    }

    public void invokeGotBusy() {
        currentState = currentState.gotBusy();
    }

    public void invokeSendAck() {
        currentState = currentState.sendAck();
    }

    public void invokeGotOk() {
        currentState = currentState.gotOk();
    }

    public void invokeNoResponse() {
        currentState = currentState.noResponse();
    }
 }
