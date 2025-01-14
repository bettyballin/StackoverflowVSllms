<?php\nclass Test {\n    function doAction() {\n        $this->doSubAction();\n    }\n\n    function doSubAction() {\n        if(true) {\n            throw new Exception('Custom error');\n        }\n    }\n}\n\ntry {\n    $var = new Test();\n    $var->doAction();\n} catch (Exception $e) {\n    echo '<strong>Warning:</strong> ' . $e->getMessage() . ' in <strong>' . $e->getFile() . '</strong> on line <strong>' . $e->getLine() . '</strong>';\n}\n?>