package Peer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Johan Pettersson and Robin Veteläinen on 2015-10-07 13:06.
 * At Kungliga Tekniska Högskolan (KTH) in Sweden.
 * Contact: johanp7@kth.se
 */
public class Peer {

    private final static int SERVER_PORT = 5060;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


        } catch (IOException e) {

        }

    }

}
