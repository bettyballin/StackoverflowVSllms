if (isset($newReplacement[1])) {\n    $newReplacement = substr_replace($newReplacement, '_', 1, 1);\n}\n\n// Optionally, if you want to ensure '_a' transformation only if the second char is '_' and first exists:\n/*if (isset($newReplacement[0]) && $newReplacement[1] === '_') {\n    $newReplacement = substr_replace($newReplacement, 'a', 1, 1);\n}*/