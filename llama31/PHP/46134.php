if (!empty($_SERVER['HTTP_REFERER'])) {\n    header("Location: " . $_SERVER['HTTP_REFERER']);\n    exit();\n} else {\n    header("Location: " . $CFG->wwwroot);\n    exit();\n}