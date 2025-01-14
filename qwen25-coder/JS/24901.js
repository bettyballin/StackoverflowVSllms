// Example of making an AJAX request using jQuery in an ASP.NET MVC application\n$(document).ready(function() {\n    $.ajax({\n        url: '/ControllerName/ActionMethod',\n        type: 'GET',\n        dataType: 'json',\n        success: function(data) {\n            // Handle the response from the server\n            console.log(data);\n        },\n        error: function(xhr, status, error) {\n            // Handle any errors\n            console.error(error);\n        }\n    });\n});