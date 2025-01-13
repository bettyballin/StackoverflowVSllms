<?php\n   require 'vendor/autoload.php';\n\n   use PHPSQLParser\PHPSQLParser;\n\n   function parseInsertQuery($sql) {\n       $parser = new PHPSQLParser();\n       $parsed = $parser->parse($sql);\n\n       $table = $parsed['INSERT'][0]['table'];\n       $columns = $parsed['VALUES'][0]['columns'];\n       $values = $parsed['VALUES'][0]['values'];\n\n       $result = [\n           'table' => $table,\n           'columns' => $columns,\n           'values' => $values\n       ];\n\n       return $result;\n   }\n\n   function parseUpdateQuery($sql) {\n       $parser = new PHPSQLParser();\n       $parsed = $parser->parse($sql);\n\n       $table = $parsed['UPDATE'][0]['table'];\n       $set = $parsed['SET'];\n       $where = $parsed['WHERE'];\n\n       $result = [\n           'table' => $table,\n           'set' => $set,\n           'where' => $where\n       ];\n\n       return $result;\n   }\n\n   // Example usage\n   $insertQuery = "INSERT INTO users (id, name, email) VALUES (1, 'John Doe', 'john@example.com')";\n   $updateQuery = "UPDATE users SET name = 'Jane Doe', email = 'jane@example.com' WHERE id = 1";\n\n   print_r(parseInsertQuery($insertQuery));\n   print_r(parseUpdateQuery($updateQuery));\n   ?>