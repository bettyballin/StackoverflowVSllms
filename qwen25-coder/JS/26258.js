// Example of using AJAX with jQuery to fetch data from database via REST API\n          $(document).ready(function() {\n              $.ajax({\n                  url: "/api/data",\n                  success: function(data) {\n                      console.log(data);\n                      // Process response and update UI accordingly\n                  }\n              });\n          });