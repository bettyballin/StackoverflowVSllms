$string = '15M, 15.3M, 15T, 15.3T';\n\n$pattern = '/(\d+(?:\.\d+)?)([MT])/';\n$replacement = function($match) {\n    $value = $match[1];\n    $unit = $match[2];\n    switch ($unit) {\n        case 'M':\n            return (float)$value * 1000000;\n        case 'T':\n            return (float)$value * 1000;\n    }\n};\n\n$result = preg_replace_callback($pattern, $replacement, $string);\n\necho $result; // outputs: 15000000, 15300000, 15000, 15300