$file = 'path/to/your/library.php';\nif (!defined('LIBRARY_INCLUDED')) {\n    define('LIBRARY_INCLUDED', true);\n    include_once $file;\n} \n\n// Similarly for require_once with a different constant or method to track inclusions