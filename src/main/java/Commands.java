import org.eclipse.jetty.websocket.api.Session;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by cody on 04/04/16.
 */
public class Commands {


    public static void main() {
        webSocket("/commands", CommandsHandler.class);
    }

    public static void save_file() {
        // List<String> lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
        // lines.add("print('foobar');");
        FileWriter("fileName");
    }

}
