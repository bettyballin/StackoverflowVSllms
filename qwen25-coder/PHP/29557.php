<?php\n   if (!empty($_GET['id'])) {\n       $emailId = $_GET['id'];\n       // Record this in your database or a log file with a timestamp\n       file_put_contents('tracking_log.txt', "Email ID: $emailId opened at: " . date('Y-m-d H:i:s') . "\n", FILE_APPEND);\n   }\n   header("Content-Type: image/gif");\n   readfile("pixel.gif"); // Make sure to have a 1x1 transparent pixel.gif