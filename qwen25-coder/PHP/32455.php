<?php\n// Sample URL\n$url = 'http://www.google.com';\n\n// Set the DISPLAY environment variable\nputenv('DISPLAY=:0.0');\n\n// Run the script, escaping the URL for security\n$url_safe = escapeshellarg($url);\nshell_exec("sh script.sh $url_safe");\n\n// Output HTML to display image\necho '<img src="test.png" />';\n?>