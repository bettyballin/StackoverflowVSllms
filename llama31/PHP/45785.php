$galleries = array(1, 2, 5);\n\n// Prepare the SQL query\n$sql = 'SELECT * FROM galleries WHERE id IN (' . implode(',', array_fill(0, count($galleries), '?')) . ')';\n$sth = $pdo->prepare($sql);\n$sth->execute($galleries);\n\n// Fetch the results\n$result = $sth->fetchAll();