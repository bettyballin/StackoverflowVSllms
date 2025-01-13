<?php\n// Sample URL-encoded string\n$data = 'filter[0][field]=product&filter[0][data][type]=string&filter[0][data][value]=automobiles&filter[1][field]=price&filter[1][data][type]=numeric&filter[1][data][value]=6000';\n\n// Parse the URL-encoded string into an associative array\nparse_str($data, $output);\n\n// Now $output contains the parsed data\n$filters = $output['filter'];\n\nif (is_array($filters)) {\n    for ($i = 0; $i < count($filters); $i++) {\n        switch ($filters[$i]['data']['type']) {\n            case 'string':\n                // Handle string type filter\n                $field = $filters[$i]['field'];\n                $value = $filters[$i]['data']['value'];\n                echo "Field: $field, Value: $value\n";\n                break;\n            case 'numeric':\n                // Handle numeric type filter\n                $field = $filters[$i]['field'];\n                $value = $filters[$i]['data']['value'];\n                echo "Field: $field, Value: $value\n";\n                break;\n            // Add more cases as needed\n        }\n    }\n}\n?>