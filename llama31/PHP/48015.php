function foo () {\n    echo "Inside foo()";\n}\n\nfunction bar () {\n    echo "Inside bar()";\n}\n\n$functionName = "foo";\ncall_user_func($functionName); // Outputs: Inside foo()