<?php\n// imageHandler.php\n$imageFile = 'someImage.jpg';\n$startTime = microtime(true);\nheader('Content-Type: image/jpeg');\nheader('Expires: ' . gmdate('D, d M Y H:i:s', strtotime('+1 year')) . ' GMT');\nreadfile($imageFile);\n$endTime = microtime(true);\necho "Time taken: " . ($endTime - $startTime) . " seconds";\nexit;