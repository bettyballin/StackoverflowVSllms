<?php\nfunction ago($time) {\n    $now = new DateTime;\n    $ago = new DateTime($time);\n    $diff = $now->diff($ago);\n\n    $output = '';\n    if ($diff->y > 0) {\n        $output .= $diff->y . ' year' . ($diff->y > 1 ? 's' : '') . ' ';\n    }\n    if ($diff->m > 0) {\n        $output .= $diff->m . ' month' . ($diff->m > 1 ? 's' : '') . ' ';\n    }\n    if ($diff->d > 0) {\n        $output .= $diff->d . ' day' . ($diff->d > 1 ? 's' : '');\n    }\n\n    return trim($output) . ' ago';\n}\n\necho ago('2008-04-23');\n?>