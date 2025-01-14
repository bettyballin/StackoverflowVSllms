$(function () {\n    // Reference the auto-generated proxy created by SignalR.\n    var notificationHub = $.connection.notificationHub;\n\n    // Create a function that the hub can call back to display messages.\n    notificationHub.client.receiveNotification = function (message) {\n        alert(message);\n        // Or update UI, e.g., change color of your link\n        $('#messagesLink').css('color', 'red');\n    };\n\n    // Connect to the SignalR server.\n    $.connection.hub.start().done(function () {\n        console.log("Connected to notification hub.");\n    });\n});