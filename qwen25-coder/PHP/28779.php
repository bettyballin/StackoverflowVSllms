function list_recursivedirectoryiterator_optimized($path) {\n    $it = new RecursiveIteratorIterator(\n        new RecursiveDirectoryIterator($path),\n        RecursiveIteratorIterator::SELF_FIRST,\n        RecursiveIteratorIterator::CATCH_GET_CHILD // Handle errors silently\n    );\n\n    foreach ($it as $fileinfo => $file) {\n        if (!$file->isDot()) {\n            echo $fileinfo . PHP_EOL;\n        }\n    }\n}