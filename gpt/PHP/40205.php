<?php\ntry {\n    // Connect to the Oracle database\n    $dsn = 'oci:dbname=//hostname:port/servicename';\n    $username = 'your_username';\n    $password = 'your_password';\n    $pdo = new PDO($dsn, $username, $password);\n\n    // Fetch the date ranges\n    $sql = "SELECT start_date, end_date FROM your_table";\n    $stmt = $pdo->query($sql);\n\n    $dateCounts = [];\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        $startDate = new DateTime($row['start_date']);\n        $endDate = new DateTime($row['end_date']);\n\n        // Iterate through each date in the range\n        for ($date = $startDate; $date <= $endDate; $date->modify('+1 day')) {\n            $formattedDate = $date->format('d-M-Y');\n            if (!isset($dateCounts[$formattedDate])) {\n                $dateCounts[$formattedDate] = 0;\n            }\n            $dateCounts[$formattedDate]++;\n        }\n    }\n\n    // Display the results\n    foreach ($dateCounts as $date => $count) {\n        echo "$date: $count\n";\n    }\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>