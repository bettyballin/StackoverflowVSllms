<?php\n$domains = ["example.com", "test.com", "sample.com", "otherdomain.com"];\n$x = "test.com"; // This is the domain you want to exclude\n\nforeach ($domains as $domain) {\n    if ($domain !== $x) {\n        echo $domain . "\n";\n    }\n}\n?>