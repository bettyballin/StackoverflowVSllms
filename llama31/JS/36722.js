setInterval(function() {\n  $.ajax({\n    type: "GET",\n    url: "/update-data",\n    success: function(data) {\n      // Update specific sections of the page with new data\n      $("#updated-section").html(data);\n    }\n  });\n}, 5000); // Poll every 5 seconds