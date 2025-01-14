function array_unique2($a) {\n    $n = [];\n    foreach ($a as $v) {\n        if (!isset($n[$v])) { // Use isset as it is faster than in_array for lookup\n            $n[] = $v;\n        }\n    }\n    return $n;\n}