// Example of how you might be making the AJAX request\n$.ajax({\n  type: 'PUT',\n  url: '/path/to/php/file', // is this path correct?\n  data: { /* your data */ },\n  success: function(response) {\n    console.log(response);\n  },\n  error: function(xhr, status, error) {\n    console.log(xhr.responseText);\n  }\n});