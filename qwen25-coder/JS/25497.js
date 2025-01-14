$(document).ready(function() {\n     function loadSection(url, targetId) {\n       $(targetId).html('Loading...'); // Show loading message\n       $.ajax({\n         url: url,\n         type: 'get',\n         dataType: 'script', // Use script if returning JS or JSON if only data\n         success: function(data) {\n           console.log("Data loaded successfully");\n         },\n         error: function() {\n           $(targetId).html('Error loading content.');\n           console.error("Failed to load content.");\n         }\n       });\n     }\n\n     // Load different sections\n     loadSection('/content/section_one', '#section-one');\n     loadSection('/content/section_two', '#section-two');\n     // Add more for other sections...\n   });