function someFunction($in_param1) {\n    return "SUCCESS";\n}\n\ntry {\n    $function = 'someFunction';\n    \n    // Check if the function exists before calling it.\n    if (is_callable($function)) {\n        // Get the number of parameters expected by the function.\n        $reflection = new ReflectionFunction($function);\n        $expectedParamsCount = $reflection->getNumberOfParameters();\n        \n        // If no arguments are passed, handle accordingly.\n        if ($expectedParamsCount != 0) {\n            throw new Exception("Expected {$expectedParamsCount} parameter(s), but none given.");\n        }\n        \n        // Call the function dynamically with any number of parameters.\n        $x = call_user_func($function); \n    } else {\n        throw new Exception("Function '{$function}' is not callable.");\n    }\n\n    echo $x;\n} catch (Exception $e) {\n    die("Error: " . $e->getMessage());\n}