<?php\n\nfunction removeTopLevels($path, $levelsToRemove) {\n    // Split the path into an array of directories\n    $directories = explode('/', trim($path, '/'));\n\n    // Remove the specified number of top levels\n    $slicedDirectories = array_slice($directories, $levelsToRemove);\n\n    // Join the remaining directories back into a path\n    return '/' . implode('/', $slicedDirectories) . '/';\n}\n\n$path = '/home/john/smith/web/test/testing/nothing/';\n$modifiedPath = removeTopLevels($path, 4);\necho $modifiedPath; // Outputs: /test/testing/nothing/