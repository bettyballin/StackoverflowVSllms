$.ajax({\n  type: 'GET',\n  url: 'stack.php',\n  success: function(data) {\n    var storedStack = JSON.parse(data);\n    // Use the stored stack values\n  }\n});