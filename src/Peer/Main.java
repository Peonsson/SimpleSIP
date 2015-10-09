package Peer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Created by Peonsson & roppe546 on 2015-10-08 16:18.
 */

public class Main {

    public static void main(String[] args) {
        new ClientHandler().start();
        new StateHandler();
    }

    private static class ClientHandler extends Thread {

        @Override
        public void run() {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
        }
    }
}