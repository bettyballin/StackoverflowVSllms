function foo() {\n    // code here\n    echo "foo called";\n}\n\nfunction bar() {\n    // code here\n    echo "bar called";\n}\n\n$functionName = "foo";\n\n// Call the function based on the value of $functionName\nif (function_exists($functionName)) {\n    $functionName();\n} else {\n    echo "Function does not exist.";\n}