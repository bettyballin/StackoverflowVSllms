$("#mydiv").load("filter.html", function() {\n    // Now the content of "filter.html" has been loaded into "#mydiv"\n    $('#filterdiv input').focus(function(){\n        alert('Hello');\n    });\n});