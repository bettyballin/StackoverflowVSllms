<?php\n$url = "https://stackoverflow.com/questions/ask";\n$html = file_get_contents($url);\n\nif ($html !== false) {\n    // Successfully retrieved the HTML\n    echo $html;\n} else {\n    // Handle the error\n    echo "Failed to retrieve the HTML.";\n}\n?>