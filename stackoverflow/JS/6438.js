$("#loadImage").show();\n $("#MyDiv").load("page.php", {limit: 25}, function(){\n   $("#loadImage").hide();\n });