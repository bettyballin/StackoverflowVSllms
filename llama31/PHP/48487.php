function calculate($expression) {\n    $tokens = tokenise($expression);\n    $output = evaluateTokens($tokens);\n    return $output;\n}\n\nfunction tokenise($expression) {\n    $tokens = [];\n    $currentToken = '';\n    for ($i = 0; $i < strlen($expression); $i++) {\n        $char = $expression[$i];\n        if (in_array($char, ['+', '-', '*', '/'])) {\n            $tokens[] = $currentToken;\n            $tokens[] = $char;\n            $currentToken = '';\n        } else {\n            $currentToken .= $char;\n        }\n    }\n    $tokens[] = $currentToken;\n    return $tokens;\n}\n\nfunction evaluateTokens($tokens) {\n    $output = 0;\n    $operator = '+';\n    foreach ($tokens as $token) {\n        if (in_array($token, ['+', '-', '*', '/'])) {\n            $operator = $token;\n        } else {\n            $value = (float) $token;\n            switch ($operator) {\n                case '+':\n                    $output += $value;\n                    break;\n                case '-':\n                    $output -= $value;\n                    break;\n                case '*':\n                    $output *= $value;\n                    break;\n                case '/':\n                    $output /= $value;\n                    break;\n            }\n        }\n    }\n    return $output;\n}