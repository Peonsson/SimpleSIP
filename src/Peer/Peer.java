package Peer;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Peer {

    private static boolean busy = false;

    public static void main(String[] args) {

        new Peer.StateHandler(busy);
        new ClientHandler(busy).start();

    }
}
