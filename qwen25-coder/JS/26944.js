// Example using jQuery\n$('#documentLink').click(function(e) {\n    e.preventDefault();\n    var file = 'example.pdf'; // This should be dynamically set based on the uploaded file name\n    window.location.href = '/getFile.php?file=' + encodeURIComponent(file);\n});