import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by cody on 04/04/16.
 */

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
    public void onSave(String file_name) throws IOException {
        // System.out.print("Commands Handler execution!: " + message + "\n");
        String[] decoded_command = SplitString.get_command(file_name);
        if(decoded_command[0].equals("save")) {
            Commands.save_file(decoded_command[1]);
        }
        else if (decoded_command[0].equals("open")) {
            System.out.println("Handler:Open\n");
            List<String> lines = Files.readAllLines(Paths.get(decoded_command[1]));


            String file_as_str = "";
            for (String s : lines) {
                file_as_str += s + "\n";
            }
            Editor.file = file_as_str;
            Editor.updateEditors("User 3333", file_as_str);
            System.out.println("Handler:Open:file: "+file_as_str);
        }
    }
}


