<?php\n// index.php\ninclude("baz.php");\ninclude("foo.php");\n\n$variables = [\n    'x' => $x\n];\nfoo("bar.php", $variables);\n?>