<?php\n// Turn off output buffering\nob_implicit_flush(true);\nob_end_flush();\n\n$array = range(1, 100); // Example array with 100 items\n\nforeach ($array as $item) {\n    // Perform HTTP request here for each item\n    echo "Processing item {$item}: "; \n    \n    if (rand(0, 1)) { // Simulate success or failure randomly\n        echo "Success!\n";\n    } else {\n        echo "Failure.\n";   \n    }\n    \n    // Send the output immediately to the browser\n    flush();\n    ob_flush();\n\n    // Optional: Add a delay to mimic real processing time\n    sleep(1);\n}\n?>