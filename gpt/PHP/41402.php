<?php\n\n$total_time = 348;\n$converted_seconds = 0;\n\nwhile ($converted_seconds <= $total_time) {\n    $converted_percentage = intval(($converted_seconds / $total_time) * 100);\n    $progress_bar = str_repeat("=", intval($converted_percentage / 10)) . str_repeat(" ", 10 - intval($converted_percentage / 10));\n\n    // Print the progress bar\n    echo "\rConversion: $converted_seconds/$total_time Seconds   |$progress_bar|  $converted_percentage%";\n\n    // Flush the output buffer\n    flush();\n\n    // Simulate some processing time\n    usleep(50000); // 50 milliseconds\n\n    // Increment the converted seconds\n    $converted_seconds += 2;\n}\n\necho "\n"; // Move to the next line after the loop finishes\n?>