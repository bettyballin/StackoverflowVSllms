<?php\nfunction generateShortUniqueId($id) {\n    $characters = 'abcdefghijklmnopqrstuvwxyz';\n    $base = strlen($characters);\n    $shortId = '';\n\n    do {\n        $remainder = $id % $base;\n        $shortId = $characters[$remainder] . $shortId;\n        $id = (int)($id / $base);\n    } while ($id > 0);\n\n    return $shortId;\n}\n\n// Example usage:\n$id = 1234; // This could be your unique integer identifier\necho generateShortUniqueId($id); // Output might be something like 'zzz'\n?>