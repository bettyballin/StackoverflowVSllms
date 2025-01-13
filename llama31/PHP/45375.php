<?php\n// Set the content type to text/event-stream\nheader('Content-Type: text/event-stream');\nheader('Cache-Control: no-cache');\n\n// Turn off output buffering\nob_end_clean();\n\nwhile (true) {\n    // Check for new data\n    $data = checkForNewData();\n\n    // If new data is available, send it to the client\n    if ($data) {\n        echo "data: $data\n\n";\n        flush();\n    }\n\n    // Sleep for a short period to avoid consuming too much CPU\n    usleep(100000); // 100ms\n}\n\n// Function to check for new data\nfunction checkForNewData() {\n    // Replace this with your own logic to check for new data\n    // Return the new data if available, or null if not\n}