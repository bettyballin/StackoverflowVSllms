function doSubAction() {\n    if (true) {\n        throw new Exception('Custom error');\n    }\n}\n\ntry {\n    $var->doAction();\n} catch (Exception $e) {\n    trigger_error("Custom error on line " . $e->getLine(), E_USER_WARNING);\n}