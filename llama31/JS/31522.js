setInterval(function() {\n  $.ajax({\n    type: 'GET',\n    url: 'check_session.php',\n    success: function(data) {\n      if (data === 'true') {\n        // Session variable has been set, proceed with the next step\n      }\n    }\n  });\n}, 3000); // Poll every 3 seconds