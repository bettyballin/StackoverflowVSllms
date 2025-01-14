<?php\n\n$dir = 'classes/';\nif (is_dir($dir)) {\n    if ($dh = opendir($dir)) {\n        while (($file = readdir($dh)) !== false) {\n            // Check for PHP files only and skip the current and parent directory references\n            if (pathinfo($file, PATHINFO_EXTENSION) === 'php' && $file != '.' && $file != '..') {\n                include($dir . $file);\n            }\n        }\n        closedir($dh);\n    }\n}