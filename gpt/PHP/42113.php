<?php\nfunction today(){\n    $day = array("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");\n    $d = date("N");\n    switch ($d){\n        case 1: \n            echo $day[0];\n            break;\n        case 2:\n            echo $day[1];\n            break;\n        case 3:\n            echo $day[2];\n            break;\n        case 4:\n            echo $day[3];\n            break;\n        case 5:\n            echo $day[4];\n            break;\n        case 6:\n            echo $day[5];\n            break;\n        case 7:\n            echo $day[6];\n            break;\n    }\n} \ntoday();\n?>