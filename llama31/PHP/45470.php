$path = 'Mail.php';\n$pearDir = 'path/to/pear'; // replace with your PEAR directory\n\n$realPath = realpath($pearDir . '/' . $path);\nif ($realPath) {\n    require_once $realPath;\n} else {\n    // handle file not found error\n}