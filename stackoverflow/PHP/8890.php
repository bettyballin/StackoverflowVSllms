<?php\n$a = "hola";\n\nfor($i=0; $i < strlen($a); $i++) {\n echo $a[$i] . "\n";\n\n}\n\n$a[2] = "-"; // will print ho-a\n?>