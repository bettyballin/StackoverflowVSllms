// JavaScript code\nwindow.onbeforeunload = function() {\n    // Make an AJAX request to log out the user\n    var xhr = new XMLHttpRequest();\n    xhr.open('GET', '/logout.php', true);\n    xhr.send();\n};