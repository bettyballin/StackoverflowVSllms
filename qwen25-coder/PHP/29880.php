<?php\n\n// Example local scope with some defined variables\n$a = 10;\n$b = "Hello, world!";\n$c = [1, 2, 3];\n\n// Get all variables in the current symbol table\n$defined_vars = get_defined_vars();\n\n// Output the list of variables and their values\nvar_export($defined_vars);\n\n?>