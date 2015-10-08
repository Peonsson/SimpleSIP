package Peer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Peer {

    private static boolean busy = false;

    public static void main(String[] args) {

        new SIPStateHandler(busy);
        new ClientHandler(busy).start();

    }
}
