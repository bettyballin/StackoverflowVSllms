while($row=mysqli_fetch_array($result)){\n    $task_id   = $row[0];\n    $parent_id = $row[1];\n    $task      = $row[2];\n\n    // Do something with the row data\n}