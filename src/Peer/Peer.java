package Peer;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Peer {

    private static boolean busy = false;
    private static int SERVER_PORT = 5060;

    public static void main(String[] args) {

        StateHandler handler = new StateHandler();
        new ClientHandler(busy).start();

        try {
            ServerSocket listenSocket = new ServerSocket(SERVER_PORT);
            Socket clientSocket = listenSocket.accept();
            handler.invokeGotInvite(); // goes from notConnected to connecting











        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
