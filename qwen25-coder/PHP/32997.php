<?php\nfunction exportToCsv() {\n    // Close all open output buffers to ensure there's no extra output before headers are sent\n    ob_end_clean();\n\n    // Set the content type to CSV\n    header('Content-Type: text/csv');\n    header('Content-Disposition: attachment; filename="export.csv"');\n\n    // Open a file pointer connected to the output stream\n    $output = fopen('php://output', 'w');\n\n    // Write the headers or column names\n    fputcsv($output, array('fname', 'lname', 'MONTH', 'WeekdayCount', 'WeekendCount'));\n\n    // Assuming you have this data from your MySQL query\n    $data = array(\n        array('John', 'Doe', 8, 1, 0),\n        array('John', 'Doe', 7, 3, 2),\n        array('Jane', 'Smith', 7, 3, 2),\n    );\n\n    // Output the data\n    foreach ($data as $row) {\n        fputcsv($output, $row);\n    }\n\n    // Close the file pointer\n    fclose($output);\n\n    // Exit to prevent further output from the script\n    exit();\n}\n\n// Call this function when exporting\nexportToCsv();\n?>