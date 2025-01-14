// Assuming $table and $brand are already properly defined and sanitized\n\n$countQuery = "SELECT ARTICLE_NO FROM $table WHERE upper(ARTICLE_NAME) LIKE ?";\n\nif ($numRecords = $con->prepare($countQuery)) {\n    // Add the wildcards to the $brand variable\n    $brandParam = '%' . strtoupper($brand) . '%';\n    \n    // Bind the parameter. Only bind one parameter since the table name is directly inserted\n    $numRecords->bind_param("s", $brandParam);\n    \n    // Execute the query\n    $numRecords->execute();\n    \n    // Get the result\n    $result = $numRecords->get_result();\n    \n    // Check the number of rows\n    $rowcount = $result->num_rows;\n    \n    // Fetch rows as needed\n    $rows = getRowsByArticleSearch($query, $table, $max);\n    \n    // Calculate the last page number\n    $last = ceil($rowcount / $page_rows);\n    \n    // Close the statement\n    $numRecords->close();\n} else {\n    die("Error preparing statement: " . $con->error);\n}