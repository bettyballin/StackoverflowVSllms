class foo {\n    public static $bar = 'hi';\n}\n\n$class = 'foo';\necho $class::$bar; // This will not work in PHP 5.2.6\n\n// Instead, use the curly brace syntax\necho ${$class}::$bar; // Invalid in PHP 5.2.6\n\n// Correct way in PHP 5.2.6:\necho $$class::$bar; // Also invalid directly like this\n\n// Use variable variables with curly braces for PHP 5.2.6:\necho $class::${'bar'}; // This should work to access the static property\n\n// Alternatively, use constant syntax which also works in PHP 5.2.6\necho constant($class . "::" . 'bar');