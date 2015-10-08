package Peer;

import Peer.State.NotConnected;
import Peer.State.State;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class SIPStateHandler {

   private State currentState;

   public SIPStateHandler() {
      currentState = new NotConnected();
   }

   public String getState() {
      return currentState.getName();
   }

   public void invokeSendInvite() {
      currentState = currentState.sendInvite();
   }

}
