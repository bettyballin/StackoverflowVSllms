function makewindows(){\n  child1 = window.open("about:blank");\n  $.ajax({\n    url: 'makewindows.php',\n    success: function(data) {\n      child1.document.write(data);\n      child1.document.close();\n    }\n  });\n}