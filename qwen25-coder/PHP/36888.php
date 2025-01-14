<?php\n$countAuctionsQuery = "SELECT COUNT(*) AS count FROM AUCTIONS WHERE username = ? AND SUBCAT = ?";\n$categories = ['fake', 'ok', 'sold']; // Add all your categories here\n\nif ($getRecords = $con->prepare($countAuctionsQuery)) {\n    $categoryCounts = [];\n\n    foreach ($categories as $subcat) {\n        $getRecords->bind_param("ss", $username, $subcat);\n        $getRecords->execute();\n        \n        // Bind result variables\n        $getRecords->bind_result($numRecords);\n        \n        // Fetch values\n        $getRecords->fetch();\n        \n        // Store the count in an associative array with category as key\n        $categoryCounts[$subcat] = $numRecords;\n    }\n    \n    // Close statement\n    $getRecords->close();\n    \n    // Output results\n    echo "Fake items: " . ($categoryCounts['fake'] ?? 0) . " items\n";\n    echo "OK items: " . ($categoryCounts['ok'] ?? 0) . " items\n";\n    echo "Sold items: " . ($categoryCounts['sold'] ?? 0) . " items\n";\n\n} else {\n    // Handle error\n    die("Error preparing statement: " . $con->error);\n}\n?>