<?php\n$domains = ["example.com", "test.com", "mydomain.com", "anotherexample.com"];\n$x = "test";\n\nforeach ($domains as $domain) {\n    if (strpos($domain, $x) === false) {\n        echo $domain . "\n";\n    }\n}\n?>