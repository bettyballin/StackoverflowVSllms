$files = scandir('/path/to/your/project');\n$functions = array();\n$functionCalls = array();\n\nforeach ($files as $file) {\n    if (is_file($file) && pathinfo($file, PATHINFO_EXTENSION) == 'php') {\n        $tokens = token_get_all(file_get_contents($file));\n\n        foreach ($tokens as $token) {\n            if ($token[0] == T_FUNCTION) {\n                $functions[] = $token[1];\n            } elseif ($token[0] == T_STRING && in_array($token[1], $functions)) {\n                $functionCalls[] = $token[1];\n            }\n        }\n    }\n}\n\n$unusedFunctions = array_diff($functions, $functionCalls);\nprint_r($unusedFunctions);