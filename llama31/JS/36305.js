$('a').on('click', function(event) {\n     event.preventDefault();\n     var href = $(this).attr('href');\n     $.get(href, function(data) {\n       // Replace the page content with the new content\n       $('#content').html(data);\n       // Update the URL hash\n       window.location.hash = href;\n     });\n   });