$code = file_get_contents('external.php');\n$code = trim($code, '<?php?>'); // remove PHP tags\neval($code);