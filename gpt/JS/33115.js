$("#test2").click(function() {\n    $.getJSON("index.html", function(response) {\n        console.log(response); // Check the response in the console\n        alert('hi'); //won't work if response is not valid JSON\n    }).fail(function(jqxhr, textStatus, error) {\n        console.log("Request Failed: " + textStatus + ", " + error);\n    });\n});