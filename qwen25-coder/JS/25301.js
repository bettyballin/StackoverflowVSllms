$.ajax({\n    type: "GET",\n    dataType: "json",\n    url: "http://www.example.com/ajax.php",\n    data: { id: 5 },\n    success: function(data) {\n        console.log(data);\n    },\n    error: function(xhr, status, error) {\n        console.error("Error fetching data: " + error);\n    }\n});