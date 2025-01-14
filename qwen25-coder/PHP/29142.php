<?php\n// Assuming $conn is your database connection\n\n$sql = "SELECT s.scaleID, s.scaleParam1, s.scaleParam2, i.itemID, i.itemParam1, i.itemParam2\n        FROM scales AS s\n        LEFT JOIN items AS i ON s.scaleID = i.scaleID\n        ORDER BY s.scaleID, i.itemID;";\n\n$result = $conn->query($sql);\n\n$scales = [];\n\nif ($result->num_rows > 0) {\n    while ($row = $result->fetch_assoc()) {\n        if (!isset($scales[$row['scaleID']])) {\n            // Initialize the scale entry\n            $scales[$row['scaleID']] = [\n                'scaleParam1' => $row['scaleParam1'],\n                'scaleParam2' => $row['scaleParam2'],\n                'items' => []\n            ];\n        }\n\n        if ($row['itemID'] !== null) {\n            // Add item to the corresponding scale\n            $scales[$row['scaleID']]['items'][] = [\n                'itemParam1' => $row['itemParam1'],\n                'itemParam2' => $row['itemParam2']\n            ];\n        }\n    }\n}\n\n// Now you can loop through the scales and their items\nforeach ($scales as $scale) {\n    echo "Scale: {$scale['scaleParam1']}, {$scale['scaleParam2']}\n";\n    foreach ($scale['items'] as $item) {\n        echo "...Item: {$item['itemParam1']}, {$item['itemParam2']}\n";\n    }\n}\n?>