$newArr = array_intersect_key($arr1, $arr2);\nforeach ($newArr as $key => $val)\n{\n    if (is_array($val))\n    {\n        $newArr[$key] = array_merge($arr1[$key], $arr2[$key]);\n    }\n}