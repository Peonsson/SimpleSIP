package Peer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Main {

    private static boolean busy = false;
    private static int SERVER_PORT = 5060;

    public static void main(String[] args) {
        try {
            ServerSocket listenSocket = new ServerSocket(SERVER_PORT);
            StateHandler handler = new StateHandler(listenSocket);

            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            handler.invokeSendInvite(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
