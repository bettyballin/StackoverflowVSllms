$("#mydiv").load("filter.html", function() {\n  $('#filterdiv input').focus(function(){\n    alert("Hello");\n  });\n});