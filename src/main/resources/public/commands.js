/**
 * Created by cody on 04/04/16.
 */
/**
 * Created by cody on 23/03/16.
 */


//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/commands");
webSocket.onmessage = function (msg) { updateEditor(msg); };
webSocket.onclose = function () { alert("WebSocket connection closed") };


//Update the chat-panel, and the list of connected users
function saveFile() {
    webSocket.send("yes");
}
