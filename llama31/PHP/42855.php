<?php\n$method = $_GET['method'];\n$name = $_GET['name'];\n\nif (isset($GLOBALS["HTTP_RAW_POST_DATA"])) {\n    $pdf = $GLOBALS["HTTP_RAW_POST_DATA"];\n    $file = fopen("uploads/".$name, "wb");\n    fwrite($file, $pdf);\n    fclose($file);\n} else {\n    echo 'An error occured.';\n}\n?>