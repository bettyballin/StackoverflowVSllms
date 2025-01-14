function checkOrThrow($value, $exceptionMessage) {\n    if (!$value) {\n        throw new Exception($exceptionMessage);\n    }\n}\n\ntry {\n    $foo = bar();\n    checkOrThrow($foo, 'Problems with bar()');\n    \n    $aa = bb($foo);\n    checkOrThrow($aa, 'Problems with bb()');\n\n    // ...and so on!\n} catch (Exception $e) {\n    echo $e->getMessage();\n}