<?php\n$strings = [\n    '>Data 1-23</a>',\n    '>Datkl3</a>',\n    '>RA Ndom</a>'\n];\n\n$pattern = '/>([A-Za-z\s\d\-]+)</';\n$results = [];\n\nforeach ($strings as $string) {\n    if (preg_match($pattern, $string, $matches)) {\n        $results[] = trim($matches[1]);\n    }\n}\n\nprint_r($results);\n?>