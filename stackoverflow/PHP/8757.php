echo preg_replace_callback('~-([a-z])~', function ($match) {\n    return strtoupper($match[1]);\n}, 'hello-world');\n// outputs helloWorld