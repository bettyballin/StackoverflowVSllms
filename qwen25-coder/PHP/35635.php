<?php\n$today = new DateTime();\n// Add 5 days (you can change '5' to any number of days you need)\n$today->modify('+5 days');\n$newDate = $today->format('Y:m:d');\necho $newDate;\n?>