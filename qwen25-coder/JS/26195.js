// Add this script at the end of your body or in a separate JS file included after loading the document\nwindow.onload = function() {\n    var links = document.getElementsByTagName('a');\n    for (var i = 0; i < links.length; i++) {\n        links[i].target = 'rightFrame';\n    }\n};