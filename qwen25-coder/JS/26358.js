document.addEventListener("DOMContentLoaded", function() {\n    var marquees = document.getElementsByTagName('marquee');\n    for (var i = 0; i < marquees.length; i++) {\n        // Convert marquee content to static text\n        marquees[i].outerHTML = '<span>' + marquees[i].innerHTML + '</span>';\n    }\n});