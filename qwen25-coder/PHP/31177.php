// URL-encoded query string\n$queryString = "filter[0][field]=prodct&filter[0][data][type]=string&filter[0][data][value]=automobiles&filter[1][field]=price&filter[1][data][type]=numeric&filter[1][data][value]=6000";\n\n// Parse the query string into an array\nparse_str($queryString, $parsedData);\n\n// Main filter processing logic\n$filter = $parsedData['filter'];\nif (is_array($filter)) {\n    foreach ($filter as $i => $condition) {\n        switch ($condition['data']['type']) {\n            case 'string':\n                // Example: Build part of SQL query for string type\n                echo "Searching for {$condition['data']['value']} in {$condition['field']}\n";\n                break;\n            case 'numeric':\n                // Example: Build part of SQL query for numeric type\n                echo "Filtering {$condition['field']} greater than {$condition['data']['value']}\n";\n                break;\n            default:\n                // Handle other types if necessary\n        }\n    }\n}