<?php\n    $rar_file = rar_open('htdocs.rar') or die("Can't open Rar archive");\n\n    echo "RAR opened successfully.\n";\n    \n    rar_close($rar_file);\n    ?>