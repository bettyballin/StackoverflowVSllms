var countries = ['ga', 'cd']; // Use array literal for cleaner code\nvar jsonString = JSON.stringify({ countries: countries });\n\n$.ajax({\n    type: "POST",\n    url: "Concessions.aspx/GetConcessions",\n    data: jsonString, // Pass the serialized string\n    contentType: "application/json; charset=utf-8", // Set the content type to JSON\n    dataType: "json", // Expect JSON response\n    success: function(response) {\n        console.log(response);\n    },\n    error: function(xhr, status, error) {\n        console.error(error);\n    }\n});