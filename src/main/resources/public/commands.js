/**
 * Created by cody on 04/04/16.
 */

// The link below explains WebSocket Client Applications.
// https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_WebSocket_client_applications

//Establish the WebSocket connection and set up event handlers
var webSocketCommands = new WebSocket("ws://" + location.hostname + ":" + location.port + "/commands");
// webSocketCommands.onmessage = function (msg) { saveFile(msg); };
webSocketCommands.onclose = function () { alert("WebSocket connection closed") };


//Update the chat-panel, and the list of connected users
function saveFile() {
    webSocketCommands.send("save");
    console.log("Save file function called!");
}

function openFile() {
    webSocket.send("open");
    console.log("Open file function called");
}