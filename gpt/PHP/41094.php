<?php\n$directory = '/path/to/your/directory';\n$files = scandir($directory);\n$currentTime = time();\n\nforeach ($files as $file) {\n    $filePath = $directory . '/' . $file;\n    if (is_file($filePath)) {\n        $lastModifiedTime = filemtime($filePath);\n        $timeDifference = $currentTime - $lastModifiedTime;\n        if ($timeDifference > 15) { // 15 seconds\n            unlink($filePath);\n        }\n    }\n}\n?>