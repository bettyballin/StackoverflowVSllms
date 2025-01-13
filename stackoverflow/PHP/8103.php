class CI_Parser {\n    var $varCallback;\n    function setVarCallback($callbackFunction) {\n        $this->varCallback = $callbackFunction;\n    }\n    ...\n    function _parse_single(...) {\n        $callback = $this->varCallback;\n        $callback($key);\n    }\n...\n\n//Somewhere in your code\nfunction storeVarName($variableName) {\n    // Persist the variable name wherever you want here\n}\n$this->parser->setVarCallback('storeVarName');