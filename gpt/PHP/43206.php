<?php\n// Start output buffering\nob_start();\n\n// Use var_dump to output the variable\nvar_dump($yourVariable);\n\n// Get the contents of the output buffer\n$varDumpOutput = ob_get_clean();\n\n// Now $varDumpOutput contains the string output of var_dump\necho $varDumpOutput;\n?>