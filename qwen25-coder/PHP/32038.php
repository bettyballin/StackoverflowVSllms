<?php\n$url = 'http://example.com/data.xml';\n\n$response = @file_get_contents($url);\n\nif ($response === FALSE) {\n    die('Error fetching data');\n} else {\n    // Process your XML response here\n    echo $response;\n}\n?>