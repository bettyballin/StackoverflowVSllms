function testfunction() {\n    return 'ok';\n}\n\n// Call the function beforehand and store its result in a variable\n$result = testfunction();\n\n// Use the variable within the HEREDOC string\n$string = <<<heredoc\nplain text and now a function: {$result}\nheredoc;\n\necho $string;