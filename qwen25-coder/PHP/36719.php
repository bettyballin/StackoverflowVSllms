$fileContent = @file_get_contents("http://www.address.com");\n\nif ($fileContent === FALSE) {\n    $results = "it didn't work";\n} else {\n    $results = "it worked";\n}\n\nreturn $results;