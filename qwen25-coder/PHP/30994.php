<?php\n$dir = 'generated_images/';\n$files = glob($dir . "*.jpg");\n\nforeach ($files as $file) {\n    if (is_file($file) && filemtime($file) < time() - 3600) { // 1 hour ago\n        unlink($file);\n    }\n}