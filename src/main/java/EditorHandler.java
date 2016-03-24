/**
 * Created by cody on 23/03/16.
 */

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;


@WebSocket
public class EditorHandler {
    private String currentColor;

    @OnWebSocketMessage
    public void onMessage(String message) {
        Editor.changeColor(Editor.currentColor = message);
        System.out.print("handler execution! New Color: " + message + "\n");
    }
}




