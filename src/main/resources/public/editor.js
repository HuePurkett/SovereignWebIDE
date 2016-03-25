/**
 * Created by cody on 23/03/16.
 */


//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/editor");
webSocket.onmessage = function (msg) { updateEditor(msg); };
webSocket.onclose = function () { alert("WebSocket connection closed") };

//CodeMirror


var currentColor = "red";

var myCodeMirror = CodeMirror(document.anchors.namedItem("editor"), {
    value: "public class HelloWorld {\n\n\tpublic static void main(String[] args) {\n\t\t// Prints \"Hello, World\" to the terminal window.\n\t\tSystem.out.println(\"Hello, World\");\n\t}\n}",
    mode:  "text/x-java",
    lineNumbers: true,
    theme: "erlang-dark"
});

myCodeMirror.on("change", function(myCodeMirror, changeObj){
    var code = myCodeMirror.getValue();
    console.log(code);
    webSocket.send(code);
    updated_code = updateEditor(code);
    if(updated_code != code){
        myCodeMirror.setValue(updated_code);
    }
    else {
        console.log("No code to update!")
    }

});



//Update the chat-panel, and the list of connected users
function updateEditor(msg, myCodeMirror) {
    var data = msg;
    webSocket.send(msg);
    //myCodeMirror.setValue(msg);
    console.log(msg + "updateEditor");
    return msg;
}

//Helper function for inserting HTML as the first child of an element
function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("afterbegin", message);
}

//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}