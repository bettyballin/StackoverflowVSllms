class topclass {\n    function mode() {\n        $mode = 'functionName'; // No parentheses\n\n        $class = new extendclass;\n        $class->$mode(); // Call the method with parentheses here\n    }\n}\n\nclass extendclass {\n    function functionName() {\n        echo "Function called!";\n    }\n}\n\n// Example usage\n$top = new topclass();\n$top->mode();