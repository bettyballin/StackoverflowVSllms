function path_is_valid($path) {\n    $baseDir = 'sample/'; // trusted base directory path\n    $realPath = realpath($baseDir . $path);\n    return dirname($realPath) === realpath($baseDir);\n}