$.ajax({\n    type: "GET",\n    url: "smpl.php",\n    success: function(servmsg) {\n        $('#panelInfo').replaceWith('<p>' + servmsg + '</p>');\n        // Attach the event handler after the content is replaced\n        $('#years').on('change', function() {\n            // Do something\n            console.log("Year changed");\n        });\n    }\n});