<?php\n\n// Disable output buffering on some servers\nob_implicit_flush(true);\nob_end_clean();\n\nheader('Content-Type: text/plain');\nheader('Content-Disposition: attachment; filename="data.txt"');\n\n// Simulating a database query with many results\n$results = range(1, 5000); // Replace this with your real data source\n\nforeach ($results as $row) {\n    echo "Row Data: {$row}\n"; // Output each row of data\n    \n    // Flush output to the browser after sending each row\n    ob_flush();\n    flush();\n}\n\n?>