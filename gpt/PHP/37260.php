<?php\n\n$lua_code = <<<LUA\nNAME\n{\n    title\n    (\n        A_STRING\n    );\n\n    settings\n    {\n        SetA( 15, 15 );\n        SetB( "test" );\n    }\n\n    desc\n    {\n        Desc\n        (\n            A_STRING\n        );\n\n        Cond\n        (\n            A_STRING\n        );  \n    }\n}\nLUA;\n\nfunction parseLuaCode($code) {\n    $result = [];\n    $lines = explode("\n", $code);\n    $currentSection = null;\n    $currentSubSection = null;\n\n    foreach ($lines as $line) {\n        $line = trim($line);\n\n        if (empty($line) || $line === '{' || $line === '}') {\n            continue;\n        }\n\n        if (preg_match('/^(\w+)$/', $line, $matches)) {\n            $currentSection = $matches[1];\n            $result[$currentSection] = [];\n        } elseif (preg_match('/^(\w+)$/', $line, $matches)) {\n            $currentSubSection = $matches[1];\n            $result[$currentSection][$currentSubSection] = [];\n        } elseif (preg_match('/^(\w+)\s*\(\s*(.+?)\s*\)\s*;$/', $line, $matches)) {\n            $key = $matches[1];\n            $value = $matches[2];\n            $result[$currentSection][$currentSubSection][$key] = $value;\n        } elseif (preg_match('/^(\w+)\s*\(\s*(.+?)\s*\)\s*$/', $line, $matches)) {\n            $key = $matches[1];\n            $value = $matches[2];\n            $result[$currentSection][$key] = $value;\n        }\n    }\n\n    return $result;\n}\n\n$parsed_array = parseLuaCode($lua_code);\nprint_r($parsed_array);\n\n?>