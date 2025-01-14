<?php    \n/* Copyright Date\n--------------------------*/\nfunction copyright_date($creation_year = null) {\n    $current_year = date('Y');\n\n    // Check if the creation year is null or an empty string\n    if ($creation_year === null || trim($creation_year) === '') {\n        echo $current_year;\n    } \n    else {\n        echo $creation_year . '-' . $current_year;\n    }           \n}\n\n// Example usage:\ncopyright_date();       // Outputs current year\ncopyright_date(2009);   // Outputs 2009-current_year\n?>