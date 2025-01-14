<?php\n// IncludeScript.php\n$validScripts = array('jquery', 'plugin1', 'plugin2', 'plugin3', 'plugin4'); // List of valid scripts\n\nheader("Content-type: text/javascript");\nheader("Cache-Control: public, max-age=86400"); // Cache for 1 day (you can adjust as needed)\n\n$requestedScripts = isset($_GET['scripts']) ? explode(',', $_GET['scripts']) : array();\n\nforeach ($requestedScripts as $script) {\n    if (in_array($script, $validScripts)) {\n        echo file_get_contents("path/to/scripts/$script.js");\n        echo "\n"; // Ensures scripts are not combined into one line\n    }\n}\n?>