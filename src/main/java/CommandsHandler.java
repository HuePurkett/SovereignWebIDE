import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by cody on 04/04/16.
 */

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

@WebSocket
public class CommandsHandler {


    private int NumberOfUsers = 0;
    private String msg;

    @OnWebSocketMessage
    public void onMessage(String message) {
        System.out.print("Commands Handler execution!: " + message + "\n");
        if(message == "yes") {
            Commands.save_file();
            System.out.print("Saving File!\n");
        }
    }
}


