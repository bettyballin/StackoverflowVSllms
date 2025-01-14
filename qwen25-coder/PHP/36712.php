<?php\n\nfunction scan_code_for_unused_functions($filePath) {\n    $sourceCode = file_get_contents($filePath);\n    $tokens = token_get_all($sourceCode);\n\n    $functions = [];\n    $unusedFunctions = [];\n\n    foreach ($tokens as $index => &$token) {\n        if (is_array($token)) {\n            if ($token[0] === T_FUNCTION) {\n                // Assume the next non-whitespace token is the function name\n                for ($i = $index + 1; ; $i++) {\n                    if (!isset($tokens[$i])) continue;\n                    $funcNameToken = &$tokens[$i];\n                    if (is_array($funcNameToken) && $funcNameToken[0] === T_STRING) {\n                        $functions[] = $funcNameToken[1];\n                        break;\n                    }\n                }\n            } elseif ($token[0] === T_STRING) {\n                // Check for function calls (very basic, not considering scope resolution or object methods)\n                $name = $token[1];\n                if (!in_array($name, $functions)) continue;\n\n                $unusedFunctions[$name]--;\n            }\n        }\n\n        unset($token);\n    }\n\n    return array_filter($functions, function ($fn) use ($unusedFunctions) {\n        return !isset($unusedFunctions[$fn]) || $unusedFunctions[$fn] == 0;\n    });\n}\n\n// Usage example\n$filePath = 'your_php_file.php';\nprint_r(scan_code_for_unused_functions($filePath));\n\n?>