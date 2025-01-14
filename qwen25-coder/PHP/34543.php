<?php\n$input = "Ticket number : 303905694, FOO:BAR:BAR: Some text\nCase ID:123,456,789:Foobar - Some other text\n303867970;[FOOBAR] Some text goes here\nCase Ref: 303658850 - Some random text here - host.tld #78854w";\n\n$lines = explode("\n", $input);\nforeach ($lines as $line) {\n    // Remove commas and spaces\n    $cleanedLine = str_replace([',', ' '], '', $line);\n\n    // Find the 9-digit number\n    if (preg_match("/\b(\d{9})\b/", $cleanedLine, $matches)) {\n        echo $matches[1] . "\n";\n    }\n}\n?>