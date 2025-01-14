<?php\n$input_date = '03-JUL-09 14';\n\n// Check if the input date time part is missing minutes\nif (preg_match('/\d{2}:\d{2}/', $input_date) === 0) {\n    // Append ':00' to the time part if minutes are missing\n    $input_date .= ':00';\n}\n\n$formatted_date =  date("Y-m-d H:i:s", strtotime($input_date));\n\necho $formatted_date;\n?>