function nestify($arrs, $depth_key = 'depth')\n{\n    $nested = array();\n    $parents = array(0 => &$nested);\n\n    foreach ($arrs as $key => $arr) {\n        $parent =& $parents[$arr[$depth_key]];\n        \n        // Remove depth key if not needed in the final output\n        unset($arr[$depth_key]);\n        \n        // Prepare children array\n        $arr['children'] = array();\n        $parent[$key] = $arr;\n        \n        // Update parents for the next level\n        $parents[$arr[$depth_key] + 1] =& $parent[$key]['children'];\n    }\n\n    return reset($nested);\n}