foreach ($item as $key => $value) {\n    if (!isset($arr[$key])) {\n        $arr[$key] = 0; \n    }\n    $arr[$key] += $other_arr[$value];\n}