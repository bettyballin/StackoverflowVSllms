var data = [1, 2, 3, 4, 5]; // your JavaScript array\n\n// Convert the array to a JSON string\nvar jsonData = JSON.stringify(data);\n\n// URL-encode the JSON string\nvar encodedData = encodeURIComponent(jsonData);\n\n// Send the encoded data to your PHP script using GET\ndocument.location = 'result.php?result=' + encodedData;