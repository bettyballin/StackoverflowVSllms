document.addEventListener("DOMContentLoaded", function() {\n    var links = document.querySelectorAll('a');\n    links.forEach(function(link) {\n        link.setAttribute('target', '_blank');\n    });\n});