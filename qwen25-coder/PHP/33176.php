<?php\n$url = "http://example.com/signal"; // Replace with your target URL\n\n$response = file_get_contents($url);\n\nif ($response === FALSE) {\n    die('Error loading data');\n}\n\necho 'Page hit signal sent!';\n?>