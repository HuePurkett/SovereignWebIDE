/**
 * Created by cody on 23/03/16.
 */


//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/editor");
webSocket.onmessage = function (msg) { changeColor(msg); };
webSocket.onclose = function () { alert("WebSocket connection closed") };

//CodeMirror


var currentColor = "red";

var myCodeMirror = CodeMirror(document.anchors.namedItem("editor"), {
    value: "public class HelloWorld {\n\n\tpublic static void main(String[] args) {\n\t\t// Prints \"Hello, World\" to the terminal window.\n\t\tSystem.out.println(\"Hello, World\");\n\t}\n}",
    mode:  "text/x-java",
    lineNumbers: true,
    theme: "erlang-dark"
});

function changeColor(){
    if (currentColor == "red"){
        currentColor = "green";
    }
    else if(currentColor == "green"){
        currentColor = "red";
    }
    document.getElementById("colorButton").style.color = currentColor;
    webSocket.send(currentColor);
    alert(currentColor + " is the new color")
}