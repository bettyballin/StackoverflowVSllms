function testfunction() {\n    return 'ok';\n}\n\n$string = <<<HEREDOC\nplain text and now a function: \nHEREDOC;\n$string .= testfunction();\n\necho $string;