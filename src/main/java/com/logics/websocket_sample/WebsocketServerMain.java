package com.logics.websocket_sample;

import org.glassfish.tyrus.server.Server;

import java.util.HashSet;
import java.util.Set;

/**
 * @author anju
 * @created on 28/01/25 and 8:19 PM
 */
public class WebsocketServerMain {
    public static void main(String[] args) {
        // Register our EchoEndpoint
        Set<Class<?>> endpoints = new HashSet<>();
        endpoints.add(WebSocketServerEndpointReceiver.class);

        // Create a Tyrus server listening on localhost:8025, context "/ws"
        Server server = new Server("localhost", 8025, "/ws", endpoints);

        try {
            server.start();
            System.out.println("WebSocket server started at ws://localhost:8025/ws/echo");
            // Keep server running until user presses any key
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
