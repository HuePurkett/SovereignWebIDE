/**
 * Created by cody on 23/03/16.
 */

import org.eclipse.jetty.websocket.api.*;
import static spark.Spark.*;

public class Editor {
    static String currentColor = "blue";

    public static void main(String[] args) {
        staticFileLocation("public"); //index.html is served at localhost:4567 (default port)
        webSocket("/editor", EditorHandler.class);
        init();
    }

    public static void changeColor(String newColor){
        currentColor = newColor;
        System.out.print("changeColor method executed! New Color: " + newColor + "\n");
    }
}
