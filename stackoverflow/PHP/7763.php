<?php\n\nfunction array_depth(array $array) {\n    $max_depth = 1;\n\n    foreach ($array as $value) {\n        if (is_array($value)) {\n            $depth = array_depth($value) + 1;\n\n            if ($depth > $max_depth) {\n                $max_depth = $depth;\n            }\n        }\n    }\n\n    return $max_depth;\n}\n\n?>