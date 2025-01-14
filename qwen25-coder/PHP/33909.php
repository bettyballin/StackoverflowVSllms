// Prepare filters and values\n$values = array();\n$filters = array();\n\nforeach ($item_list as $item) {\n    // For each item, add conditions for both ItemNmbr and ItemDesc/NoteText with LIKE\n    $filters[] = "(ItemNmbr = ? OR ItemDesc LIKE ? OR NoteText LIKE ?)";\n    $values[] = $item;\n    $values[] = '%' . $item . '%';\n    $values[] = '%' . $item . '%';\n}\n\n// Prepare the query dynamically based on the number of filters\n$sql = "SELECT ItemNmbr, ItemDesc, NoteText, Iden, BaseUOM FROM ItemMaster WHERE (" .\n       implode(") OR (", $filters) . ") LIMIT 21";\n\n// Set up the types array for bind_param\n$types = str_repeat('s', count($values));\n\n// Prepare and execute statement\n$stmt = $mysqli->stmt_init();\nif (!$stmt->prepare($sql)) {\n    die("Could not prepare statement: " . $mysqli->error);\n}\n\n// Bind parameters dynamically\ncall_user_func_array(array($stmt, 'bind_param'), array_merge((array)$types, $values));\n\n// Execute and bind result variables\n$stmt->execute() or die("Could not execute statement");\n$stmt->store_result();