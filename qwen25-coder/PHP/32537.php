<?php\n// Set the timezone to GMT+8\ndate_default_timezone_set('Asia/Shanghai');\n\n// Create a new DateTime object for the current time\n$currentDateTime = new DateTime();\n\n// Add 30 minutes\n$currentDateTime->modify('+30 minutes');\n\n// Format and output the result\necho $currentDateTime->format('Y-m-d H:i:s');\n?>