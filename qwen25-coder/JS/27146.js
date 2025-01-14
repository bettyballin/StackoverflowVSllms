$(document).ready(function() {\n       $("#CreateLog").validate({\n           rules: {           \n               UserName: {\n                   required: true,\n                   minLength: 2,\n               }\n           },\n           messages: {\n\n               UserName: {\n                   required: "Please enter a username",\n                   minLength: "Your username must consist of at least 2 characters",\n\n               }\n           },\n           errorLabelContainer: $("#errorSummary"), // Container for the summary\n           wrapper: '<li></li>',  // wraps each error message in a <li> tag\n           errorPlacement: function(error, element) {\n               error.appendTo("#errorSummary"); // Add all errors to this container\n           }\n       });\n   });