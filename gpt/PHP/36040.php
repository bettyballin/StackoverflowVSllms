<?php\nif (isset($_GET['x']) && isset($_GET['y'])) {\n    $x = filter_input(INPUT_GET, 'x', FILTER_VALIDATE_INT);\n    $y = filter_input(INPUT_GET, 'y', FILTER_VALIDATE_INT);\n\n    if ($x !== false && $y !== false) {\n        // Update the position in the database or perform other actions\n        // Ensure to use prepared statements to prevent SQL injection\n        echo "Position updated to ($x, $y)";\n    } else {\n        echo "Invalid input";\n    }\n} else {\n    echo "Missing parameters";\n}\n?>