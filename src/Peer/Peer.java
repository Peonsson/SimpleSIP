package Peer;

import com.sun.corba.se.spi.activation.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        new ClientHandler(busy, handler).start();

        try {
            ServerSocket listenSocket = new ServerSocket(SERVER_PORT);
            Socket clientSocket = listenSocket.accept();
            handler.invokeGotInvite(); // goes from notConnected to connecting

            //TODO: implement logic for going from connecting to not connected.
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            out.println("TRYING");
//            out.println("RINGING");
            out.println("OK");

            handler.invokeTryConnect(); // goes from connecting to wait ack

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String response = in.readLine();
            if(response.equals("ACK")) {
                handler.invokeGotAck(); // goes from wait ack to connected
                //TODO: implement audio shit.
                out.println("we are not connected, yo");


            }







        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
