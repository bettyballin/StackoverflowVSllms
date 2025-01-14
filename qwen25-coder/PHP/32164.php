<?php\n\n$input = <<<EOT\nNAME\n{\n    title\n    (\n        A_STRING\n    );\n\n    settings\n    {\n        SetA( 15, 15 );\n        SetB( "test" );\n    }\n\n    desc\n    {\n        Desc\n        (\n            A_STRING\n        );\n\n        Cond\n        (\n            A_STRING\n        );  \n    }\n}\nEOT;\n\n$array = [];\n$lines = explode("\n", $input);\n$currentSection = null;\n$subSection = null;\n\nforeach ($lines as $line) {\n    // Trim whitespace and remove semicolons\n    $line = trim($line, " ;\t\n\r");\n\n    if (empty($line)) continue; // Skip empty lines\n\n    // Check for main section like NAME, title, settings, desc\n    if (preg_match('/^\w+$/', $line) && !in_array(strtolower($line), ['title', 'settings', 'desc'])) {\n        $currentSection = $line;\n        $array[$currentSection] = [];\n    } elseif (in_array(strtolower($line), ['title', 'settings', 'desc'])) {\n        $subSection = strtolower($line);\n        $array[$currentSection][$subSection] = [];\n    } else {\n        // Matches functions with arguments\n        if (preg_match('/^(\w+)\s*\((.*?)\)$/', $line, $matches)) {\n            $funcName = $matches[1];\n            $args = trim($matches[2]);\n            if ($subSection) {\n                $array[$currentSection][$subSection][$funcName] = $args;\n            } else {\n                $array[$currentSection][$funcName] = $args;\n            }\n        }\n    }\n}\n\nprint_r($array);\n?>