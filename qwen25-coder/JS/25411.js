function makeAjaxCall() {\n       YourWebNamespace.YourWebServiceMethod(\n           function(result) { \n               // Handle successful response here.\n               console.log('Success: ', result); \n           },\n           function(error) {\n               if (error.get_statusCode() === 401) {\n                   // Session has expired, redirect to login page\n                   window.location.href = '/Login.aspx';\n               } else {\n                   // Handle other errors\n                   console.error('Error:', error);\n               }\n           }\n       );\n   }