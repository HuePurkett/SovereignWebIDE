/**
 * Created by cody on 23/03/16.
 */


//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/editor");
webSocket.onmessage = function (msg) { changeColor(msg); };
webSocket.onclose = function () { alert("WebSocket connection closed") };

//CodeMirror


var currentColor = "red";

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