<?php\nif (isset($_GET['myarg']) && !empty($_GET['myarg'])) {\n    $arg = escapeshellarg($_GET['myarg']);\n    exec("/usr/bin/mycommand $arg", $output, $return_var);\n\n    if ($return_var === 0) {\n        echo "Command executed successfully. Output:\n";\n        print_r($output);\n    } else {\n        echo "Error executing command.";\n    }\n} else {\n    echo "No argument provided.";\n}\n?>