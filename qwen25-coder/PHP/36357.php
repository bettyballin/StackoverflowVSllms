<?php\n$dataArray = $_GET; // Assuming input from GET request\n\n// Sort the array by key in ascending order\nksort($dataArray);\n\nforeach ($dataArray as $field => $label) {\n    echo "$field :$label<br>";\n}\n?>