if (PHP_SAPI == "cli" || PHP_SAPI == "cli-server") {\n    // Running from command line\n    echo "Running from command line\n";\n} else {\n    // Running from HTTP\n    echo "Running from HTTP\n";\n}