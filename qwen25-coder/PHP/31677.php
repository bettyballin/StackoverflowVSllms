function test($var) {\n    if (!isset($_SESSION['myarray']) || !is_array($_SESSION['myarray'])) {\n        $_SESSION['myarray'] = [];\n    }\n\n    array_push($_SESSION['myarray'], $var);\n\n    // Keep only the last 10 elements\n    if (count($_SESSION['myarray']) > 10) {\n        array_shift($_SESSION['myarray']);\n    }\n}\n\ntest("hello");