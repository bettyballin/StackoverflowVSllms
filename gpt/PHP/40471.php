if (php_sapi_name() === 'cli' || defined('STDIN')) {\n    // Running from CLI\n    echo "Running from CLI";\n} else {\n    // Running from a web server\n    echo "Running from a web server";\n}