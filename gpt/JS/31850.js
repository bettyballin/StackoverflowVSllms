$(function () {\n        // Reference the auto-generated proxy for the hub\n        var milesHub = $.connection.milesHub;\n\n        // Create a function that the hub can call to broadcast messages\n        milesHub.client.updateMiles = function (totalMiles) {\n            $('#totalMiles').text(totalMiles);\n        };\n\n        // Start the connection\n        $.connection.hub.start().done(function () {\n            console.log('SignalR connected');\n        });\n    });