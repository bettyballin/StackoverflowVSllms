<?php\n$url = 'http://www.test.com/foo.xml';\n\n// Ensure that URL fopen wrappers are enabled\nif (ini_get('allow_url_fopen')) {\n    $xmlContent = file_get_contents($url);\n    if ($xmlContent === FALSE) {\n        echo "Failed to retrieve content.";\n    } else {\n        echo $xmlContent;\n    }\n} else {\n    echo "URL fopen wrappers are disabled in your PHP configuration.";\n}\n?>