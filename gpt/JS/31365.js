// your_script.js\nfunction fetchAndRender() {\n    $.ajax({\n        url: 'your-url/',\n        type: 'GET',\n        success: function(data) {\n            $('#your-container').html(data.html);\n        },\n        error: function(error) {\n            console.log("Error:", error);\n        }\n    });\n}