import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by cody on 04/04/16.
 */

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

/**
 * Sets up a webSocket handler for the 'commands' webSocket. These methods are accessible
 * form the client, and the server.
 */
@WebSocket
public class CommandsHandler {

    private int NumberOfUsers = 0;
    private String msg;


    /**
     * Calls the save_file function in Commands.java.
     * @param file_name - The name of the file to be saved.
     */
    @OnWebSocketMessage
    public void onSave(String file_name) {
        // System.out.print("Commands Handler execution!: " + message + "\n");
        Commands.save_file(file_name);
    }
}


