function execute_sql_file($filename) {\n    $handle = @fopen($filename, "r");\n    if (!$handle) return;\n\n    $lines_to_execute = '';\n    $inside_quotes = false;\n    \n    while (($line = fgets($handle)) !== false) {\n        // Skip comments and empty lines\n        if (strpos(trim($line), '--') === 0 || trim($line) == '') continue;\n\n        foreach (str_split($line) as $char) {\n            if ($char == '"' || $char == "'") {\n                $inside_quotes = !$inside_quotes;\n            }\n            \n            // If we hit a semicolon, and it's not inside quotes, execute the statement\n            if (!$inside_quotes && $char == ';') {\n                mysql_query($lines_to_execute);\n                $lines_to_execute = '';\n            } else {\n                $lines_to_execute .= $char;\n            }\n        }\n    }\n\n    // In case there is a query without a semicolon at the end of the file\n    if (trim($lines_to_execute) != '') {\n        mysql_query($lines_to_execute);\n    }\n    \n    fclose($handle);\n}\n\nexecute_sql_file('dump.sql');