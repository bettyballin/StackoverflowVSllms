define('DEBUG', true);\n\n// ...\n\n$returnedStr = $this->SomeFoo();\n\nif (DEBUG) {\n    error_log("returned string = $returnedStr");\n}