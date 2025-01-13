<?php\nfunction getDirectorySize($dir) {\n    $size = 0;\n    foreach (new RecursiveIteratorIterator(new RecursiveDirectoryIterator($dir, FilesystemIterator::SKIP_DOTS)) as $file) {\n        $size += $file->getSize();\n    }\n    return $size;\n}\n\nfunction getDirectorySizes($dir) {\n    $result = [];\n    foreach (new DirectoryIterator($dir) as $fileInfo) {\n        if ($fileInfo->isDot()) continue;\n        if ($fileInfo->isDir()) {\n            $path = $fileInfo->getPathname();\n            $result[$path] = getDirectorySize($path);\n        }\n    }\n    return $result;\n}\n\n$mainDir = '/path/to/your/main/folder';\n$sizes = getDirectorySizes($mainDir);\n\necho "<pre>";\nforeach ($sizes as $dir => $size) {\n    echo "Directory: $dir - Size: " . formatSize($size) . "\n";\n}\necho "</pre>";\n\nfunction formatSize($size) {\n    $units = ['B', 'KB', 'MB', 'GB', 'TB'];\n    for ($i = 0; $size >= 1024 && $i < count($units) - 1; $i++) {\n        $size /= 1024;\n    }\n    return round($size, 2) . ' ' . $units[$i];\n}\n?>