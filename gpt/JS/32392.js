// For login\n$.ajax({\n    url: '/ajax/login',\n    type: 'POST',\n    data: { username: 'user', password: 'pass' },\n    success: function(response) {\n        console.log(response);\n    }\n});\n\n// For edit profile\n$.ajax({\n    url: '/ajax/editprofile',\n    type: 'POST',\n    data: { name: 'John Doe', email: 'john.doe@example.com' },\n    success: function(response) {\n        console.log(response);\n    }\n});