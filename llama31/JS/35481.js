$(document).ready(function(){\n    $(".editme1").editInPlace({\n        url: "http://www.mysite.com/update.php",\n        params: "ajax=yes",\n        callback: function(unused, enteredText) {\n            // Update the element's text with the new value\n            $(this).text(enteredText);\n        }\n    });\n});