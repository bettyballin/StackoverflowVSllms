// Assuming you have an element with the ID 'button'\ndocument.getElementById('button').addEventListener('click', function() {\n  // Create a new XMLHttpRequest object\n  var xhr = new XMLHttpRequest();\n\n  // Set the request method and URL\n  xhr.open('GET', '/your/rails/endpoint', true);\n\n  // Set the callback function for when the request is complete\n  xhr.onload = function() {\n    if (xhr.status === 200) {\n      // Update your webpage with the response data\n      console.log(xhr.responseText);\n    }\n  };\n\n  // Send the request\n  xhr.send();\n});