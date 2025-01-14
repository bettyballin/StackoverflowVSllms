// index.php\ninclude_once('config.inc.php');\ninclude_once('lib/common.php');\n\nfunction doSomething() {\n    // Access function with dependencies\n    someFunction(getConfig());\n}\n\ndoSomething();\n\n// lib/common.php\nfunction getConfig() {\n    global $config; // Assuming config is an array defined in config.inc.php\n    return $config;\n}\n\nfunction someFunction($config) {\n    echo "Database Name: " . $config['dbname'];\n}