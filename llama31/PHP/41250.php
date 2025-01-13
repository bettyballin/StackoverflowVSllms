<?php\n\n// Include_once test\n$start = microtime(true);\ninclude_once 'large_class_library.php';\n$end = microtime(true);\necho "Include_once: " . ($end - $start) . " seconds\n";\n\n// Require_once test\n$start = microtime(true);\nrequire_once 'large_class_library.php';\n$end = microtime(true);\necho "Require_once: " . ($end - $start) . " seconds\n";\n\n?>