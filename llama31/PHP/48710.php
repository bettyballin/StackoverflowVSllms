$exception = new Dog_Exception();\nif ($exception) {\n    echo "This will not be executed";\n} else {\n    echo "This will be executed";\n}