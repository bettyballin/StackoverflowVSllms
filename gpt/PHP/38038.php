<?php\n// Define some variables\n$foo = "bar";\n$baz = 123;\n\n// Get all defined variables\n$all_vars = get_defined_vars();\n\n// Display the variables\necho "<pre>";\nprint_r($all_vars);\necho "</pre>";\n?>