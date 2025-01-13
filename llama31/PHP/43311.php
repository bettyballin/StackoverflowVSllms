class TopClass {\n    function mode() {\n        $mode = 'functionName'; // assuming this is a valid method name\n\n        $class = new ExtendClass;\n        $allowedMethods = array('functionName', 'anotherFunctionName');\n\n        if (in_array($mode, $allowedMethods)) {\n            $class->{$mode}();\n        } else {\n            throw new Exception('Invalid method');\n        }\n    }\n}