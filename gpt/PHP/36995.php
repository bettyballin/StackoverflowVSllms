<?php\n\nfunction openZip($file_to_open) {\n    global $target;\n    global $unique_folder;\n\n    // Ensure the target directory exists\n    if (!is_dir($target . $unique_folder)) {\n        mkdir($target . $unique_folder, 0755, true);\n    }\n\n    // Use exec to unzip the file\n    $command = 'unzip ' . escapeshellarg($file_to_open) . ' -d ' . escapeshellarg($target . $unique_folder);\n    exec($command, $output, $return_var);\n\n    if ($return_var === 0) {\n        unlink($file_to_open); // Deletes the zip file. We no longer need it.\n    } else {\n        die("There was a problem. Please try again!");\n    }\n}\n\n?>