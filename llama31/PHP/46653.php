/**\n * @throws Exception\n */\nfunction myFunction() {\n    // code that might throw an exception\n}\n\nset_error_handler('checkExceptions');\n\nfunction checkExceptions($errno, $errstr, $errfile, $errline) {\n    $backtrace = debug_backtrace();\n    $function = $backtrace[1]['function'];\n    $docComment = getDocComment($function);\n    $throws = getThrowsFromDocComment($docComment);\n    if ($throws && !hasTryCatchBlock($backtrace)) {\n        trigger_error("Missing try-catch block for $function", E_USER_WARNING);\n    }\n}\n\nfunction getDocComment($function) {\n    $reflection = new ReflectionFunction($function);\n    return $reflection->getDocComment();\n}\n\nfunction getThrowsFromDocComment($docComment) {\n    $throws = array();\n    preg_match_all('/@throws (.*)/', $docComment, $throws);\n    return $throws[1];\n}\n\nfunction hasTryCatchBlock($backtrace) {\n    foreach ($backtrace as $frame) {\n        if (isset($frame['file']) && strpos(file_get_contents($frame['file']), 'try {') !== false) {\n            return true;\n        }\n    }\n    return false;\n}