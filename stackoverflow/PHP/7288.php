<?php\nfunction generate_random_letters($length) {\n    $random = '';\n    for ($i = 0; $i < $length; $i++) {\n        $random .= chr(rand(ord('a'), ord('z')));\n    }\n    return $random;\n}