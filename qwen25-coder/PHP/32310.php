<?php\n$filePath = '/document_root/myfile.pdf';\n\nif (file_exists($filePath)) {\n    $lastModifiedTime = filemtime($filePath);\n    echo "Last modified time: " . date('Y-m-d H:i:s', $lastModifiedTime) . "\n";\n} else {\n    echo "File does not exist.\n";\n}\n?>