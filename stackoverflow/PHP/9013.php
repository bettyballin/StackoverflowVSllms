<?php\n\n$css = <<<CSS\n#selector { display:block; width:100px; }\n#selector a { float:left; text-decoration:none }\nCSS;\n\n//\nfunction BreakCSS($css)\n{\n\n    $results = array();\n\n    preg_match_all('/(.+?)\s?\{\s?(.+?)\s?\}/', $css, $matches);\n    foreach($matches[0] AS $i=>$original)\n        foreach(explode(';', $matches[2][$i]) AS $attr)\n            if (strlen(trim($attr)) > 0) // for missing semicolon on last element, which is legal\n            {\n                list($name, $value) = explode(':', $attr);\n                $results[$matches[1][$i]][trim($name)] = trim($value);\n            }\n    return $results;\n}\nvar_dump(BreakCSS($css));