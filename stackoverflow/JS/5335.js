var url = "http://localhost/data.php";\nvar params = {\n  "SSN" : theSSN\n};\n$.get(url, params, function (){\n  // Do whatever you need here, once the data arrives.\n});