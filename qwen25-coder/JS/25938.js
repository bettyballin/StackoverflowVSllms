$.ajax({\n    url: 'your_php_script.php', // URL to your PHP script\n    type: 'POST',\n    dataType: 'json', // Expect JSON response\n    success: function(response) {\n        // Assuming 'response' is an array of objects (rows)\n        $.each(response, function(index, row) {\n            // Access each field of the row object\n            var id = row.id;\n            var title = row.title;\n\n            // Do something with these values, e.g., display them\n            console.log('ID: ' + id + ', Title: ' + title);\n        });\n    },\n    error: function(error) {\n        console.error('Error fetching data:', error);\n    }\n});