$example = "Hello, ";\n\n$closure = function($name) use ($example) {\n    return $example . $name;\n};\n\necho $closure("World!");  // Output: Hello, World!