function display(event, fid) {\n    // Stop the default action of the link click\n    Event.stop(event);\n\n    // Perform your Ajax request here using Prototype\n    new Ajax.Request('my.php?action=show&id=' + fid, {\n        method: 'get',\n        onSuccess: function(response) {\n            // Handle the response from the server\n            console.log(response.responseText);\n        }\n    });\n\n    return false;\n}