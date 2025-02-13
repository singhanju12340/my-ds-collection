package com.tekion.aec.cp.imsjobs.controller.websocket_sample;


import javax.websocket.*;
import java.net.URI;
import java.util.Scanner;

/**
 * @author anju
 * @created on 28/01/25 and 11:01 PM
 */

@ClientEndpoint
public class WebSocketClient {

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received from server---> " + message);
    }

    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8025/ws/echo";

        try {
            // Connect to the server
            Session session = container.connectToServer(WebSocketClient.class, URI.create(uri));

            // Send a test message

            Scanner sc = new Scanner(System.in);
            String inputMessage;
            do{
                 inputMessage = sc.nextLine();
                session.getBasicRemote().sendText(inputMessage);
                Thread.sleep(2000);

            }while (!inputMessage.equals("close"));

            System.out.println("chat finished");
            // Wait briefly to receive echo

            // Close the session
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
