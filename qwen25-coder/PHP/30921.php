<?php\n$day = array("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo");\n\nfunction today(){\n    global $day; // Declare $day as global to use it inside this function\n    $d = date("N");\n    echo $day[$d - 1]; // Adjust index by subtracting 1 since array indices start at 0\n}\n\ntoday();\n?>