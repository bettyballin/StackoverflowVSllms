$.ajax({\n    type: "GET",\n    url: "smpl.php",\n    success: function(servmsg){\n        $('#panelInfo').replaceWith('<p>' + servmsg + '</p>');\n    }\n});\n\n// Bind the event using event delegation\n$(document).on('change', '#years', function() {\n    // do something\n    console.log("Year changed!");\n});