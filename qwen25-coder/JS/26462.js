document.addEventListener("DOMContentLoaded", function() {\n    var now = new Date().getTime();\n    document.getElementById('passwordField').setAttribute('name', 'password' + now);\n});