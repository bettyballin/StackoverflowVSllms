<?php\nif (isset($_POST['pass_field'])) {\n    echo "Direct Post Value: ";\n    echo $_POST['pass_field']; // This should print 'BOSTON' if no filters are applied\n    echo "\nVar Dump Output: \n";\n    var_dump($_POST['pass_field']);\n} else {\n    echo "No POST data received.";\n}\n?>