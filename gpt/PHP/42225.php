<?php\n$path = '/home/john/smith/web/test/testing/nothing/';\n\nfunction remove_levels($path, $levels_to_remove) {\n    // Split the path into an array\n    $parts = explode('/', trim($path, '/'));\n    \n    // Remove the specified number of levels\n    $remaining_parts = array_slice($parts, $levels_to_remove);\n    \n    // Reconstruct the path\n    $new_path = '/' . implode('/', $remaining_parts) . '/';\n    \n    return $new_path;\n}\n\n$new_path = remove_levels($path, 4);\necho $new_path;\n?>