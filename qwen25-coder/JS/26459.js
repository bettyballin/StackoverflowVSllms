$.ajax({\n  type: "POST",\n  url: "/proxy", // Point to your local proxy server\n  data: dataString,\n  success: function(response) {\n    $('#contact_form').html("<div id=\"message\"></div>");\n    $('#message').html("<h2>Contact Form Submitted!</h2>")\n      .append("<p>We will be in touch soon.</p>")\n      .hide();\n  }\n});