while ($line = fgets($fh)) {\n    //echo "Evaluating... $line <br>";\n    if ((stripos($line, '$table_id') !== false) || (stripos($line, '$screen') !== false)) {\n        // TODO: Not evaluating tableid and screen lines correctly fix.\n        // Set $table_id and $screen variables from task scripts\n        eval($line);\n    }\n\n    if (stripos($line, 'require') !== false) {\n        $controller = $line;\n    }\n}