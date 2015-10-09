package Peer;

import Peer.State.NotConnected;
import Peer.State.State;

import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class StateHandler {

    private State currentState;

    public StateHandler() {
        currentState = new NotConnected();
    }

    public String getState() {
        return currentState.getName();
    }

    public void invokeSendInvite(Socket clientSocket) {
        currentState = currentState.sendInvite(clientSocket);
    }

    public void invokeGotInvite(String input) {
        currentState = currentState.gotInvite(input);
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
