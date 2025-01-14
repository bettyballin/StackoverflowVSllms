<?php\n// Assuming $row['receiver_name'] holds John Doe, Bill Smith, Dave Jones\n$names = explode(', ', $row['receiver_name']);\nif (count($names) > 1) {\n    // Take all but the last name...\n    $allButLast = array_slice($names, 0, -1);\n    // Take only the last name...\n    $last = end($names);\n    // Put it all back together with ", and" before the last\n    echo implode(', ', $allButLast) . ' and ' . $last;\n} else {\n    // If there's only one name, just output it\n    echo $row['receiver_name'];\n}\n?>