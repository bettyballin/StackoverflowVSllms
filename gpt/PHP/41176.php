<?php\n\n$str1 = '';\n$str2 = null;\n$str3 = false;\n$str4 = 0;\n\nvar_dump($str1 == ''); // true\nvar_dump($str2 == ''); // true\nvar_dump($str3 == ''); // true\nvar_dump($str4 == ''); // true\n\nvar_dump(strlen($str1) == 0); // true\n// The following lines will generate warnings because strlen expects a string\n// var_dump(strlen($str2) == 0); // Warning\n// var_dump(strlen($str3) == 0); // Warning\n// var_dump(strlen($str4) == 0); // Warning\n\n?>