// Prepare filters and values\n$values = array();\n$filters = array();\nforeach($item_list as $item){\n    $filters[] = "ItemNmbr = ?";\n    $filters[] = "ItemDesc LIKE ?";\n    $filters[] = "NoteText LIKE ?";\n    $values[] = $item;\n    $values[] = '%' . $item . '%';\n    $values[] = '%' . $item . '%';\n}\n\n// Prepare the query\n$sql = "SELECT ItemNmbr, ItemDesc, NoteText, Iden, BaseUOM FROM ItemMaster WHERE ";\n\n// Create a string of placeholders for the filters\n$placeholders = implode(" OR ", array_fill(0, count($filters), "?"));\n\n// Create the query with the placeholders\n$sql .= $placeholders . " LIMIT 21";\n\n// Set up the types\n$types = str_repeat("s", count($filters));\n\n// Create a new statement\n$stmt = $mysqli->stmt_init();\n\n// Prepare the statement\n$stmt->prepare($sql) or die ("Could not prepare statement:" . $mysqli->error);\n\n// Bind the parameters\n$stmt->bind_param($types, ...$values);\n\n// Execute the statement\n$stmt->execute() or die ("Could not execute statement");\n\n// Bind the result\n$stmt->bind_result($ItemNmbr, $ItemDesc, $NoteText, $Iden, $BaseUOM);\n\n// Fetch the results\n$results = array();\nwhile($stmt->fetch()) {\n    $results[] = array($ItemNmbr, $ItemDesc, $NoteText, $Iden, $BaseUOM);\n}\n\n// Close the statement\n$stmt->close();