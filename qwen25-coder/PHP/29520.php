<?php\n$string = "user@domain.com MIME-Version: bla bla bla";\nif (preg_match('/[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}/', $string, $matches)) {\n    echo $matches[0];\n} else {\n    echo "No email found.";\n}\n?>