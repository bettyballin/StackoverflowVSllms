$rows = $db->fetchAll("select ...");\n$numRows = sizeof($rows);\nforeach ($rows as $row)\n{\n  // process each row\n}