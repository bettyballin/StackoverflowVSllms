$(document).ready(function(){\n  $("#comment_form").ajaxForm({\n    dataType: 'js', // Ensure the response is treated as JavaScript\n    success: function(data){\n      eval(data); // Evaluate the returned JavaScript code\n    }\n  });\n});