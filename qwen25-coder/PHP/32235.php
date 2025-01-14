<?php\n$url = "http://source.com/file.mp3";\n$headers = get_headers($url, 1);\n\nif (isset($headers['Last-Modified'])) {\n    $lastModified = strtotime($headers['Last-Modified']);\n    echo "Last Modified: " . date('Y-m-d H:i:s', $lastModified);\n} else {\n    echo "Could not get Last-Modified header.";\n}\n?>