function testfunction() {\n    return 'ok';\n}\n\n$string = <<<HEREDOC\nplain text and now a function: {testfunction()}\nHEREDOC;\n\necho $string;