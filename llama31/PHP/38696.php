use PhpMyAdmin\SqlParser\Parser;\nuse PhpMyAdmin\SqlParser\Statement;\n\n$parser = new Parser($query);\n$stmt = $parser->statements[0];\n\nif ($stmt instanceof Statement\InsertStatement) {\n    $insertData = $stmt->getValues();\n    $table = $stmt->getTable();\n    // process insert data\n} elseif ($stmt instanceof Statement\UpdateStatement) {\n    $updateData = $stmt->getSet();\n    $table = $stmt->getTable();\n    $where = $stmt->getWhere();\n    // process update data\n}