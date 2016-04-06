import org.eclipse.jetty.websocket.api.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        try {
            //Path newFilePath = Paths.get("Test.txt");
            //Files.createFile(newFilePath);

            List<String> lines = Files.readAllLines(Paths.get("Test.txt"));
            lines.add("print('foobar');");
            Files.write(Paths.get("Test.txt"), lines);

            System.out.print("Writing string to file....\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
