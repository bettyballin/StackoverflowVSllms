function setEditMode() {\n    // Using jQuery to make an AJAX call to the server\n    $.ajax({\n        url: 'SetSession.aspx/SetSessionVariable', // Your server-side method URL\n        type: 'POST',\n        dataType: 'json',\n        contentType: "application/json",\n        data: JSON.stringify({ key: "EditMode", value: "Edit" }),\n        success: function () {\n            window.location.href = 'EventDetails.aspx?EventID=yourEventID'; // Redirect after setting the session variable\n        },\n        error: function (error) {\n            console.error('Error:', error);\n        }\n    });\n}