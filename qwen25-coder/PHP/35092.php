// First, install Symfony Expression Language via Composer:\n// composer require symfony/expression-language\n\nuse Symfony\Component\ExpressionLanguage\ExpressionLanguage;\n\nfunction calculator($str) {\n    $expressionLanguage = new ExpressionLanguage();\n    \n    // Define allowed functions and variables if needed.\n    $allowedFunctions = [];\n    $variables = [];\n\n    try {\n        return $expressionLanguage->evaluate($str, $variables);\n    } catch (\Symfony\Component\ExpressionLanguage\SyntaxError $e) {\n        // Handle syntax errors\n        echo "Syntax error: " . $e->getMessage();\n        return null;\n    }\n}\n\n// Example usage:\n$result = calculator('1 + 2 * (3 / 4)');\necho "Result: " . $result;