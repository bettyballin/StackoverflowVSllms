jQuery(document).ready(function($) {\n    // Check for cookie\n    if (document.cookie.indexOf('splash_seen=true') === -1) {\n        $('#splash-overlay').fadeIn();\n        \n        $('#accept-button').click(function() {\n            document.cookie = 'splash_seen=true; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/';\n            $('#splash-overlay').fadeOut();\n        });\n\n        $('#leave-button').click(function() {\n            window.location.href = "http://www.example.com/"; // Redirect to another page\n        });\n    }\n});