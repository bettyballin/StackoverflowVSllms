<?php\n    $var = NULL;\n\n    // Check if a variable has been initialized globally\n    var_dump(array_key_exists('var', $GLOBALS)); // bool(true)\n    var_dump(array_key_exists('unset_var', $GLOBALS)); // bool(false)\n\n    function checkVariableInitialization() {\n        $localVar = NULL;\n        \n        // For local variables within a function, use array_key_exists with get_defined_vars()\n        var_dump(array_key_exists('localVar', get_defined_vars())); // bool(true)\n        var_dump(array_key_exists('unsetLocalVar', get_defined_vars())); // bool(false)\n    }\n\n    checkVariableInitialization();\n?>