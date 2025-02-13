package com.tekion.aec.cp.imsjobs.controller.websocket_sample;



import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 * @author anju
 * @created on 28/01/25 and 7:45 PM
 */

@ServerEndpoint(value = "/echo")
public class WebSocketServerEndpointReceiver {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println("Received: " + message);
        // Echo the message
        session.getBasicRemote().sendText("Server has accepted message : " + message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected: " + session.getId());
    }

}
