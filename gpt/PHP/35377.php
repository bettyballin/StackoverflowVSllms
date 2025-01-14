<?php\nfunction performHttpRequest($item) {\n    // Simulate an HTTP request and return a status (success or failure)\n    // In a real scenario, you would use something like cURL or file_get_contents()\n    return rand(0, 1) ? "Success" : "Failure";\n}\n\n$items = range(1, 100); // Example list of 100 items\n\nforeach ($items as $item) {\n    $status = performHttpRequest($item);\n    echo "Item {$item}: {$status}<br>";\n    \n    // Flush the output buffer\n    ob_flush();\n    flush();\n    \n    // Simulate a short delay for each request\n    usleep(50000); // 50 milliseconds\n}\n\n// End of script\necho "All items processed.";\n?>